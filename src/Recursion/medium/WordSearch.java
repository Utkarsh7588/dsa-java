package Recursion.medium;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board1, "ABCCED")); // true
        System.out.println(exist(board1, "SEE"));    // true
        System.out.println(exist(board1, "ABCB"));
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        System.out.println(exist(board, "cdba"));

    }

    public static boolean exist(char[][] board, String word) {
        return helper(board, word, 0, 0, false);
    }

    public static boolean helper(char[][] board, String word, int r, int c, boolean firstFound) {
        if (word.isEmpty()) {
            return true;
        }
        if (r == board.length || r == -1) {
            return false;
        }
        if (c == board[0].length || c == -1) {
            return false;
        }

        if (board[r][c] == word.charAt(0)) {
            char temp = board[r][c];
            board[r][c] = '.';
            if (helper(board, word.substring(1), r, c + 1, true)) {
                board[r][c] = temp;
                return true;
            } else if (helper(board, word.substring(1), r + 1, c, true)) {
                board[r][c] = temp;
                return true;
            } else if (helper(board, word.substring(1), r, c - 1, true)) {
                board[r][c] = temp;
                return true;
            } else if (helper(board, word.substring(1), r - 1, c, true)) {
                board[r][c] = temp;
                return true;
            }
            board[r][c] = temp;

        }
        if (firstFound) {
            return false;
        }
        if (c < board[0].length - 1) {
            return helper(board, word, r, c + 1, false);
        }
        return helper(board, word, r + 1, 0, false);

    }
}
