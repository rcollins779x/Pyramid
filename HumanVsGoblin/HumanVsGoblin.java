package HumanVsGoblin;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class HumanVsGoblin {
    public static void main(String[] args) {
        Game game = new Game();

        intro();
        //player.SetName(StringChoice());
        System.out.println("Choose your difficulty!\n1. Easy\n2. Normal\n3. Hard");
        //game.SetDifficulty(IntChoice());

        char choice;
        game.init();
        do {
            game.print();
            choice = CharChoice();
            game.moveHuman(choice);
        } while (isGameOver(choice));

    }

    static char CharChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for(temp = cin.nextLine(); temp.length() != 1; temp = cin.nextLine())
            System.out.println("Please try again. That is not a valid string.\n");

        return temp.charAt(0) > 96 ? (char) (temp.charAt(0) - 32) : temp.charAt(0);
    }

    static String StringChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for(temp = cin.nextLine();temp.length() == 0;temp = cin.nextLine())
            System.out.println("Please try again. That is not a valid string.\n");
        return temp;
    }

    static boolean isInt(String value) {
        String temp = (value.charAt(0) == '-') ? value.substring(1) : value;
        for(int i = 0; i < temp.length(); i++)
            if(!isDigit(temp.charAt(i))) return true;
        return temp.length() == 0;
    }

    static int IntChoice() {
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        String temp;
        for(temp = cin.nextLine(); isInt(temp);temp = cin.nextLine())
           if(isInt(temp)) System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return Integer.parseInt(temp);
    }


    private static void intro() {
        System.out.println("Welcome to the most Brutal game Ever created!");
        System.out.println("What is your name challenger?");
    }
    static public boolean isGameOver(char choice) {
        if(choice == 'Q') return false;
        return true;
    }
}
