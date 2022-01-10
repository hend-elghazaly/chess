package uk.ac.sheffield.aca14he;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * RandomPlayer.java 
 *
 * Class to represent a random player
 *
 * @author aca14he
 */

public class RandomPlayer extends Player {
	private int xFrom,yFrom,xTo,yTo;
	private Move move;

	public RandomPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}

	public boolean makeMove()  {

		//get a list of available moves of all pieces
		ArrayList<Move> listOfMoves = new ArrayList<Move>();
		//get a list of the pieces
		ArrayList<Piece> listOfPieces = getPieces().getData();
		//iterate through the pieces array (collection)
		Iterator<Piece> pieces = listOfPieces.iterator();

		int times = 0;
		//checks if there is a piece after it in the array until it reaches the end of the array
		while (pieces.hasNext()){
			//gets the next piece in the array
			Piece p = pieces.next();

			// if this piece (next one) has no available moves
			if(p.availableMoves()==null)
				times++;
			// else this piece has available moves
			else {
				//then it should add the move of this piece to the available moves list
				listOfMoves.addAll(p.availableMoves());
				times ++;
			}
		}

		//if there are available moves in the list of moves
		if (listOfMoves != null){
			//choose a random move from the list of moves 
			// Returns a random number between minimum (0) and maximum (size of list of moves array)
			Random random =new Random();
			int randomMove = random.nextInt(listOfMoves.size()-0)+0;

			//uses the random move to make a move
			move = listOfMoves.get(randomMove);
			if(move != null){
				xTo = move.getxTo();
				yTo = move.getyTo();
				xFrom = move.getxFrom();
				yFrom = move.getyFrom();
				Piece piece = move.getPiece();

				//make a random move

				if(getBoard().getPiece(xTo, yTo)!=null &&
						piece.getColour()!=getBoard().getPiece(xTo,yTo).getColour()) 
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