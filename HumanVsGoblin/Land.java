package HumanVsGoblin;

public class Land {
    private int diff;

    private String [][]map = new String[10][20];
    private String [][]path = new String[10][20];
    Human player = new Human();
    Goblin[] goblin = new Goblin[5];

    Land() {}
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
        //path[player.getY()][player.getX()] = "0";                   //load player
    }

    public void print() {
        System.out.println("\n\n\n");
        for(int i = 0; i < 10; i++, System.out.println()) {
            for (int j = 0; j < 20; j++) {
                System.out.print(map[i][j] + path[i][j]);
            }
            if (i == 0) System.out.print("\tQ = quit W = north A = east S = south D = west 0 = you X = Goblins");
            if (i == 2) System.out.print("\tPotions left: " + player.getPotions());
            if (i == 3) System.out.print("\tHP remaining: " + player.getHP());
            if (i == 5) System.out.print("\tSurvive ... if you can!");
            if (i == 7) System.out.print("\tx: " + player.getX() + " y: " + player.getY() + " w: " + player.getW() + " z: " + player.getZ());
        }
    }

    public void updateTurn() {
        path[player.getZ()][player.getW()] = " ";
        path[player.getY()][player.getX()] = "0";
    }
}
