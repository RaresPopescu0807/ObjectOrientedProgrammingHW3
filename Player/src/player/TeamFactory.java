/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.util.HashMap;

/**
 *
 * @author Rares
 */
public class TeamFactory
{

    public HashMap<String,Team> allTeams;
    private static TeamFactory uniqueInstance = null;
// alte variabile

    private TeamFactory()
    {
        this.allTeams=new HashMap<>();
    }

    public static TeamFactory getInstance()
    {
        if (uniqueInstance == null)
        {
            uniqueInstance = new TeamFactory();
        }
        return uniqueInstance;
    }

    public Team createTeam(String type,String teamName,String gender,int numberOfPlayers)
    {

        Team team = null;
        if (type.equals("football"))
        {
            team = new FootballTeam(teamName,gender,numberOfPlayers);
        } else if (type.equals("handball"))
        {
            team = new HandballTeam(teamName,gender,numberOfPlayers);
        } else if (type.equals("basketball"))
        {
            team = new BasketballTeam(teamName,gender,numberOfPlayers);
        }
        this.allTeams.put(teamName, team);
        return team;
    }
    
}
