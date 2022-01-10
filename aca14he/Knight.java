package uk.ac.sheffield.aca14he;

import java.util.ArrayList;

/**
 * Knight.java 
 *
 * Concrete class to represent a knight
 *
 * @author aca14he
 */

public class Knight extends Piece {

	public Knight (int ix, int iy, int c, Board b) {
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}

	// method implements abstract method in Piece class
	public ArrayList<Move> availableMoves() {
		int x = getX();
		int y = getY();

		// create a new vector to store legal moves
		ArrayList<Move> v = new ArrayList<Move>();

		// set up m to refer to a Move object  
		Move m = null;

		// first legal move is to go from (x,y) to (x+1,y-2)
		//if the position is not outside the board
		if(!getBoard().outOfRange(x+1, y-2)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x+1, y-2) && (getBoard().getPiece(x+1, y-2).getColour()!=this.getColour())){	
				m = new Move(this, x,getY(),x+1,y-2,true);
				v.add(m);
			}
			//if the position is not occupied
			if(!getBoard().occupied(x+1, y-2))	{
				m = new Move(this, x,getY(),x+1,y-2,false);
				v.add(m);
			}
		}

		// second legal move is to go from (x,y) to (x+2,y-1)	
		//if the position is not outside the board
		if(!getBoard().outOfRange(x+2, y-1)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x+2, y-1) && (getBoard().getPiece(x+2, y-1).getColour()!=this.getColour())){	
				m = new Move(this, x,getY(),x+2,y-1,true);
				v.add(m);
			}

			//if the position is not occupied
			if(!getBoard().occupied(x+2, y-1)){	
				m = new Move(this, x,getY(),x+2,y-1,false);
				v.add(m);
			}
		} 

		// third legal move is to go from (x,y) to (x+2,y+1)
		//if the position is not outside the board
		if(!getBoard().outOfRange(x+2, y+1)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x+2, y+1) && (getBoard().getPiece(x+2, y+1).getColour()!=this.getColour())){	 	 
				m = new Move(this, x,getY(),x+2,y+1,true);
				v.add(m);					
			}
			//if the position is not occupied
			if(!getBoard().occupied(x+2, y+1)){	 	 
				m = new Move(this, x,getY(),x+2,y+1,false);
				v.add(m);
			}
		}

		// fourth legal move is to go from (x,y) to (x+1,y+2)
		//if the position is not outside the board
		if(!getBoard().outOfRange(x+1, y+2)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x+1, y+2) && (getBoard().getPiece(x+1, y+2).getColour()!=this.getColour())){	 
				m = new Move(this, x,getY(),x+1,y+2,true);
				v.add(m);
			}
			//if the position is not occupied
			if(!getBoard().occupied(x+1, y+2))	{
				m = new Move(this, x,getY(),x+1,y+2,false);
				v.add(m);
			}
		}		

		// fifth legal move is to go from (x,y) to (x-1,y+2)
		//if the position is not outside the board
		if(!getBoard().outOfRange(x-1, y+2)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x-1, y+2) && (getBoard().getPiece(x-1, y+2).getColour()!=this.getColour())){	 
				m = new Move(this, x,getY(),x-1,y+2,true);
				v.add(m);
			}

			//if the position is not occupied
			if(!getBoard().occupied(x-1, y+2)){	 
				m = new Move(this, x,getY(),x-1,y+2,false);
				v.add(m);
			}

		}

		// sixth legal move is to go from (x,y) to (x-2,y+1)

		//if the position is not outside the board
		if(!getBoard().outOfRange(x-2, y+1)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x-2, y+1) && (getBoard().getPiece(x-2, y+1).getColour()!=this.getColour())){	 
				m = new Move(this, x,getY(),x-2,y+1,true);
				v.add(m);
			}

			//if the position is not occupied
			if(!getBoard().occupied(x-2, y+1)){	 
				m = new Move(this, x,getY(),x-2,y+1,false);
				v.add(m);
			}

		}		

		// seventh legal move is to go from (x,y) to (x-2,y-1)
		//if the position is not outside the board
		if(!getBoard().outOfRange(x-2, y-1)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x-2, y-1) && (getBoard().getPiece(x-2, y-1).getColour()!=this.getColour())){	
				m = new Move(this, x,getY(),x-2,y-1,true);
				v.add(m);
			}

			//if the position is not occupied
			if(!getBoard().occupied(x-2, y-1)){	
				m = new Move(this, x,getY(),x-2,y-1,false);
				v.add(m);
			}

		}

		// eighth legal move is to go from (x,y) to (x-1,y-2)
		//if the position is not outside the board
		if(!getBoard().outOfRange(x-1, y-2)){

			//if the position is occupied with a different colour
			if(getBoard().occupied(x-1, y-2) && (getBoard().getPiece(x-1, y-2).getColour()!=this.getColour())){	 
				m = new Move(this, x,getY(),x-1,y-2,true);
				v.add(m);
			}

			//if the position is not occupied
			if(getBoard().occupied(x-1, y-2)){	 
				m = new Move(this, x,getY(),x-1,y-2,false);
				v.add(m);
			}		 
		}

		if (v.isEmpty()) return null;
		return v;
	}	  
}