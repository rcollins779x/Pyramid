package HumanVsGoblin;

public class Human {
    private String name;
    protected int potions, HP, x, y, w, z;
    Human() {
        name = "unknown";
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

    public boolean input(String choice) {
        if(choice.equals("Q")) return false;
        w = x;
        z = y;
        if(choice.equals("W")) if(y > 0)  --y;
        if(choice.equals("S")) if(y < 10) ++y;
        if(choice.equals("A")) if(x > 0)  --x;
        if(choice.equals("D")) if(x < 20) ++x;
        return true;
    }
}

