package HangmanV2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanV2 {
    public static void main(String[] args) {
        String temp = "y", name;
        int i;                               //Init variables
        Random rand = new Random();                             //Init Random chooser
        ArrayList<String> word = new ArrayList<>();/* {{           //Possible Hangman Words
            add("CAT"); add("WINNER");  add("SUCCESS");         //By no means am I suggesting that
            add("DOG"); add("LOOSER");  add("FAILURE");         //cats are better or worse than dogs ;-D
        }};*/
        Path dic = Path.of("scr/HangmanV2/gallow.txt");
        try {
            word = readAFile(dic);
        } catch (IOException ignore) {
            System.out.println("Unable to load words.");
        }
        System.out.println(dic.toAbsolutePath());
        while (temp.equals("y") || temp.equals("Y")) {          //Setting up for replay ability
            String blank = "", missed = "", pick = word.get(rand.nextInt(10000));          //Picks a random word
            boolean winner = false, match = false;
            for (i = 0; i < pick.length(); i++) blank += "_ ";  //Init blanks for the picked word

            for (int miss = 0; miss < 7 && !winner; miss++, match = false) {
                gibbet(miss);                                   //Prints the Gallows with appropriate misses
                System.out.println("Missed letters: " + missed + "\n" + blank + "\nGuess a letter.");
                temp = StringChoice(temp);                      //Gets user guess

                char guess = temp.charAt(0) > 91 ? (char)(temp.charAt(0) - 32) : temp.charAt(0); //Changes to Uppercase

                for (temp = "", i = 0; i < pick.length(); i++)  //Checks guess with pick
                    if (guess == pick.charAt(i)) {
                        temp += guess + " ";                    //Updates blank with the correct letter
                        match = true;                           //Remembers that a match is found
                    } else temp += (blank.charAt(i * 2) + " "); //Copies previous guesses from blank

                if (match) miss--; else missed += guess;        //If match was found do code clean up

                for (winner = true, blank = temp, i = 0; i < pick.length(); i++)    //Updates blank
                    if (blank.charAt((i * 2)) != pick.charAt(i)) winner = false;    //Checks if game is solved
            }
            System.out.println(winner ? "Yes! The secret word is " + pick + "! You have won!" : "Better luck next Time!");
            while (!temp.equals("y") && !temp.equals("Y") && !temp.equals("n") && !temp.equals("N")) {
                System.out.println("Do you want to play again? y or n");            //Great replay value!
                temp = StringChoice(temp);
                if (!temp.equals("y") && !temp.equals("Y") && !temp.equals("n") && !temp.equals("N"))
                    System.out.println("I didn't understand your answer. Try again.");
            }
        }
    }

    private static void gibbet(int miss) {                                          //Pretty isn't it?
        Path file = Path.of("src/HangmanV2/gallow.txt");
        String state = "H A N G M A N\n" + " +-----+\n " +
                (miss > 0 ? "O" : " ") + "     |\n" + (miss > 2 ? "/" : " ") +
                (miss > 1 ? "|" : " ") + (miss > 3 ? "\\" : " ") + "    |\n " +
                (miss > 4 ? "|" : " ") + "     |\n" + (miss > 5 ? "/ " : "  ") +
                (miss > 6 ? "\\" : " ") + "   ===\n";
        try {
            writeToAFile(file, state);
            System.out.println(readAFile(file).stream().reduce("", (a, b) -> a + "\n" + b));
        } catch (IOException ignored) {}
    }
    static void highScore(Path file, String rank) {

    }
    static String StringChoice(String temp) {
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        for(temp = cin.nextLine();temp.length() == 0;temp = cin.nextLine())
            System.out.println("Please try again. That is not a valid string.\n");
        return temp;
    }
    static void writeToAFile(Path file, String state) throws IOException {
        Files.writeString(file,state, StandardOpenOption.CREATE);
    }

    static ArrayList<String> readAFile(Path file) throws IOException {
        ArrayList<String> read = new ArrayList<>();
        if(Files.isReadable(file))
            Files.lines(file).forEach(read::add);
        System.out.println(read);
        return read;
    }
}