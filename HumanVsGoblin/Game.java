package HumanVsGoblin;

import java.util.Random;
import static HumanVsGoblin.HumanVsGoblin.isInt;

public class Game {
    private int diff;

    //private String [][]map = new String[10][20];
    private final String [][]path = new String[10][20];
    Player player = new Player();
    Goblin[] goblin = new Goblin[4];

    Game() {}
/*    public void SetDifficulty(int diff) {
        this.diff = diff;
    }
    public int getDifficulty() {
        return diff;
    }*/
    public void init() {
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                path[i][j] = " ";
            }
        }
        for(int i = 0;i < 4; i++) goblin[i] = new Goblin(i);
    }
    public void print() {
        for(int i = 0; i < 10; i++, System.out.println()) {
            for (int j = 0; j < 20; j++) System.out.print(path[i][j]);

            if (i == 0) System.out.print("\tquit: Q north: W east: A south: S west: S You: 0 Goblins: 1-9");
            if (i == 2) System.out.print("\tPotions left: " + player.getPotions());
            if (i == 3) System.out.print("\tHP remaining: " + player.getHP());
            if (i == 5) System.out.print("\tSurvive " + player.getName() + "... if you can!");
            if (i == 7) System.out.print("\tGx: " + goblin[0].getX() + " Gy: " + goblin[0].getY() + "\tHx: " + player.getX() + " Hy: " + player.getY());
        }
    }

    public void checkDestination(char choice) {
        String check = path[player.checkY(choice)][player.checkX(choice)];
        if(check.equals(" ")) System.out.println("Clear.");
        if(check.equals("p")) System.out.println("Potion!");
        if(check.equals("w")) System.out.println("Weapon!");
        if(isInt(check)) System.out.println("Goblin!");
    }
    public void update(char choice) {
        path[player.getY()][player.getX()] = " ";
        player.movePlayer(choice);
        path[player.getY()][player.getX()] = "0";

        for (int i = 0; i < 4; i++) {
            Random rand = new Random();                                     //Potion drop
            int   = rand.nextInt(2);
            int potion = rand.nextInt(2);
            int y = goblin[i].getY(), x = goblin[i].getX();
            int Py = player.getY(), Px = player.getX();
            if (move == 1)m67
                if (Math.abs(Px - x) > Math.abs(Py - y)) goblin[i].setX(Px - x > 0 ? 1 : -1);
                else goblin[i].setY(Py - y > 0 ? 1 : -1);
            if (move == 1 && potion == 1)                                   //Potion drop
                path[goblin[i].getY()][goblin[i].getX()] = "p";
            else
                path[goblin[i].getY()][goblin[i].getX()] = " ";

            //goblin[i].moveGoblin(player.getX(),player.getY());

            path[goblin[i].getY()][goblin[i].getX()] = String.valueOf(i + 1);
        }
    }
}
