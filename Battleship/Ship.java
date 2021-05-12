package Battleship;

class Ship {
    int len;
    String name;

    Ship(int len, String name) {
        this.len = len;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\t" + name + " \thits left: " + len;
    }
}
