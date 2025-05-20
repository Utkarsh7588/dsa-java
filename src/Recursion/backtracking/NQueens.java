package Recursion.backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n=5;
        boolean [][] board=new boolean[n][n];
        for( int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=false;
            }
        }
        System.out.println(queens(board,0));
    }
    static int queens(boolean[][] board, int r) {
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for(int c=0;c<board[0].length;c++){
         if(canPlace(c,r,board)){
             board[r][c]=true;
             count +=queens(board,r+1);
             board[r][c]=false;
         }
        }
        return count;
    }

    private static boolean canPlace(int c, int r, boolean[][]board) {
        for(int i=r-1;i>=0;i--){
            if(board[i][c]){
                return false;
            }
        }
        int minLeft=Math.min(r,c);
        for(int j=1;j<=minLeft;j++){
            if(board[r-j][c-j]){
                return false;
            }
        }
        int minRight=Math.min(r,board[0].length-1-c);
        for(int k=1;k<=minRight;k++){
            if(board[r-k][c+k]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean q : row) {
                if(q){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }

            }
            System.out.println();
        }
    }


}
