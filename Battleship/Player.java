package Battleship;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private final String name;
    ArrayList<Ship> fleet = new ArrayList<>();          //Fleet
    Grid target = new Grid(), ocean = new Grid();       //Target grid and Ocean grid

    Player(String name) {
        this.name = name;                               //Init fleet
        fleet.add(new Ship(5, "carrier"));
        fleet.add(new Ship(4, "battleship"));
        fleet.add(new Ship(3, "destroyer"));
        fleet.add(new Ship(3, "destroyer"));
        fleet.add(new Ship(3, "submarine"));
        fleet.add(new Ship(3, "submarine"));
        fleet.add(new Ship(3, "submarine"));
        fleet.add(new Ship(2, "PatrolBoat"));
        fleet.add(new Ship(2, "PatrolBoat"));
        fleet.add(new Ship(2, "PatrolBoat"));
    }

    public String getName() {
        return name;
    }

    public void autoAssignShips() {                     //Randomizes ship locations
        for(int ship = 0; ship < fleet.size();) {                          //Iterates through fleet for assignment
            Random rand = new Random();
            boolean VorH = rand.nextInt(2) == 1;                    //Vertical or Horizontal
            int startY = rand.nextInt(9) + 1;                       //Random starting point
            int endY = startY + (VorH ? fleet.get(ship).len - 1 : 0);     //Ending point exclusive of ship length
            int startX = rand.nextInt(9)+1;
            int endX = startX + (!VorH ? fleet.get(ship).len - 1 : 0);

            startY -= endY > 9 ? endY - 9 : 0;                            //Ensures ship dimension falls within Grid
            endY -= endY > 9 ? endY - 9 : 0;
            startX -= endX > 9 ? endX - 9 : 0;
            endX -= endX > 9 ? endX - 9 : 0;
            ship += updateOcean(startY, startX, endY, endX, ship, false); //If collision detected, reassign same ship
        }
    }

    public void assignShips() {
        print(0);                                                       //Shows current board to user
        for(int ship = 0; ship < fleet.size(); print(ship)) {
            System.out.print("Starting grid location for " + fleet.get(ship).name + ": ");
            String xyz = GridChoice();                                  //Gets ship location from user

            int startY = xyz.charAt(0) - 64;     //Converts xyz into coordinates to pass to ocean.board
            int endY = startY + (xyz.charAt(2) == 'v' ? fleet.get(ship).len - 1 : 0);
            int startX = xyz.charAt(1) - 48;
            int endX = startX + (xyz.charAt(2) == 'h' ? fleet.get(ship).len - 1 : 0);

            startY -= endY > 9 ? endY - 9 : 0;                          //Ensures ship dimension falls within Grid
            endY -= endY > 9 ? endY - 9 : 0;
            startX -= endX > 9 ? endX - 9 : 0;
            endX -= endX > 9 ? endX - 9 : 0;
            ship += updateOcean(startY, startX, endY, endX, ship, true);  //If collision detected, reassign same ship
        }
    }

    void print(int ship) {
        System.out.println("\t\t\tTarget\t\t\t\t\t\t\tOcean\t\t\t\t\t" + name + "'s Fleet");
        for(int i = 0; i < 10; i++,System.out.println()) {
            for (int j = 0; j < 10; j++) System.out.print(target.board[i][j]);
            System.out.print("\t");
            for (int j = 0; j < 10; j++) System.out.print(ocean.board[i][j]);
            if(i < ship) System.out.print(fleet.get(i));
        }
    }

    void print(ArrayList<Ship> enemyFleet) {
        System.out.println("\t\t\tTarget\t\t\t\t\t\t\tOcean\t\t\t\t\t" + name + "'s Fleet\t\t\t\t\t\tEnemy Fleet");
        for (int i = 0; i < 10; i++, System.out.println()) {
            for (int j = 0; j < 10; j++) System.out.print(target.board[i][j]);
            System.out.print("\t");
            for (int j = 0; j < 10; j++) System.out.print(ocean.board[i][j]);
            if(i < fleet.size()) System.out.print(fleet.get(i) + "\t");
            else System.out.print("\t\t\t\t\t\t\t\t");
            if(i < enemyFleet.size()) System.out.print(enemyFleet.get(i));
        }
    }

    private int updateOcean(int startY, int startX, int endY, int endX, int ship, boolean verbose) {
        for(int i = startY; i <= endY; i++)
            for(int j = startX; j <= endX; j++)
                if(!ocean.board[i][j].equals(" ~ ")) {
                    if(verbose) System.out.println((ocean.board[i][j].charAt(1) == 'c' ? "Carrier" : ocean.board[i][j].charAt(1) == 'b' ? "Battleship" : ocean.board[i][j].charAt(1) == 'd' ? "Destroyer" : ocean.board[i][j].charAt(1) == 's' ? "Submarine" : "PatrolBoat") + " is already located there.");
                    return 0;                           //If collision detected, 0 will force same ship to try again
                }

        for(int i = startY; i <= endY; i++)
            for(int j = startX; j <= endX; j++)
                ocean.board[i][j] = " " + fleet.get(ship).name.charAt(0) + " ";
        return 1;                                       //If no collision detected, 1 will move to next ship for assignment
    }

    String computerTarget() {
        int y, x;
        Random rand = new Random();
        do {
            y = rand.nextInt(9) + 1;
            x = rand.nextInt(9) + 1;
        } while (!target.board[y][x].equals(" ~ "));    //Loop ensures that random target was not previously chosen
        return "" + (char)(y + 64) + (char)(x + 48);
    }

    void updateTarget(String shot, String result) {
        target.board[shot.charAt(0) - 64][shot.charAt(1) - 48] = result;
    }

    String checkIfHit(String shot) {
        boolean processHit = false;

        shot = "" + ocean.board[shot.charAt(0) - 64][shot.charAt(1) - 48].charAt(1); //Reduces shot to 1 char
        System.out.println(" and " + (shot.equals("~") ? "misses" : "hits a " + (shot.equals("c") ? "carrier" :
        shot.equals("b") ? "battleship" : shot.equals("d") ? "destroyer" : shot.equals("s") ? "submarine" : "Patrol Boat")));
        if(shot.equals("~")) return " m ";

        for (int i = 0; i < fleet.size() && !processHit; i++)       //If shot hit, cycle through fleet and reduce that ship len
            if (shot.equals("" + fleet.get(i).name.charAt(0))) {
                if (--fleet.get(i).len == 0) fleet.remove(i);       //If ship is destroyed, remove ship
                processHit = true;
            }
        return " X ";
    }

    static String GridChoice() {
        Scanner cin = new Scanner(System.in);                                       //Init Scanner
        String ans = cin.nextLine();

        for(boolean isAnsGood = false; !isAnsGood; ) {
            if(ans.length() == 3)
                ans =   ""    + (Character.isLowerCase(ans.charAt(0)) ? (char) (ans.charAt(0) - 32) : ans.charAt(0)) +
                ans.charAt(1) + (Character.isUpperCase(ans.charAt(2)) ? (char) (ans.charAt(2) + 32) : ans.charAt(2));
            if (ans.length( ) == 3 &&  ans.charAt(0)  >  64 && ans.charAt(0)  <  74 && ans.charAt(1) > 48 &&
                ans.charAt(1) < 58 && (ans.charAt(2) == 104 || ans.charAt(2) == 118))  isAnsGood = true;
            else {
                System.out.println("Please try again. That is not a valid grid instruction. (A1v or I9h)\n");
                ans = cin.nextLine();
            }
        }
        return  ans;
    }
}
