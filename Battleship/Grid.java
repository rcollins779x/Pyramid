package Battleship;

public class Grid {
    String[][] board = new String[10][10];

    Grid() {
        for(int i = 1; i < 10; i++) {
            board[0][i] = " " + i + " ";
            board[i][0] = " " + (char)(i + 64) + " ";
            for (int j = 1; j < 10; j++) board[i][j] = " ~ ";
        }
        board[0][0] = "   ";
    }

    void print(int num) {
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
