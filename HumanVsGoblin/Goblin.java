package HumanVsGoblin;

import java.util.Random;

class Goblin extends Humanoid {
    protected int potions;
    Goblin(int i) {
        potions = 0;
        HP = 20;
        if(i == 1 || i == 3) y = 9;
        if(i == 2 || i == 3) x = 19;
    }

    public int getPotions() { return potions; }

    void moveGoblin(int Px, int Py) {
        Random rand = new Random();
        if (rand.nextInt(2) == 1)
            if (Math.abs(Px - x) > Math.abs(Py - y)) setX(Px - x > 0 ? 1 : -1);
            else setY(Py - y > 0 ? 1 : -1);
    }
}

