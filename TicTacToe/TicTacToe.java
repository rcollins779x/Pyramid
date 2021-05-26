package TicTacToe;
import java.util.Scanner;
import static java.lang.Character.isDigit;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] map = new char[3][3];                          //Location of Xs and Os
        int choice;

        System.out.println("Welcome to Tic-Tac-Toe!");
        do {                                                    //Replay again loop
            init(map);                                          //Initialize map

            System.out.println("Do you want to be X or O?");
            char ox = CharChoice(), xo = ox == 'X' ? 'O' : 'X'; //Defines Player symbol and computer symbol

            System.out.println("The computer will go first.");
            do {
                computerTurn(map, xo);                          //Computer takes its turn and updates map
                board(map);                                     //Prints board and map
                if (isGameOver(map, ox) == 0) System.out.println("The computer has beaten you! You lose.");
                else {                                          //If Computer did not win move to Player turn
                    System.out.print("What is your next move? ");
                    playerTurn(map, ox);                        //Player takes its turn and updates map
                    board(map);                                 //Prints board and map
                }
                if (isGameOver(map, ox) == 1) System.out.println("You defeated the computer! You win.");
            } while (isGameOver(map, ox) == -1);                //Repeat until the game ends

            for (choice = 0;choice < 1 || choice > 2;) {
                System.out.println("Do you want to play again?\n1. yes\n2. no");
                choice = SztChoice();
                if (choice < 1 || choice > 2) System.out.println("I didn't get that. Try again.");
            }
        } while (choice == 1);
    }

    private static int isGameOver(char[][] loc, char ox) {      //Checks if Computer or Human has won
        char xo = ox == 'X' ? 'O' : 'X';
        if (loc[0][0] == xo && loc[1][1] == xo && loc[2][2] == xo) return 0;
        if (loc[0][0] == xo && loc[0][1] == xo && loc[0][2] == xo) return 0;
        if (loc[0][0] == xo && loc[1][0] == xo && loc[2][0] == xo) return 0;
        if (loc[2][0] == xo && loc[2][1] == xo && loc[2][2] == xo) return 0;
        if (loc[0][2] == xo && loc[1][2] == xo && loc[2][2] == xo) return 0;
        if (loc[0][1] == xo && loc[1][1] == xo && loc[2][1] == xo) return 0;
        if (loc[1][0] == xo && loc[1][1] == xo && loc[1][2] == xo) return 0;
        if (loc[2][0] == xo && loc[1][1] == xo && loc[0][2] == xo) return 0;

        if (loc[0][0] == ox && loc[0][1] == ox && loc[0][2] == ox) return 1;
        if (loc[0][0] == ox && loc[1][0] == ox && loc[2][0] == ox) return 1;
        if (loc[0][0] == ox && loc[1][1] == ox && loc[2][2] == ox) return 1;
        if (loc[0][1] == ox && loc[1][1] == ox && loc[2][1] == ox) return 1;
        if (loc[1][0] == ox && loc[1][1] == ox && loc[1][2] == ox) return 1;
        if (loc[0][2] == ox && loc[1][1] == ox && loc[2][0] == ox) return 1;
        if (loc[0][2] == ox && loc[1][2] == ox && loc[2][2] == ox) return 1;
        if (loc[2][0] == ox && loc[2][1] == ox && loc[2][2] == ox) return 1;
        return -1;
    }

    private static void playerTurn(char[][] loc, char ox) {         //Checks if chosen cell is ' '
        int choice;

        for (choice = SztChoice(); loc[(choice - 1) / 3][(choice - 1) % 3] != ' '; choice = SztChoice())
            System.out.println("That cell is not available.");
        loc[(choice - 1) / 3][(choice -1) % 3] = ox;                //If empty store Player symbol
    }

    private static void computerTurn(char[][] loc, char xo) {       //Checks which lane can still be won
        char ox = xo == 'X' ? 'O' : 'X';
        int counter = 0;                                            //Picks a cell only once per turn
        if (loc[0][0] != ox && loc[1][1] != ox && loc[2][2] != ox) {
            if (loc[0][0] == ' ' && counter == 0) { loc[0][0] = xo; counter++; }
            if (loc[2][2] == ' ' && counter == 0) { loc[2][2] = xo; counter++; }
            if (loc[1][1] == ' ' && counter == 0) { loc[1][1] = xo; counter++; }
        }
        if (loc[0][0] != ox && loc[0][1] != ox && loc[0][2] != ox) {
            if (loc[0][0] == ' ' && counter == 0) { loc[0][0] = xo; counter++; }
            if (loc[0][2] == ' ' && counter == 0) { loc[0][2] = xo; counter++; }
            if (loc[0][1] == ' ' && counter == 0) { loc[0][1] = xo; counter++; }
        }
        if (loc[0][0] != ox && loc[1][0] != ox && loc[2][0] != ox) {
            if (loc[0][0] == ' ' && counter == 0) { loc[0][0] = xo; counter++; }
            if (loc[2][0] == ' ' && counter == 0) { loc[2][0] = xo; counter++; }
            if (loc[1][0] == ' ' && counter == 0) { loc[1][0] = xo; counter++; }
        }
        if (loc[2][0] != ox && loc[2][1] != ox && loc[2][2] != ox) {
            if (loc[2][0] == ' ' && counter == 0) { loc[2][0] = xo; counter++; }
            if (loc[2][2] == ' ' && counter == 0) { loc[2][2] = xo; counter++; }
            if (loc[2][1] == ' ' && counter == 0) { loc[2][1] = xo; counter++; }
        }
        if (loc[0][2] != ox && loc[1][2] != ox && loc[2][2] != ox) {
            if (loc[0][2] == ' ' && counter == 0) { loc[0][2] = xo; counter++; }
            if (loc[2][2] == ' ' && counter == 0) { loc[2][2] = xo; counter++; }
            if (loc[1][2] == ' ' && counter == 0) { loc[1][2] = xo; counter++; }
        }
        if (loc[0][1] != ox && loc[1][1] != ox && loc[2][1] != ox) {
            if (loc[1][1] == ' ' && counter == 0) { loc[1][1] = xo; counter++; }
            if (loc[0][1] == ' ' && counter == 0) { loc[0][1] = xo; counter++; }
            if (loc[2][1] == ' ' && counter == 0) { loc[2][1] = xo; counter++; }
        }
        if (loc[1][0] != ox && loc[1][1] != ox && loc[1][2] != ox) {
            if (loc[1][1] == ' ' && counter == 0) { loc[1][1] = xo; counter++; }
            if (loc[1][0] == ' ' && counter == 0) { loc[1][0] = xo; counter++; }
            if (loc[1][2] == ' ' && counter == 0) { loc[1][2] = xo; counter++; }
        }
        if (loc[2][0] != ox && loc[1][1] != ox && loc[0][2] != ox) {
            if (loc[1][1] == ' ' && counter == 0) { loc[1][1] = xo; counter++; }
            if (loc[1][0] == ' ' && counter == 0) { loc[2][0] = xo; counter++; }
            if (loc[1][2] == ' ' && counter == 0) { loc[0][2] = xo; counter++; }
        }
    }

    private static void init(char[][] loc) {                            //Clears map
        for (int i = 0; i < loc.length; i++)
            for (int j = 0; j < loc.length; j++) loc[i][j] = ' ';
    }

    static void board(char[][] loc) {                                   //Prints board
        System.out.printf("\n %c | %c | %c \t %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2], loc[0][0] == ' ' ? '1' : ' ', loc[0][1] == ' ' ? '2' : ' ', loc[0][2] == ' ' ? '3' : ' ');
        System.out.println("---+---+---\t---+---+---");
        System.out.printf(" %c | %c | %c \t %c | %c | %c \n", loc[1][0], loc[1][1], loc[1][2], loc[1][0] == ' ' ? '4' : ' ', loc[1][1] == ' ' ? '5' : ' ', loc[1][2] == ' ' ? '6' : ' ');
        System.out.println("---+---+---\t---+---+---");
        System.out.printf(" %c | %c | %c \t %c | %c | %c \n\n", loc[2][0], loc[2][1], loc[2][2], loc[2][0] == ' ' ? '7' : ' ', loc[2][1] == ' ' ? '8' : ' ', loc[2][2] == ' ' ? '9' : ' ');
    }

    static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for (temp = cin.nextLine(); temp.length() != 1 || (temp.charAt(0) != 'X' && temp.charAt(0) != 'O'); temp = cin.nextLine())
            System.out.println("Please try again. Choose either X or O.\n");

        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }

    static boolean isSzt(String value) {
        for (int i = 0; i < value.length(); i++)
            if (!isDigit(value.charAt(i))) return true;
        return value.length() == 0;
    }

    static int SztChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for (temp = cin.nextLine(); isSzt(temp); temp = cin.nextLine())
            if (isSzt(temp))
                System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }
}
