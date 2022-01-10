package uk.ac.sheffield.aca14he;

/**
 * TextDisplay.java 
 *
 * Class to display the pieces on the chess board
 *
 * @author aca14he
 * 
 */

public class TextDisplay implements Display {
	public void showPiecesOnBoard(Piece[][] data){
		//chess board size 8x8
		int MAX_ROWS = 8;
		int MAX_COLUMNS = 8;
		int i,j;

		//column heading
		char column = 'A'; 
		System.out.print(" ");
		for (i=0; i<MAX_COLUMNS; i++){
			System.out.print(column +" ");
			column++;
		}

		System.out.println();

		//row heading
		for(i=0; i<8 ; i++){
			System.out.print((i+1)+" ");
			for(j=0; j< MAX_ROWS; j++){
				//if there is not a piece in a position, it should be blank
				if(data [j][i]== null)
					System.out.print("- ");
				else
					System.out.print(data[j][i] + " ");
			}
			//then goes to the second row and does the same thing again until the 7th row
			System.out.print("\n");
		}
	}
}
