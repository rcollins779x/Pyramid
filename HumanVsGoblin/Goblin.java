package HumanVsGoblin;

public class Goblin {
    private String name;
    protected int potions, HP, x, y, w, z;
    Goblin() {
        w = z = potions = 0;
        HP = 20;
        x = 0;
        y = 0;
    }

    public int getPotions() { return potions; }
    public int getHP() { return HP; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getZ() { return z; }

    public void setW(int x) { w = x; }
    public void setZ(int y) { z = y; }
    public void setY(int y) { this.y += y; }
    public void setX(int x) { this.x += x; }
}

