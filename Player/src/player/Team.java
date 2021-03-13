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

public abstract class Team implements Visitable, Observer
{
    public String teamName;
    public String gender;
    public int numberOfPlayers;
    public ArrayList<Player> players;
    public int points;
    public int standing;
    
    public void update(int standing)
    {
        this.standing=standing;
    }

    public Team()
    {
    }

    public Team(String teamName, String gender, int numberOfPlayers)
    {
        this.teamName = teamName;
        this.gender = gender;
        this.numberOfPlayers = numberOfPlayers;
        this.players=new ArrayList<>(numberOfPlayers);
        this.points=0;
        this.standing=-1;
    }
    
    public void addPlayer(String name,int score)
    {
            this.players.add(new Player(name.substring(0,name.length()-1),score));
    }
    public void print()
    {
        System.out.print("{teamName: "+this.teamName+", gender: "+this.gender+", numberOfPlayers: "+this.numberOfPlayers+", players: [");
        System.out.print("{name: "+this.players.get(0).name+", score: "+this.players.get(0).score+"}");
        int i;
        for(i=1;i<this.numberOfPlayers;i++)
            System.out.print(", {name: "+this.players.get(i).name+", score: "+this.players.get(i).score+"}");
        System.out.println("]}");
    }
    public void printStanding()
    {
        System.out.print("Echipa "+this.teamName+" a ocupat locul ");
            System.out.println(this.standing);
    }
}
