package HumanVsGoblin;

import java.util.Random;

public class Game {
    private int diff;

    private String [][]map = new String[10][20];
    private String [][]path = new String[10][20];
    Human human = new Human();
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
                map[i][j] = ".";
                path[i][j] = " ";
            }
        }
        for(int i = 0;i < 4; i++) goblin[i] = new Goblin(i);
    }
    public void print() {
        System.out.println("\n\n\n");
        for(int i = 0; i < 10; i++, System.out.println()) {
            for (int j = 0; j < 20; j++) System.out.print(map[i][j] + path[i][j]);

            if (i == 0) System.out.print("\tQ = quit W = north A = east S = south D = west 0 = you X = Goblins");
            if (i == 2) System.out.print("\tPotions left: " + human.getPotions());
            if (i == 3) System.out.print("\tHP remaining: " + human.getHP());
            if (i == 5) System.out.print("\tSurvive " + human.getName() + "... if you can!");
            if (i == 7) System.out.print("\tGx: " + goblin[0].getX() + " Gy: " + goblin[0].getY() + "\tHx: " + human.getX() + " Hy: " + human.getY());
        }
    }

    public void moveHuman(char choice) {
        if(choice == 'Q') return;
        path[human.getY()][human.getX()] = " ";
        human.setX(choice == 'D' ? 1 : choice == 'A' ? -1 : 0);
        human.setY(choice == 'S' ? 1 : choice == 'W' ? -1 : 0);
        path[human.getY()][human.getX()] = "0";
    }
    public void moveGoblins() {
        for(int i = 0; i < 4; i++) {
            Random rand = new Random();
            if (rand.nextInt(2) == 1) {
                path[goblin[i].getY()][goblin[i].getX()] = " ";
                int x = human.getX() - goblin[i].getX();
                int y = human.getY() - goblin[i].getY();
                if (Math.abs(x) > Math.abs(y)) goblin[i].setX(x > 0 ? 1 : -1);
                else goblin[i].setY(y > 0 ? 1 : -1);
            }
            path[goblin[i].getY()][goblin[i].getX()] = String.valueOf(i+1);
        }
    }
}
