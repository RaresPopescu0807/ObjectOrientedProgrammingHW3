/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.util.ArrayList;

/**
 *
 * @author Rares
 */
public class Competition implements Subject
{

    public String type;
    public String gender;
    public ArrayList<Team> teams;
    public ArrayList<String> clasament;

    public Competition(String type, String gender)
    {
        this.type = type.substring(0, type.length() - 1);
        this.gender = gender;
        this.teams = new ArrayList<>();
        this.clasament = new ArrayList<>();
    }

    public void addTeam(Team team)
    {
        if (team.gender.equals(this.gender))
        {
            if (((team instanceof FootballTeam) && ("football".equals(this.type))) || ((team instanceof HandballTeam) && ("handball".equals(this.type))) || ((team instanceof BasketballTeam) && ("basketball".equals(this.type))))
            {
                this.teams.add(team);

            }
        }
    }

    public void compute()
    {
        Visitor calc;
        if ("masculin".equals(this.gender))
        {
            calc = new MaleTeamVisitor();
        } else
        {
            calc = new FemaleTeamVisitor();
        }
        for (Team t1 : this.teams)
        {
            for (Team t2 : this.teams)
            {
                if (t1 != t2)
                {
                    if (t1.accept(calc) == t2.accept(calc))
                    {
                        t1.points += 1;
                        t2.points += 1;
                    }
                    if (t1.accept(calc) > t2.accept(calc))
                    {
                        t1.points += 3;
                    }
                    if (t1.accept(calc) < t2.accept(calc))
                    {
                        t2.points += 3;
                    }
                }
            }
        }
        makeClasament();
        display();
        
    }

    public void makeClasament()
    {
        ArrayList<Team> teamsAux=this.teams;
        int i;
        for (i = 1; i <= teamsAux.size(); i++)
        {
            int index=0;
            int max=-1;
            
            for (Team t : teamsAux)
            {
                if(t.points>max)
                {
                    max=t.points;
                    index=teamsAux.indexOf(t);
                }
            }
            this.clasament.add(teamsAux.get(index).teamName);
            teamsAux.get(index).points=-1;
        }
        notifyObservers();
    }
    
    public void display()
    {
        System.out.println(this.clasament.get(0));
        System.out.println(this.clasament.get(1));
        System.out.println(this.clasament.get(2));
        for (Team t : this.teams)
        {
            t.printStanding();
        }
    }



    @Override
    public void notifyObservers()
    {
        for (Team t : this.teams)
        {
            t.update(this.clasament.indexOf(t.teamName)+1);
        }
    }

}
