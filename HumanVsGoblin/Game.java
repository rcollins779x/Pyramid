package HumanVsGoblin;

import java.util.Random;

public class Game {
    private int diff;

    private String [][]map = new String[10][20];
    private String [][]path = new String[10][20];
    Human human = new Human();
    Goblin[] goblin = new Goblin[5];

    Game() {}
    public void SetDifficulty(int diff) {
        this.diff = diff;
    }
    public int getDifficulty() {
        return diff;
    }

    public void init() {
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = ".";
                path[i][j] = " ";
            }
        }
    }

    public void print() {
        System.out.println("\n\n\n");
        for(int i = 0; i < 10; i++, System.out.println()) {
            for (int j = 0; j < 20; j++) {
                System.out.print(map[i][j] + path[i][j]);
            }
            if (i == 0) System.out.print("\tQ = quit W = north A = east S = south D = west 0 = you X = Goblins");
            if (i == 2) System.out.print("\tPotions left: " + human.getPotions());
            if (i == 3) System.out.print("\tHP remaining: " + human.getHP());
            if (i == 5) System.out.print("\tSurvive " + human.getName() + "... if you can!");
            if (i == 7) System.out.print("\tx: " + human.getX() + " y: " + human.getY() + " w: " + human.getW() + " z: " + human.getZ());
        }
    }

    public void moveHuman(char choice) {
        if(choice == 'Q') return;
        human.setW(human.getX());
        human.setZ(human.getY());
        if(choice == 'W') if(human.getY() > 0) human.setY(-1);
        if(choice == 'S') if(human.getY() < 10) human.setY(1);
        if(choice == 'A') if(human.getX() > 0)  human.setX(-1);
        if(choice == 'D') if(human.getX() < 20) human.setX(1);
        path[human.getZ()][human.getW()] = " ";
        path[human.getY()][human.getX()] = "0";
    }
    public void moveGoblins() {
        goblin[0].setW(goblin[0].getX());
        goblin[0].setZ(goblin[0].getY());

        Random rand = new Random();
        if(choice == 'W') if(goblin[0].getY() > 0) goblin[0].setY(-1);
        if(choice == 'S') if(goblin[0].getY() < 10) goblin[0].setY(1);
        if(choice == 'A') if(goblin[0].getX() > 0)  goblin[0].setX(-1);
        if(choice == 'D') if(goblin[0].getX() < 20) goblin[0].setX(1);
        path[goblin[0].getZ()][goblin[0].getW()] = " ";
        path[goblin[0].getY()][goblin[0].getX()] = "0";
    }
}
