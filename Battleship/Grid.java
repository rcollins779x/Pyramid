package Battleship;

class Grid {
    String[][] board = new String[10][10];

    Grid() {                                //Formats Frame for board to have 1st row 1-9 and 1st column A-I
        for(int i = 1; i < 10; i++) {
            board[0][i] = " " + i + " ";
            board[i][0] = " " + (char)(i + 64) + " ";
            for (int j = 1; j < 10; j++) board[i][j] = " ~ ";
        }
        board[0][0] = "   ";
    }
}
