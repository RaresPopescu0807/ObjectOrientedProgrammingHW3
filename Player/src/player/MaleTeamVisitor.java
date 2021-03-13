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
public class MaleTeamVisitor implements Visitor
{

    @Override
    public double visit(FootballTeam team)
    {
        double max=0;
        double s=0;
        for(Player p : team.players)
        {
            s=s+p.score;
            if(p.score>max)
                max=p.score;
        }
        s=s+max;
        return s;
            
        
    }

    @Override
    public double visit(HandballTeam team)
    {
        double s=0;
        for(Player p : team.players)
        {
            s=s+p.score;
        }
        return s;
    }

    @Override
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
