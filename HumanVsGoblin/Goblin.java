package HumanVsGoblin;

public class Goblin {
    protected int potions, HP, x, y;
    Goblin(int i) {
        potions = 0;
        HP = 20;
        y = 0;
        x = 0;
        if(i == 1 || i == 3) y = 9;
        if(i == 2 || i == 3) x = 19;
    }

    public int getPotions() { return potions; }
    public int getHP() { return HP; }
    public int getX() { return x; }
    public int getY() { return y; }

    public void setY(int y) {
        if((y > 0 && this.y < 9) || (y < 0 && this.y > 0)) this.y += y;
    }
    public void setX(int x) {
        if((x > 0 && this.x < 19) || (x < 0 && this.x > 0)) this.x += x;
    }
}

