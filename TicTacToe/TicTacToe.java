package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] loc = new char[3][3];

        init(loc);

        System.out.println("Welcome to Tic-Tac-Toe!\nDo you want to be X or O?");
        char choice = CharChoice();

        board(loc);
    }

    private static void init(char[][] loc) {
        for (int i = 0; i < loc.length; i++)
            for (int j = 0; j < loc.length; j++) loc[i][j] = ' ';
    }

    static void board(char[][] loc) {

        System.out.printf(" %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2]);
        System.out.println("---+---+---");
        System.out.printf(" %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2]);
        System.out.println("---+---+---");
        System.out.printf(" %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2]);
    }
    static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for(temp = cin.nextLine(); temp.length() != 1 || (temp.charAt(0) != 'X' && temp.charAt(0) != 'O'); temp = cin.nextLine())
            System.out.println("Please try again. Choose either X or O.\n");

        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }

}
