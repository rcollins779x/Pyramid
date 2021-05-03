package NumbersGame;
import java.util.Random;
import java.util.Scanner;

public class NumbersGame {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Random rand = new Random();
        char again = 'y';
        int tries = 0, target = 1 + rand.nextInt(20);

        System.out.println("Hello! What is your name?");
        String name = cin.nextLine();
        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
        do {
            System.out.println("Take a guess.");
            int guess = cin.nextInt(); cin.nextLine();
            tries++;
            System.out.println("You guessed " + guess);
            if (guess > target) System.out.println("Your guess is too high.");
            if (guess < target) System.out.println("Your guess is too low.");
            if (guess == target) {
                System.out.println("Good job, " + name + " You guessed my number in " + tries + " guesses!\n" +
                        "Would you like to play again? (y or n)");
                String temp = cin.nextLine();
                if((again = temp.charAt(tries = 0)) == 'y') target = 1 + rand.nextInt(20);
            }
        } while (again == 'y');
    }
}