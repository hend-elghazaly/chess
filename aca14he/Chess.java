/**Unfortunately I was not able to implement buttons therefore please use the console as a method of input 
and for choosing type of player kindly change HumanPlayer to the other types at player 1 and player 2 constructors below */

package uk.ac.sheffield.aca14he;

/**
 * Chess.java 
 *
 * Class to represent the main method
 *
 * @author aca14he
 */

public class Chess {
	public static void main(String[] arg) {

		//construct new Board, Pieces, the Graphical display and different Players objects
		Board board = new Board();
		Pieces black = new Pieces(board,0);
		Pieces white = new Pieces(board,1);
		Display piecesOnBoard = new GraphicalDisplay();  
		//You can change the type of player by changing HumanPlayer to RandomPlayer or AggressivePlayer
		Player player1 = new HumanPlayer("you", white, board, null);
		Player player2 = new HumanPlayer("oponnent",black, board, player1);
		player1.setOpponent(player2);

		//the kings' positions of each player
		char p1King = white.getPiece(white.getNumPieces()-1).getChar();
		char p2King = black.getPiece(black.getNumPieces()-1).getChar();

		//display the board
		piecesOnBoard.showPiecesOnBoard(board.getData());

		//requests move from each player in turn 
		while(p1King == '\u2654' && p2King == '\u265A'){  //white king is \u2654, black king is \u265A
			boolean p1Moving = false;
			boolean p2Moving = false;

			// player1 is moving 
			while(p1Moving == false) {
				System.out.println("Player 1 turn");
				if(player1.makeMove()){
					p1Moving = true;
					//update the display
					piecesOnBoard.showPiecesOnBoard(board.getData());
				}
				else {
					System.out.println("Not a valid move for white. Try again!");
				}
			}

			//if player 1 took the opponent's king, player 1 should be declared a winner
			p2King = black.getPiece(black.getNumPieces()-1).getChar();
			if (p2King != '\u265A') {
				System.out.println("Player 1 wins!" );  
				break;
			}

			//player2 is moving
			while(p2Moving == false) {
				System.out.println("Player 2 turn");
				if(player2.makeMove()){               		  
					p2Moving = true;
					//update the display
					piecesOnBoard.showPiecesOnBoard(board.getData());
				}
				else {
					System.out.println("Not a valid move for black. Try again!");
				}
			}

			//if the player1's king is removed this means the opponent wins and a winner is declared
			p1King = white.getPiece(white.getNumPieces()-1).getChar();
			if(p1King != '\u2654') {
				System.out.println("Player 2 wins!");
				break;
			}  
		}
	}
}