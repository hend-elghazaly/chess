package uk.ac.sheffield.aca14he;

import java.util.ArrayList;

/**
 * King.java 
 *
 * Concrete class to represent a king
 *
 * @author aca14he
 */

public class King extends Piece {

	public King (int ix, int iy, int c, Board b) {
		super(PieceCode.KING, ix, iy, c, b);
	}

	// method implements abstract method in Piece class
	public ArrayList<Move> availableMoves() {

		int x = getX();
		int y = getY();


		// create a new vector to store legal moves
		ArrayList<Move> v = new ArrayList<Move>();

		// set up m to refer to a Move object  
		Move m = null;


		// first legal move is to go from (x,y) to (x,y-1)
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x, y-1) && getBoard().occupied(x, y-1)
				&& (getBoard().getPiece(x, y-1).getColour()!=this.getColour()))
			m = new Move(this, x,y,x,y-1,true);
		v.add(m);
		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x, y-1) && !getBoard().occupied(x, y-1))
			m = new Move(this, x,y,x,y-1,false);
		v.add(m);

		//second legal move is to go from (x,y) to (x+1,y-1)    
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x+1, y-1) && getBoard().occupied(x+1, y-1)
				&& (getBoard().getPiece(x+1, y-1).getColour()!=this.getColour()))
			m = new Move(this, x,y,x+1,y-1,true);
		v.add(m);
		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x+1, y-1) && !getBoard().occupied(x+1, y-1))
			m = new Move(this, x,y,x+1,y-1,false);
		v.add(m);

		//third legal move is to go from (x,y) to (x+1,y)
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x+1, y) && getBoard().occupied(x+1, y)
				&& (getBoard().getPiece(x+1, y).getColour()!=this.getColour()))
			m = new Move(this, x,y,x+1,y,true);
		v.add(m);
		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x+1, y) && !getBoard().occupied(x+1, y))
			m = new Move(this, x,y,x+1,y,false);
		v.add(m);    

		// fourth legal move can go from (x,y) to (x+1,y+1) 
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x+1, y+1) && getBoard().occupied(x+1, y+1)
				&& (getBoard().getPiece(x+1, y+1).getColour()!=this.getColour()))
			m = new Move(this, x,y,x+1,y+1,true);
		v.add(m);

		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x+1, y+1) && !getBoard().occupied(x+1, y+1))
			m = new Move(this, x,y,x+1,y+1,false);
		v.add(m);


		// fifth legal move is to go from (x,y) to (x,y+1) 
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x, y+1) && getBoard().occupied(x, y+1)
				&& (getBoard().getPiece(x, y+1).getColour()!=this.getColour()))
			m = new Move(this, x,y,x,y+1,true);
		v.add(m);
		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x, y+1) && !getBoard().occupied(x, y+1))
			m = new Move(this, x,y,x,y+1,false);
		v.add(m);


		// sixth legal move is to go from (x,y) to (x-1,y+1) 
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x-1, y+1) && getBoard().occupied(x-1, y+1)
				&& (getBoard().getPiece(x-1, y+1).getColour()!=this.getColour()))
			m = new Move(this, x,y,x-1,y+1,true);
		v.add(m);
		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x-1, y+1) && !getBoard().occupied(x-1, y+1))     
			m = new Move(this, x,y,x-1,y+1,false);
		v.add(m);


		// seventh legal move is to go from (x,y) to (x-1,y)
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x-1, y) && getBoard().occupied(x-1, y)
				&& (getBoard().getPiece(x-1, y).getColour()!=this.getColour()))
			m = new Move(this, x,y,x-1,y,true);
		v.add(m);   
		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x-1, y) && !getBoard().occupied(x-1, y))     	      
			m = new Move(this, x,y,x-1,y,false);
		v.add(m);     


		// eighth legal move is to go from (x,y) to (x-1,y-1) 
		//if the position is occupied but not the same colour and not outside the board
		if(!getBoard().outOfRange(x-1, y-1) && getBoard().occupied(x-1, y-1)
				&& (getBoard().getPiece(x-1, y-1).getColour()!=this.getColour()))
			m = new Move(this, x,y,x-1,y-1,true);
		v.add(m);
		//if the position is unoccupied and not outside the board
		if(!getBoard().outOfRange(x-1, y-1) && !getBoard().occupied(x-1, y-1))        
			m = new Move(this, x,y,x-1,y-1,false);
		v.add(m);

		if (v.isEmpty()) return null;
		return v;

	}
}