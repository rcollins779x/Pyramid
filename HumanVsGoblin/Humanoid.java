package HumanVsGoblin;

public class Humanoid {
    protected int x, y, HP;

    public void setX(int x) {
        if((x > 0 && this.x < 19) || (x < 0 && this.x > 0)) this.x += x;
    }
    public void setY(int y) {
        if((y > 0 && this.y < 9) || (y < 0 && this.y > 0)) this.y += y;
    }
    public int checkX(char choice) {
        int newX = choice == 'A' ? x - 1 : choice == 'D' ? x + 1 : x;
        return newX < 0 ? 0 : Math.min(newX, 19);
    }
    public int checkY(char choice) {
        int newY = choice == 'W' ? y - 1 : choice == 'S' ? y + 1 : y;
        return newY < 0 ? 0 : Math.min(newY, 9);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getHP() {
      return HP;
    }

    public boolean isNextTo() {
        return false;
    }
}
