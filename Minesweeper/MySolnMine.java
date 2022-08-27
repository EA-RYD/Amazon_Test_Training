package Minesweeper;
import java.util.*;

public class MySolnMine {
    public static void main(String[] args) {
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3,0};
        for (char[] b : updateBoard(board, click)) {
            for (char c : b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    //flood island where clicked 
    public static char[][] updateBoard(char[][] board, int[] click) {
        int[][] dir = {{0,1},{0,-1},{1,-1},{-1,-1},{-1,1},{-1,0},{1,0},{1,1}};
        floodBoard(board, dir,click[0],click[1]);
        return board;
    }

    private static void floodBoard(char[][] board, int[][] dir, int i, int j) {
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        } else {
            int minesAround = 0;
            board[i][j] = 'B';
            ArrayList<int[]> coords = new ArrayList<>();
            for (int k = 0; k < dir.length;k++) {
                int newI = i + dir[k][0];
                int newJ = j + dir[k][1];

                if (isInvalid(board, newI, newJ)) {
                    continue;
                } else if (board[newI][newJ] == 'M') {
                    minesAround++;
                } else if (board[newI][newJ] == 'E') {
                    coords.add(new int[] {newI,newJ});
                }
            }
            if (minesAround > 0) 
                board[i][j] = (char) (minesAround + '0');
            else 
                coords.forEach(x -> floodBoard(board, dir, x[0], x[1]));
        }
    }

    private static boolean isInvalid(char[][] board, int i, int j) {
        return (i > board.length-1 || i < 0 || j > board[i].length-1 || j < 0);
    }


}
