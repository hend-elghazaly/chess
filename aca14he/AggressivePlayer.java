package uk.ac.sheffield.aca14he;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * AggressivePlayer.java 
 *
 * Class to represent an aggressive player
 *
 * @author aca14he
 */

public class AggressivePlayer extends Player {
	public AggressivePlayer (String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}

	public boolean makeMove(){

		//get a list of available moves of all pieces
		ArrayList<Move> listOfMoves = new ArrayList<Move>();
		//get a list of the pieces
		ArrayList<Piece> listOfPieces = getPieces().getData();
		//iterate through the pieces array 
		Iterator<Piece> pieces = listOfPieces.iterator();

		//check if there is a piece after it in the array until it reaches the end of the array
		while (pieces.hasNext()){
			//gets the next piece in the array
			Piece p = pieces.next();

			// if this piece (next one) has available moves
			if(p.availableMoves() != null) {
				//it should add the move of this piece to the available moves list
				for(Move m : p.availableMoves())
					if(m != null)
						listOfMoves.add(m);
			}
		}

		//if the player can make an aggressive move
		//if there are available moves; list of moves array is not empty
		if (!listOfMoves.isEmpty()){

			Move move = null;
			//6 is the maximum value of a piece (king) 1 is the minimum (pawn)
			for( int value= 6; value >0; value-- ){
				//for-each loop , getting a move from the list of available moves array
				for(Move singleMove: listOfMoves){
					//if that move is occupied
					if(singleMove.getOccupied()){
						//get the piece value
						int	pieceValue= PieceCode.charToInt((getBoard().getPiece(singleMove.getxTo(), singleMove.getyTo()).getChar()));	
						if(value == pieceValue){
							//assign to move object to be used in making a move
							move = singleMove;
							break;
						}
					}
				}	
			}

			//if an aggressive move is not available make a random move
			if (move == null) {
				//choose a random move from the list of moves 
				// Returns a random number between min and max (size of list of moves array)
				Random random = new Random();
				int randomPiece =  random.nextInt(listOfMoves.size()-0)+0;  
				move = listOfMoves.get(randomPiece);
			}

			//make a move either way (aggressive or random)
			if(move!=null){
				Piece piece = move.getPiece();
				int xFrom = move.getxFrom();
				int yFrom = move.getyFrom(); 
				int xTo = move.getxTo();
				int yTo = move.getyTo(); 

				//removes opponent's piece
				getOpponent().deletePiece(getBoard().getPiece(xTo,yTo));
				//moves the player's piece from its initial position to the opponent's piece position
				getBoard().setPosition(xTo,yTo,piece);
				getBoard().remove(xFrom,yFrom);
				piece.setPosition(xTo, yTo);

				return true;		
			}
		}
		return false;
	}
}