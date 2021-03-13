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
public class BasketballTeam extends Team
{

    public BasketballTeam(String teamName, String gender, int numberOfPlayers)
    {
        super(teamName, gender, numberOfPlayers);
    }
    
    public double accept(Visitor visitor)
    {
        return visitor.visit(this);
    }
    
}
