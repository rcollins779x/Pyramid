package TicTacToe;

import java.util.Scanner;

import static java.lang.Character.isDigit;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] loc = new char[3][3];

        init(loc);

        System.out.println("Welcome to Tic-Tac-Toe!\nDo you want to be X or O?");
        char player = CharChoice(), comp = player == 'X' ? 'O' : 'X';

        System.out.println("The computer will go first.");
        computerTurn(loc, comp);
        board(loc);
        System.out.println("What is your next move?");
        int choice = IntChoice();
    }

    private static void computerTurn(char[][] loc, char xo) {
        char ox = xo == 'X' ? 'O' : 'X';
        int counter = 0;
        if (loc[0][0] != ox && loc[1][1] != ox && loc[2][2] != ox) {
            if (loc[0][0] == ' ' && counter == 0) {
                loc[0][0] = xo;
                counter++;
            }
            if (loc[2][2] == ' ' && counter == 0) {
                loc[2][2] = xo;
                counter++;
            }
            if (loc[1][1] == ' ' && counter == 0) {
                loc[1][1] = xo;
                counter++;
            }
        }
        if (loc[0][0] != ox && loc[0][1] != ox && loc[0][2] != ox) {
            if (loc[0][0] == ' ' && counter == 0) {
                loc[0][0] = xo;
                counter++;
            }
            if (loc[0][2] == ' ' && counter == 0) {
                loc[0][2] = xo;
                counter++;
            }
            if (loc[0][1] == ' ' && counter == 0) {
                loc[0][1] = xo;
                counter++;
            }
        }
        if (loc[0][0] != ox && loc[1][0] != ox && loc[2][0] != ox) {
            if (loc[0][0] == ' ' && counter == 0) {
                loc[0][0] = xo;
                counter++;
            }
            if (loc[2][0] == ' ' && counter == 0) {
                loc[2][0] = xo;
                counter++;
            }
            if (loc[1][0] == ' ' && counter == 0) {
                loc[1][0] = xo;
                counter++;
            }
        }
        if (loc[2][0] != ox && loc[2][1] != ox && loc[2][2] != ox) {
            if (loc[2][0] == ' ' && counter == 0) {
                loc[2][0] = xo;
                counter++;
            }
            if (loc[2][2] == ' ' && counter == 0) {
                loc[2][2] = xo;
                counter++;
            }
            if (loc[2][1] == ' ' && counter == 0) {
                loc[2][1] = xo;
                counter++;
            }
        }
        if (loc[0][2] != ox && loc[1][2] != ox && loc[2][2] != ox) {
            if (loc[0][2] == ' ' && counter == 0) {
                loc[0][2] = xo;
                counter++;
            }
            if (loc[2][2] == ' ' && counter == 0) {
                loc[2][2] = xo;
                counter++;
            }
            if (loc[1][2] == ' ' && counter == 0) {
                loc[1][2] = xo;
                counter++;
            }
        }
        if (loc[0][1] != ox && loc[1][1] != ox && loc[2][1] != ox) {
            if (loc[1][1] == ' ' && counter == 0) {
                loc[1][1] = xo;
                counter++;
            }
            if (loc[0][1] == ' ' && counter == 0) {
                loc[0][1] = xo;
                counter++;
            }
            if (loc[2][1] == ' ' && counter == 0) {
                loc[2][1] = xo;
                counter++;
            }
        }
        if (loc[1][0] != ox && loc[1][1] != ox && loc[1][2] != ox) {
            if (loc[1][1] == ' ' && counter == 0) {
                loc[1][1] = xo;
                counter++;
            }
            if (loc[1][0] == ' ' && counter == 0) {
                loc[1][0] = xo;
                counter++;
            }
            if (loc[1][2] == ' ' && counter == 0) {
                loc[1][2] = xo;
                counter++;
            }
        }

    }

    private static void init(char[][] loc) {
        for (int i = 0; i < loc.length; i++)
            for (int j = 0; j < loc.length; j++) loc[i][j] = ' ';
    }

    static void board(char[][] loc) {

        System.out.printf(" %c | %c | %c \t %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2], loc[0][0] == ' ' ? '1' : ' ', loc[0][1] == ' ' ? '2' : ' ', loc[0][2] == ' ' ? '3' : ' ');
        System.out.println("---+---+---\t---+---+---");
        System.out.printf(" %c | %c | %c \t %c | %c | %c \n", loc[1][0], loc[1][1], loc[1][2], loc[1][0] == ' ' ? '4' : ' ', loc[1][1] == ' ' ? '5' : ' ', loc[1][2] == ' ' ? '6' : ' ');
        System.out.println("---+---+---\t---+---+---");
        System.out.printf(" %c | %c | %c \t %c | %c | %c \n", loc[2][0], loc[2][1], loc[2][2], loc[2][0] == ' ' ? '7' : ' ', loc[2][1] == ' ' ? '8' : ' ', loc[2][2] == ' ' ? '9' : ' ');
    }

    static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for (temp = cin.nextLine(); temp.length() != 1 || (temp.charAt(0) != 'X' && temp.charAt(0) != 'O'); temp = cin.nextLine())
            System.out.println("Please try again. Choose either X or O.\n");

        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }

    static boolean isInt(String value) {
        //String temp = (value.charAt(0) == '-') ? value.substring(1) : value;
        for (int i = 0; i < value.length(); i++)
            if (!isDigit(value.charAt(i))) return true;
        return value.length() == 0;
    }

    static int IntChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for (temp = cin.nextLine(); isInt(temp); temp = cin.nextLine())
            if (isInt(temp))
                System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }
}
