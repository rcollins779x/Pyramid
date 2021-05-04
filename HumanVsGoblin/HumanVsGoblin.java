package HumanVsGoblin;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class HumanVsGoblin {
    public static void main(String[] args) {
        Land game = new Land();
        try {
            System.out.println("IntChoice: " + IntChoice());
        } catch (IOException e) {
            e.printStackTrace();
        }
        intro();
        //player.SetName(StringChoice());
        System.out.println("Choose your difficulty!\n1. Easy\n2. Normal\n3. Hard");
        //game.SetDifficulty(IntChoice());

        String choice;
        game.init();
        do {
            choice = StringChoice();
            game.updateTurn();
            game.print();
        } while (game.player.input(choice));

    }

    static boolean isInt(String value) {
        String temp = (value.charAt(0) == '-') ? value.substring(1) : value;
        for(int i = 0; i < temp.length(); i++)
            if(!isDigit(temp.charAt(i))) return true;
        return temp.length() == 0;
    }

    static int IntChoice() throws IOException {
        //Scanner cin = new Scanner(System.in);                                       //Init Scanner
        //String temp;
        //for(temp = cin.nextLine(); isInt(temp);temp = cin.nextLine())
        //   if(isInt(temp)) System.out.println("Please try again. " + (temp.equals("") ? "That" : temp) + " is not a valid integer.\n");
        return System.in.read();
    }
    static String StringChoice() {
        String temp;
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for(temp = cin.nextLine(); temp.length() == 0; temp = cin.nextLine())
            System.out.println("Please try again. That is not a valid string.\n");
        return temp;
    }
    private static void intro() {
        System.out.println("Welcome to the most Brutal game Ever created!");
        System.out.println("What is your name challenger?");
    }
}
