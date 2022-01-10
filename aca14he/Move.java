/**New methods added to use in RandomPlayer and AggressivePlayer*/ 

package uk.ac.sheffield.aca14he;

/**
 * Move.java 
 *
 *
 * @author aca14he
 */

public class Move {

	// instance fields
	private Piece piece;
	private int xFrom,yFrom;
	private int xTo,yTo;
	private boolean occupied;

	//constructors (with occupied)
	public Move (Piece p, int x, int y, int i, int j, boolean o) {
		piece = p;	
		xFrom = x; 
		yFrom = y;
		xTo = i;
		yTo = j;
		occupied = o;
	}

	//constructors 
	public Move (Piece p, int x, int y, int i, int j) {
		piece = p;	
		xFrom = x; 
		yFrom = y;
		xTo = i;
		yTo = j;
	}

	public boolean getOccupied(){
		return occupied;
	}

	//equals method to check the move is not null and compares the piece and from/to coordinates with the move made
	public boolean equals(Move m) {
		if(m!=null){
			if ((piece==m.piece) && (xFrom==m.xFrom) && (yFrom==m.yFrom) 
					&& (xTo==m.xTo) && (yTo==m.yTo));
			return true;
		}
		return false;
	}

	//getting the x and y coordinates of the from and to positions and the piece to use in random and aggressive players 
	public int getxFrom(){
		return xFrom;
	}

	public int getxTo(){
		return xTo;
	}

	public int getyFrom(){
		return yFrom;
	}

	public int getyTo(){
		return yTo;
	}

	public Piece getPiece(){
		return piece;
	}

}

