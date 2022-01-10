package uk.ac.sheffield.aca14he;

import java.util.ArrayList;

/**
 * Rook.java 
 *
 * Concrete class to represent a rook
 *
 * @author aca14he
 */

public class Rook extends Piece {

	public Rook (int ix, int iy, int c, Board b) {
		super(PieceCode.ROOK, ix, iy, c, b);
	}

	// method implements abstract method in Piece class
	public ArrayList<Move> availableMoves() {

		int x = getX();
		int y = getY();

		// create a new vector to store legal moves
		ArrayList<Move> v = new ArrayList<Move>();

		// set up m to refer to a Move object  
		Move m = null;

		//if the rook is at the starting position or anywhere on the board
		if(y>=0){
			//it can move, as long as there is no piece in front of it on the way:
			//downwards till y=7 
			for(int i=y+1; i<8; i++){
				//if the position is unoccupied and not outside the board
				if(!getBoard().outOfRange(x, y+1) && !getBoard().occupied(x, y+1)){
					m = new Move(this, x,getY(),x,i,false);
					v.add(m);
				}

				//if the position is occupied with the same color, it should stop at its current position (final position)
				if(!getBoard().outOfRange(x, y+1) && getBoard().occupied(x, y+1)
						&& (getBoard().getPiece(x, y+1).getColour()==this.getColour())){
					break;
				}
				//if the position is occupied with a different color, it should remove this piece and take its position (final position)
				if(!getBoard().outOfRange(x, y+1) && getBoard().occupied(x, y+1)
						&& (getBoard().getPiece(x, y+1).getColour()!=this.getColour())){
					m = new Move(this, x,getY(),x,i,true);
					v.add(m);
				}
			}
			//upwards till y=0
			for(int i= y-1; i<-1; i--){
				//if the position is unoccupied and not outside the board
				if(!getBoard().outOfRange(x, y-1) && !getBoard().occupied(x, y-1)){
					m = new Move(this, x,getY(),x,i,false);
					v.add(m);
				}					 
				//if the position is occupied with the same color, it should stop at its current position (final position)
				if(!getBoard().outOfRange(x, y-1) && getBoard().occupied(x, y-1)
						&& (getBoard().getPiece(x, y-1).getColour()==this.getColour())){
					break;
				}

				//if the position is occupied with a different color, it should remove this piece and take its position (final position)
				if(!getBoard().outOfRange(x, y-1) && getBoard().occupied(x, y-1)
						&& (getBoard().getPiece(x, y-1).getColour()!=this.getColour())){
					m = new Move(this, x,getY(),x,i,true);
					v.add(m);
				} 
			}

			//left till x=0
			for(int i= x-1; i<-1; i--){
				//if the position is unoccupied and not outside the board
				if(!getBoard().outOfRange(x-1, y) && !getBoard().occupied(x-1, y)){
					m = new Move(this, getX(),y,i,y,false);
					v.add(m);
				}					 
				//if the position is occupied with the same color, it should stop at its current position (final position)
				if(!getBoard().outOfRange(x-1, y) && getBoard().occupied(x-1, y)
						&& (getBoard().getPiece(x-1, y).getColour()==this.getColour())){
					break;
				}
				//if the position is occupied with a different color, it should remove this piece and take its position (final position)
				if(!getBoard().outOfRange(x-1, y) && getBoard().occupied(x-1, y)
						&& (getBoard().getPiece(x-1, y).getColour()!=this.getColour())){
					m = new Move(this, getX(),y,i,y,true);
					v.add(m);
				} 
			}
			//right till x=7
			for(int i= x+1; i<8; i++){
				//if the position is unoccupied and not outside the board
				if(!getBoard().outOfRange(x+1, y) && !getBoard().occupied(x+1, y)){
					m = new Move(this, getX(),y,i,y,false);
					v.add(m);
				}					 
				//if the position is occupied with the same color, it should stop at its current position (final position)
				if(!getBoard().outOfRange(x+1, y) && getBoard().occupied(x+1, y)
						&& (getBoard().getPiece(x+1, y).getColour()==this.getColour())){
					break;
				}
				//if the position is occupied with a different color, it should remove this piece and take its position (final position)
				if(!getBoard().outOfRange(x+1, y) && getBoard().occupied(x+1, y)
						&& (getBoard().getPiece(x+1, y).getColour()!=this.getColour())){
					m = new Move(this, getX(),y,i,y,true);
					v.add(m);
				} 
			}
		}

		if (v.isEmpty()) return null;
		return v;
	}
}	