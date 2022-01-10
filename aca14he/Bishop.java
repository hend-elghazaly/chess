package uk.ac.sheffield.aca14he;

import java.util.ArrayList;

/**
 * Bishop.java 
 *
 * Concrete class to represent a bishop
 *
 * @author aca14he
 */


public class Bishop extends Piece {

	public Bishop (int ix, int iy, int c, Board b) {
		super(PieceCode.BISHOP, ix, iy, c, b);
	}

	// method implements abstract method in Piece class
	public ArrayList<Move> availableMoves() {
		int x = getX();
		int y = getY();

		int i,j;

		// create a new vector to store legal moves
		ArrayList<Move> v = new ArrayList<Move>();

		// set up m to refer to a Move object  
		Move m = null;

		//the bishop can move any number of squares diagonally 
		if(y>=0){    //starting position or anywhere on the board
			//right diagonally upwards
			for(i= x+1, j= y-1; i<=7 && j<=7; i-- , j++){
				//if unoccupied
				if(!getBoard().outOfRange(x+1, y-1) && !getBoard().occupied(x+1, y-1)){
					m = new Move(this, getX(),getY(),i,j,false);
					v.add(m); 
				}
				//if occupied with the same colour, it should stop at its current position/ not make any further move 
				if(!getBoard().outOfRange(x+1, y-1) && getBoard().occupied(x+1, y-1)
						&& (getBoard().getPiece(x+1, y-1).getColour()==this.getColour())){
					break;
				}
				//if occupied with a different colour, it should remove it and take its position
				if(!getBoard().outOfRange(x+1, y-1) && getBoard().occupied(x+1, y-1)
						&& (getBoard().getPiece(x+1, y-1).getColour()!=this.getColour())){
					m = new Move(this, getX(),getY(),i,j,true);
					v.add(m);
				} 
			}

			//right diagonally downwards
			for(i= x+1, j= y+1; i<=7 && j<=7; i++ , j++){
				//if unoccupied
				if(!getBoard().outOfRange(x+1, y+1) && !getBoard().occupied(x+1, y+1)){
					m = new Move(this, getX(),getY(),i,j,false);
					v.add(m);
				}
				//if occupied with the same colour, it should stop at its current position 
				if(!getBoard().outOfRange(x+1, y+1) && getBoard().occupied(x+1, y+1)
						&& (getBoard().getPiece(x+1, y+1).getColour()==this.getColour())){
					break;
				}
				//if occupied with a different colour, it should remove it and take its position
				if(!getBoard().outOfRange(x+1, y+1) && getBoard().occupied(x+1, y+1)
						&& (getBoard().getPiece(x+1, y+1).getColour()!=this.getColour())){
					m = new Move(this, getX(),getY(),i,j,true);
					v.add(m);
				} 
			}

			//left diagonally upwards
			for(i= x-1, j= y-1; i<=7 && j<=7; i-- , j--){
				//if unoccupied
				if(!getBoard().outOfRange(x-1, y-1) && !getBoard().occupied(x-1, y-1)){
					m = new Move(this, getX(),getY(),i,j,false);
					v.add(m);
				}
				//if occupied with the same colour, it should stop at its current position 
				if(!getBoard().outOfRange(x-1, y-1) && getBoard().occupied(x-1, y-1)
						&& (getBoard().getPiece(x-1, y-1).getColour()==this.getColour())){
					break;
				}
				//if occupied with a different colour, it should remove it and take its position
				if(!getBoard().outOfRange(x-1, y-1) && getBoard().occupied(x-1, y-1)
						&& (getBoard().getPiece(x-1, y-1).getColour()!=this.getColour())){
					m = new Move(this, getX(),getY(),i,j,true);
					v.add(m);
				} 
			}

			//left diagonally downwards
			for(i= x-1, j= y+1; i<=7 && j<=7; i--, j++){
				//if unoccupied
				if(!getBoard().outOfRange(x-1, y+1) && !getBoard().occupied(x-1, y+1)){
					m = new Move(this, getX(),getY(),i,j,false);
					v.add(m);
				}
				//if occupied with the same colour, it should stop at its current position 
				if(!getBoard().outOfRange(x-1, y+1) && getBoard().occupied(x-1, y+1)
						&& (getBoard().getPiece(x-1, y+1).getColour()==this.getColour())){
					break;
				}
				//if occupied with a different colour, it should remove it and take its position
				if(!getBoard().outOfRange(x-1, y+1) && getBoard().occupied(x-1, y+1)
						&& (getBoard().getPiece(x-1, y+1).getColour()!=this.getColour())){
					m = new Move(this, getX(),getY(),i,j,true);
					v.add(m);
				} 
			}
		}
		if (v.isEmpty()) return null;
		return v;   
	}
}
