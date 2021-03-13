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
// The visitor pattern is used when you have to perform
// the same action on many objects of different types

interface Visitor {
	
	// Created to automatically use the right 
	// code based on the Object sent
	// Method Overloading
	
	//public double visit(Liquor liquorItem);
	public double visit(FootballTeam team);
        public double visit(HandballTeam team);
        public double visit(BasketballTeam team);
	
}
