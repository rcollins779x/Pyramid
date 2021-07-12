// Course: CS3642
// Student name: Ronnin Collins
// Student ID: xxx-xx-xxxx
// Assignment #: 2
// Due Date: 7/11/2021
// Signature: Rennan Collins
package board;

import component.BlankSpace;
import component.X;
import component.Queen;

import java.util.Scanner;

public abstract class Board {
	//Member variables
	static char[] vertical_notes;
	static int[] horizontal_nums;
	public static Square[][] board;
	private static int dimension;
	private static final Scanner scanner = new Scanner(System.in);

	public static void setup(){	//initializing board to dynamic size
		board = new Square[dimension][dimension];
		vertical_notes = new char[dimension];
		horizontal_nums = new int[dimension];

		//populating board with blank spaces
		for(int i = 0; i < dimension; i++){
			vertical_notes[i] = (char) (i + 65);
			horizontal_nums[i] = i + 1;
			for(int j = 0; j < dimension; j++) board[i][j] = new BlankSpace();
		}
	}

	public static void draw(){
		System.out.print("\n   ");

		//printing letters across the top
		for(char i: vertical_notes) System.out.print("  " + i + "  ");
		System.out.print("\n   ");
		for(int i = 0; i < dimension; i++) System.out.print(" --- ");
		System.out.print("\n");
		for(int i = 0; i < dimension; i++){ //looping through the board and printing symbols
			System.out.print(" " + (dimension - i) + " "); //print number on left side

			for(Square j: board[i]){
				System.out.print("|" + j.getSymbol() + "|");
			}
			System.out.print(" " + (dimension - i) + " "); //number on right side

			System.out.print("\n   ");//to get next line

			for(int j = 0; j < dimension; j++){
				System.out.print(" --- ");
			}
			System.out.print("\n");
		}
		System.out.print("   ");
		for(char i: vertical_notes){ //printing letters across the bottom
			System.out.print("  " + i + "  ");
		}
		System.out.println();
	}

	public static void getDimension() {
		System.out.print("Size of board: ");
		dimension = Math.max(scanner.nextInt(), 1);
	}
	public static void solutionFinder() {
		algorithm();
	}

	static void algorithm() {	//custom algorithm to populated BlankSpaces with Queens
		int size = board.length, count;
		int[] loop = {1, 2, 3, 4, 5, 6, 7};
		int[] iter = {0, 0, 0, 0, 0, 0, 0};

		for (iter[0] = 0; iter[0] < (loop[0] > size ? 1 : size); iter[0]++) { // iterates row 1
			resetBoard();
			count = 0;
			for (iter[1] = 0; iter[1] < (loop[1] > size ? 1 : size); iter[1]++) { // iterates row 2
				for (iter[2] = 0; iter[2] < (loop[2] > size ? 1 : size); iter[2]++) { // iterates row 3
					for (iter[3] = 0; iter[3] < (loop[3] > size ? 1 : size); iter[3]++) { // iterates row 4
						for (iter[4] = 0; iter[4] < (loop[4] > size ? 1 : size); iter[4]++) { // iterates row 5
							for (iter[5] = 0; iter[5] < (loop[5] > size ? 1 : size); iter[5]++) { // iterates row 6
								for (iter[6] = 0; iter[6] < (loop[6] > size ? 1 : size); iter[6]++) { // iterates row 7
									System.out.print(" ");
									for(int i = 0, check = -1; i < size; i++) {
										//Checks if index is blank, if so places queen and fills invalid locations with X
										if (board[++check][iter[check]].getSymbol().equals("   ")) {
											board[check][iter[check]] = new Queen();
											fillInvalid(check, iter[check]);
											if (dimension == ++count) //If total queens matches solution #, draw board
												draw();

										}

									}
								}
							}
						}
					}
				}
			}
		}
	}

	private static void resetBoard() {
		//System.out.println("Dim: " + dimension + " Board.length: " + board.length);
		for(int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				board[i][j] = new BlankSpace();		//Reset board for next attempt
			}
		}
	}

	private static void fillInvalid(int y, int x) {
		//Fills vertical and horizontals for Q
		for(int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if(!board[i][j].getSymbol().equals(" Q "))
					if(i == y || j == x) board[i][j] = new X();
			}
		}
		//Fills \ for Q
		for(int i = 0; i < dimension; i++)
			for (int j = 0; j + x < dimension; j++) {
				if (x + i < dimension && y + i < dimension)
					if (!board[y + i][x + i].getSymbol().equals(" Q ")) board[y + i][x + i] = new X();
				if (x - i >= 0 && y - i >= 0)
					if (!board[y - i][x - i].getSymbol().equals(" Q ")) board[y - i][x - i] = new X();
			}
		//Fills / for Q
		for(int i = 0, k = 0; i < dimension; i++, k++)
			for (int j = 0; j + x < dimension; j++) {
				if (y + i < dimension && x - i >= 0)
					if (!board[y + i][x - i].getSymbol().equals(" Q ")) board[y + i][x - i] = new X();
				if (y - i >= 0 && x + i < dimension)
					if (!board[y - i][x + i].getSymbol().equals(" Q ")) board[y - i][x + i] = new X();
			}
	}
}
