/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author Rares
 */
public class FemaleTeamVisitor implements Visitor
{

        public double visit(FootballTeam team)
    {
        double min=team.players.get(0).score;
        double s=0;
        for(Player p : team.players)
        {
            s=s+p.score;
            if(p.score<min)
                min=p.score;
        }
        s=s+min;
        return s;
            
        
    }

    public double visit(HandballTeam team)
    {
        double s=1;
        for(Player p : team.players)
        {
            s=s*p.score;
        }
        return s;
    }

    public double visit(BasketballTeam team)
    {
        double s=0;
        for(Player p : team.players)
        {
            s=s+p.score;
        }
        return s/team.numberOfPlayers;
    }
    
}
