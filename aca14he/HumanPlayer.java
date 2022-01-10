package uk.ac.sheffield.aca14he;
import java.util.*;

/**
 * HumanPlayer.java 	
 *
 * Class to represent a human player
 * @author aca14he
 */

public class HumanPlayer extends Player {	
	public HumanPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o); }

	public boolean makeMove() {
		//initial and final position's row and column
		int ix, iy; int fx, fy;
		ix = iy = fx = fy = -1;
		boolean initialPos = false;
		boolean finalPos = false;
		Piece p= null;
		Move m = null;

		Scanner player_input = new Scanner(System.in);

		while(p==null){
			//Get the "from" and "to" coordinates from the player as String
			//initial position
			// player asked for the initial position ("from" position) and will be asked to choose another piece if it was not valid
			while(initialPos == false) {
				System.out.println("Position of the piece you would like to move? (e.g A2)");
				String fromPosition = player_input.next( );

				//Split the input (from coordinates) into 2 (column and row) and changing it into int
				String coloumn1 = String.valueOf(fromPosition.charAt(0));  
				String row1 = String.valueOf(fromPosition.charAt(1));

				//first position's column (e.g A) 
				switch (coloumn1.toUpperCase()) {
				case "A":  ix = 0;
				break;
				case "B":  ix = 1;
				break;
				case "C":  ix = 2;
				break;
				case "D":  ix = 3;
				break;
				case "E":  ix = 4;
				break;
				case "F":  ix = 5;
				break;
				case "G":  ix = 6;
				break;
				case "H":  ix = 7;
				break;
				default: ix = 8;
				}	

				//first position's row (e.g 2)
				switch (row1) {
				case "1":  iy = 0;
				break;
				case "2":  iy = 1;
				break;
				case "3":  iy = 2;
				break;
				case "4":  iy = 3;
				break;
				case "5":  iy = 4;
				break;
				case "6":  iy = 5;
				break;
				case "7":  iy = 6;
				break;
				case "8":  iy = 7;
				break;     
				default: iy = 8;
				}
				//for checking	System.out.println("from position:  coloumn= " + ix + " row= " + iy); 

				//Check if the initial position is in the range (between 0-7)
				if(ix>-1 && ix<8 && iy>-1 && iy<8 ){
					initialPos = true;	
				}
				else {
					//otherwise invalid position and the player is asked to choose another piece
					System.out.println("Invalid position! Please try again and choose another piece.");
					initialPos = false;  
				}
			}

			//end position
			// player asked for the end position ("to" position) and will be asked to enter another position if it was not valid
			while(finalPos == false) {
				System.out.println("Where do you want to move it to? (e.g A3) ");
				String toPosition = player_input.next( );

				//Split the input (to coordinates) into 2  (column and row) and changing it into int
				String coloumn2 = String.valueOf(toPosition.charAt(0));	
				String row2 = String.valueOf(toPosition.charAt(1));

				//second position's column (e.g A) 
				switch (coloumn2.toUpperCase()) {
				case "A":  fx = 0;
				break;
				case "B":  fx = 1;
				break;
				case "C":  fx = 2;
				break;
				case "D":  fx = 3;
				break;
				case "E":  fx = 4;
				break;
				case "F":  fx = 5;
				break;
				case "G":  fx = 6;
				break;
				case "H":  fx = 7;
				break;	         
				default: fx=8;
				}

				//second position's row (e.g 3)
				switch (row2) {
				case "1":  fy = 0;
				break;
				case "2":  fy = 1;
				break;
				case "3":  fy = 2;
				break;
				case "4":  fy = 3;
				break;
				case "5":  fy = 4;
				break;
				case "6":  fy = 5;
				break;
				case "7":  fy = 6;
				break;
				case "8":  fy = 7;
				break;
				default: fy=8;
				} 
				//for checking	System.out.println("to poition: coloumn=" + fx + " row = " + fy); 

				//Check if there is a piece on the board at the end position and it is in the range (between 0-7) and that it is the oponnent's piece
				if(fx>-1 && fx<8 && fy>-1 && fy<8) {
					finalPos = true;					
				}
				//otherwise invalid position and the player is asked to choose another end position 
				else{
					System.out.println("Invalid position! Please choose another end position.");
					finalPos = false; 		
				}	  
			}

			//after checking if the input is valid
			//check if the piece is on board
			if(getBoard().getPiece(ix, iy)!=null){
				//assign to piece object
				p=getBoard().getPiece(ix, iy);
				//if there is a piece check if it's the opponent's player not their own piece
				if(getOpponent().getPieces().getColour() !=p.getColour()){
					m = new Move(p, ix, iy, fx, fy);
				}
				else{
					//if the player chooses the his own piece ask for another input
					p=null;
					System.out.println("Invalid piece! Please choose one of the oponnent pieces.");
				}
			}
			else{
				//so if the there is no piece on board	
				p=null;
				System.out.println("Invalid piece! Piece is not on board.");
			}
		}
		//list the legal moves (availableMoves) and compare with the move made
		ArrayList<Move> v = new ArrayList<Move>();
		v=p.availableMoves();
		if(v!=null){
			//iterates through the list of available moves
			Iterator<Move> iterate = v.iterator();
			boolean equal= false;

			while(iterate.hasNext() && equal==false){
				if(m.equals(iterate.next())){
					equal= true;
				}
			}	
			//if valid, the oponnent's piece (the one at the end position) is removed
			if (getBoard().getPiece(fx,fy) != null && getBoard().getPiece(fx,fy).getColour() != p.getColour())
				getOpponent().deletePiece(getBoard().getPiece(fx,fy));
			//sets the position to the opponent's piece position 
			getBoard().setPosition(fx, fy, p);
			//and remove the piece from its initial position
			getBoard().remove(ix,iy);
			return true;
		}
		return false;	
	}
}
