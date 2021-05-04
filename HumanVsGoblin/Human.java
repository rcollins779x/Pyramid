package HumanVsGoblin;

public class Human {
    private String name;
    protected int potions, HP, x, y, w, z;
    Human() {
        name = "Leroy";
        w = z = potions = 0;
        HP = 100;
        x = 10;
        y = 5;
    }

    public String getName() { return name; }
    public int getPotions() { return potions; }
    public int getHP() { return HP; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getZ() { return z; }

    public void SetName(String name) {
        this.name = name;
    }

    public void setW(int x) { w = x; }
    public void setZ(int y) { z = y; }
    public void setY(int y) { this.y += y; }
    public void setX(int x) { this.x += x; }
}

