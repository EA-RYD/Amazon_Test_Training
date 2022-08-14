package Battleships_on_a_Board;

public class MySolnBOAB {
    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(countBattleships(board));
    } 

    // FASTER THAN 100% !!!, less than 86%
    public static int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[i].length; j++) 
                if (board[i][j] == 'X') {
                    floodShip(board, i, j);
                    count++;
                }
            

        return count;
    }

    private static void floodShip(char[][] board, int i, int j) {
        if (board[i][j] != 'X') {
            return;
        } else {
            board[i][j] = '-';
            if (i != board.length-1)
                floodShip(board, i+1, j);
            if (j != board[i].length - 1)
                floodShip(board, i, j+1);
            if (i != 0)
                floodShip(board, i-1, j);
            if (j != 0)
                floodShip(board, i, j-1);
        }
    }
}
