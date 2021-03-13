/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Rares
 */
public class Player
{

    /**
     * @param args the command line arguments
     */
    public String name;
    public int score;

    public Player()
    {
    }

    public Player(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        // TODO code application logic here
        TeamFactory teamFactory = TeamFactory.getInstance();
        File file = new File(args[1]);
        Scanner scan = new Scanner(file);
        PrintStream o = new PrintStream(new File(args[3]));
        System.setOut(o);
        String l = null;
        while (scan.hasNext())
        {
            if (l != null)
            {
                scan.nextLine();
            }
            l = scan.nextLine();
            //System.out.println(l);
            Scanner s = new Scanner(l);
            s.useDelimiter(", ");
            Team team = teamFactory.createTeam(s.next(), s.next(), s.next(), s.nextInt());
            int i;
            for (i = 1; i <= team.numberOfPlayers; i++)
            {
                //l=scan.nextLine();
                //s=new Scanner(l);
                //s.useDelimiter(", ");
                team.addPlayer(scan.next(), scan.nextInt());
            }
            if ("inscriere".equals(args[0]))
            {
                team.print();
                //System.out.println(team instanceof FootballTeam);
            }
        }
        if("competitie".equals(args[0]))
        {
            file = new File(args[2]);
            scan = new Scanner(file);
            Competition competition=new Competition(scan.next(), scan.next());
            scan.nextLine();
            while(scan.hasNext())
                competition.addTeam(teamFactory.allTeams.get(scan.nextLine()));
            competition.compute();
        }

    }

}
