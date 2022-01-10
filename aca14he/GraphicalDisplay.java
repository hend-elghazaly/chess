/**I have changed PieceCode characters to unicode to display the pieces as symbols. 
 It displays the symbols on my mac laptop, however for some reason, it does not display it on windows computers.  */


package uk.ac.sheffield.aca14he;

import java.awt.*;
import javax.swing.*;

public class GraphicalDisplay extends JFrame
implements Display {
	public void showPiecesOnBoard(Piece[][] data) {
		//displaying the frame
		setTitle("Chess Game");
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//creating a border layout inside it a gridlayout
		Container contentPane = getContentPane();
		contentPane.removeAll();
		contentPane.setLayout(new BorderLayout());

		//creating a new panel for the grid
		JPanel grid =new JPanel();	

		//8 by 8 grid for the chess board
		grid.setLayout(new GridLayout(8,8)); 
		//array of grid squares
		JPanel[][] gridsq = new JPanel[8][8];

		//for the rows and columns, r is row c is column
		for(int r=0; r<8 ;r++){
			for(int c=0; c< 8; c++){
				gridsq[r][c] = new JPanel();
				//if the sum of the row and column numbers is even (i.e divisible by 2 with 0 remainder)
				if((r+c) %2 == 0)
					//square color white
					gridsq[r][c].setBackground(Color.white);
				else
					//square color gray
					gridsq[r][c].setBackground(Color.gray);

				//adding pieces symbols to the board 
				if (data[c][r]!=null){ //if there is a piece
					JLabel pieceSymbol = new JLabel(""+data[c][r].getChar()); //array of pieces symbols
					pieceSymbol.setFont(new java.awt.Font("Times New Roman", 1, 50)); //resizing the symbol
					gridsq[r][c].add(pieceSymbol); //then adding the symbols to the grid
				}
				//Squares added to the grid
				grid.add(gridsq[r][c]);
			}
		}
		//grid added to the border layout 
		contentPane.add(grid,BorderLayout.CENTER);
		setVisible(true);
	}
}