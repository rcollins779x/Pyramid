package Battleship;
import java.util.Scanner;
import static java.lang.Character.isDigit;

class Battleship {
    public static void main(String[] args) {
        Player[] player = new Player[2];
        int players = menu(player);                                                     //Determine if 0, 1, or 2 players

        for(int round = 0;player[0].fleet.size() > 0 && player[1].fleet.size() > 0;) {  //Round Counter
            System.out.println("Round: " + ++round);                                    //Alternate between opponents
            if(player[1].fleet.size() > 0) if(players > 0) humanTurn(player, 1); else computerTurn(player, 1);
            if(player[0].fleet.size() > 0) if(players < 2) computerTurn(player, 0); else humanTurn(player, 0);
        }                                                                               //Game Over Response
        String winner = (players == 1 && player[1].fleet.size() == 0 ? "Better luck next time! " : "Congratulations! ");
        System.out.print(winner + (player[0].fleet.size() == 0 ? player[1].getName() : player[0].getName()) + " has WON the game!");
    }

    private static int menu(Player[] player) {
        int players, placement;
        System.out.println("Battleship Multiplayer");
        do {
            System.out.println("How many human players? 0, 1, or 2?");
            players = IntChoice();
            if(players < 0 || players > 2) System.out.println("I don't understand. Please try again.");
        } while (players < 0 || players > 2);
        switch (players) {                                          //Code for alternating between 0, 1, or 2 players
            case 0: {
                player[0] = new Player("Computer 0");
                player[0].autoAssignShips();
                player[1] = new Player("Computer 1");
                player[1].autoAssignShips();
                break;
            }
            case 1: {
                player[0] = new Player("Computer");          //Computer ship assignment
                player[0].autoAssignShips();

                System.out.print("Enter Your name: ");             //Player ship assignment
                player[1] = new Player(StringChoice());
                do {
                    System.out.println("1. You choose your ship placement\n2. Random ship placement");
                    placement = IntChoice();
                } while (placement < 1 || placement > 2);

                if (placement == 1) player[1].assignShips();
                else player[1].autoAssignShips();
                break;
            }
            case 2: {
                System.out.print("Enter 1st player name: ");
                player[1] = new Player(StringChoice());
                do {
                    System.out.println("1. You choose your ship placement\n2. Random ship placement");
                    placement = IntChoice();
                } while (placement < 1 || placement > 2);

                if (placement == 1) player[1].assignShips();
                else player[1].autoAssignShips();

                System.out.print("Enter 2nd player name: ");
                player[0] = new Player(StringChoice());
                do {
                    System.out.println("1. You choose your ship placement\n2. Random ship placement");
                    placement = IntChoice();
                } while (placement < 1 || placement > 2);

                if (placement == 1) player[0].assignShips();
                else player[0].autoAssignShips();
                break;
            }
        }
        return players;
    }

    static void computerTurn(Player[] player, int index) {          //If computer hits 1st shot, it gets a free 2ns shot
        for (int hitCounter = 0; hitCounter < 2 && player[0].fleet.size() > 0 && player[1].fleet.size() > 0;) {
            String shot = player[index].computerTarget();
            System.out.print(player[index].getName() + "'s turn: " + shot);

            String result = player[(index + 1) % 2].checkIfHit(shot);   //check if shot hit enemy fleet

            hitCounter += result.equals(" m ") ? 2 : 1;             //If result missed, no free 2nd shot
            player[index].updateTarget(shot, result);               //Updates Target Board with result
        }
    }
    static void humanTurn(Player[] player, int index) {
        player[index].print(player[(index + 1) % 2].fleet);         //Print board of player and enemy's fleet
        System.out.print(player[index].getName() + "'s turn: ");
        String shot = Target();
        player[index].updateTarget(shot, player[(index + 1) % 2].checkIfHit(shot)); //Check enemy if shot hit
        player[index].print(player[(index + 1) % 2].fleet);         //Updates target board and prints it
    }

    static String Target() {
        Scanner cin = new Scanner(System.in);                       //Init Scanner
        String ans = cin.nextLine();                                //Gets target from human

        for(boolean isAnsGood = false; !isAnsGood; ) {
            if(ans.length() == 2)                                   //Formats charAt(0) to lowercase
                ans = "" + (Character.isLowerCase(ans.charAt(0)) ? (char) (ans.charAt(0) - 32) : ans.charAt(0)) + ans.charAt(1);
            if (ans.length() == 2 && ans.charAt(0) > 64 && ans.charAt(0) < 74 && ans.charAt(1) > 48 &&
                    ans.charAt(1) < 58) isAnsGood = true;           //Validates answer to be in the right format
            else {
                System.out.println("Valid targets are between A1 and I9.");
                ans = cin.nextLine();
            }
        }
        return  ans;
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
}
