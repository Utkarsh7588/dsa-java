package Recursion.hard;

public class Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
    }
    public static void solveSudoku(char[][] board) {
        helper(board,0,0);
    }

    static boolean helper(char[][] board, int c, int r) {
        if (r == board.length) {
            return true;
        }
        if(c==board.length){
           return helper(board,0,r+1);

        }
        if(board[r][c]=='.'){
            for (int i = 1; i <= 9; i++) {
                if (canPlace(board, c, r, i)) {
                    board[r][c]=(char)('0'+i);
                    if(helper(board, c+1, r))return true;
                    board[r][c]='.';
                }
            }
            return false;
        }
        else{
            return helper(board,c+1,r);
        }
    }

    static boolean canPlace(char[][] board, int c, int r, int num) {
        char ch = (char) ('0' + num);
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == ch && i != r) {
                return false;
            }
            if (board[r][i] == ch && i != c) {
                return false;
            }
        }
        int rowStart = (r / 3) * 3;
        int colStart = (c / 3) * 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(char[][] board) {
        System.out.print("[");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\"" + board[i][j] + "\"");
                if (j < board[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < board.length - 1) {
                System.out.print(",");
                System.out.println();
            }
        }
        System.out.print("]");
    }

}
