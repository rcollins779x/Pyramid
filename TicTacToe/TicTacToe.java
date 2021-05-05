package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] loc = new char[3][3];
        loc[0][0] = loc[0][1] = loc[0][2] = 'X';
        loc[1][0] = loc[1][1] = loc[1][2] = '0';
        loc[2][0] = loc[2][1] = loc[2][2] = '%';

        board(loc);
    }
    static void board(char[][] loc) {

        System.out.printf(" %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2]);
        System.out.println("---+---+---");
        System.out.printf(" %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2]);
        System.out.println("---+---+---");
        System.out.printf(" %c | %c | %c \n", loc[0][0], loc[0][1], loc[0][2]);
    }
}
