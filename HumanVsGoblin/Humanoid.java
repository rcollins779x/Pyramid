package HumanVsGoblin;

class Humanoid {
    protected int x, y, HP;

    void setX(int x) {
        if((x > 0 && this.x < 19) || (x < 0 && this.x > 0)) this.x += x;
    }
    void setY(int y) {
        if((y > 0 && this.y < 9) || (y < 0 && this.y > 0)) this.y += y;
    }
    int checkX(char choice) {
        int newX = choice == 'A' ? x - 1 : choice == 'D' ? x + 1 : x;
        return newX < 0 ? 0 : Math.min(newX, 19);
    }
    int checkY(char choice) {
        int newY = choice == 'W' ? y - 1 : choice == 'S' ? y + 1 : y;
        return newY < 0 ? 0 : Math.min(newY, 9);
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
    int getHP() {
      return HP;
    }

    boolean isNextTo() {
        return false;
    }
}
