/**
 * edited by aca14he 
 * I have changed the piece characters to unicode e.g for Pawn instead of 'p' , \u2659
 */

package uk.ac.sheffield.aca14he;

/*
 * PieceCode.java  	1.0 26/01/2015
 *
 * Copyright (c) University of Sheffield 2015
 */


/**
 * PieceCode.java
 *
 * Provides static methods and variables to manage codes for
 * different pieces on the chess board, and to return characters
 * for display on the console.
 *
 * @version 1.0 26 January 2015
 *
 * @author Richard Clayton  (r.h.clayton@sheffield.ac.uk), Steve Maddock (s.c.maddock@sheffield.ac.uk)
 * 
 */

public final class PieceCode {

	// static variables for colours and pieces   
	public static final int BLACK = 0;
	public static final int WHITE = 1;

	public static final int PAWN = 1;
	public static final int KNIGHT = 2;
	public static final int BISHOP = 3;
	public static final int ROOK = 4;
	public static final int QUEEN = 5;
	public static final int KING = 6;

	public static final char PAWNWHITE = '\u2659';
	public static final char KNIGHTWHITE = '\u2658';
	public static final char BISHOPWHITE = '\u2657';
	public static final char ROOKWHITE = '\u2656';
	public static final char QUEENWHITE = '\u2655';
	public static final char KINGWHITE = '\u2654';
	public static final char PAWNBLACK = '\u265F';
	public static final char KNIGHTBLACK = '\u265E';
	public static final char BISHOPBLACK = '\u265D';
	public static final char ROOKBLACK = '\u265C';
	public static final char QUEENBLACK = '\u265B';
	public static final char KINGBLACK = '\u265A';

	// method to return the symbol of a piece, given its numerical code and colour
	public static char intToChar(int i, int colour) {
		char data;
		switch (i) {
		case PAWN: if (colour==WHITE) data = '\u2659'; else data='\u265F';
		break;
		case KNIGHT: if (colour==WHITE) data = '\u2658'; else data = '\u265E';
		break;
		case BISHOP: if (colour==WHITE) data = '\u2657'; else data = '\u265D';
		break;
		case ROOK: if (colour==WHITE) data = '\u2656'; else data = '\u265C';
		break;
		case QUEEN: if (colour==WHITE) data = '\u2655'; else data = '\u265B';
		break;
		case KING: if (colour==WHITE) data = '\u2654'; else data = '\u265A';
		break;
		default: data = '.';
		}
		return data;
	}

	// method to return the numerical code of a piece, given its symbol    
	public static int charToInt(char ch) {
		int i;
		switch (ch) {
		case '\u265F': case '\u2659': i = PAWN;
		break;
		case '\u265E': case '\u2658': i = KNIGHT;
		break;
		case '\u265D': case '\u2657': i = BISHOP;
		break;
		case '\u265C': case '\u2656': i = ROOK;
		break;
		case '\u265B': case '\u2655': i = QUEEN;
		break;
		case '\u265A': case '\u2654': i = KING;
		break;
		default: i = 0;
		}
		return i;
	}

}