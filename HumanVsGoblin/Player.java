package HumanVsGoblin;

public class Player extends Humanoid {
    private String name;
    protected int potions, HP;
    Player() {
        name = "Leroy";
        potions = 0;
        HP = 100;
        x = 10;
        y = 5;
    }

    public String getName() { return name; }
    public int getPotions() { return potions; }

    public void SetName(String name) {
        this.name = name;
    }

    public void movePlayer(char choice) {
        if(choice == 'Q') return;
        setX(choice == 'D' ? 1 : choice == 'A' ? -1 : 0);
        setY(choice == 'S' ? 1 : choice == 'W' ? -1 : 0);
    }
}

