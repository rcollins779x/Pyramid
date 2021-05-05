package HumanVsGoblin;

public class Human {
    private String name;
    protected int potions, HP, x, y;
    Human() {
        name = "Leroy";
        potions = 0;
        HP = 100;
        x = 10;
        y = 5;
    }

    public String getName() { return name; }
    public int getPotions() { return potions; }
    public int getHP() { return HP; }
    public int getX() { return x; }
    public int getY() { return y; }

    public void SetName(String name) {
        this.name = name;
    }

    public void setY(int y) {
        if((y > 0 && this.y < 9) || (y < 0 && this.y > 0)) this.y += y;
    }
    public void setX(int x) {
        if((x > 0 && this.x < 19) || (x < 0 && this.x > 0)) this.x += x;
    }
}

