package HumanVsGoblin;

class Player extends Humanoid {
    private String name;
    protected int potions, HP;
    Player() {
        name = "Leroy";
        potions = 0;
        HP = 100;
        x = 10;
        y = 5;
    }

    String getName() { return name; }
    int getPotions() { return potions; }

    void SetName(String name) {
        this.name = name;
    }

    void movePlayer(char choice) {
        if(choice == 'Q') return;
        setX(choice == 'D' ? 1 : choice == 'A' ? -1 : 0);
        setY(choice == 'S' ? 1 : choice == 'W' ? -1 : 0);
    }
}

