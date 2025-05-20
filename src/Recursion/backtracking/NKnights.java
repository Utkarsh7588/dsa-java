package Recursion.backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n=8;
        boolean [][] board=new boolean[n][n];
        for( int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=false;
            }
        }
        System.out.println(knights(board,0,0,n));
    }

    static int knights(boolean[][] board, int r, int c, int n) {
        if(n==0){
            display(board);
            System.out.println();
            return 1;
        }
        if(r== board.length){
            return 0;
        }
        int count=0;
        if(c== board[0].length){
            return knights(board,r+1,0,n);

        }
        if(canPlace(c,r,board)){
            board[r][c]=true;
            count+=knights(board,r,c+1,n-1);
            board[r][c]=false;
        }
        count+=knights(board,r,c+1,n);
        return count;
    }
    private static boolean canPlace(int c, int r, boolean[][]board) {
        if(c>=1&&r>=2){
            if(board[r-2][c-1]){
                return false;
            }
        }
        if(r>=2&&c+1< board.length){
            if(board[r-2][c+1]){
                return false;
            }
        }
        if(c>=2&&r>=1){
            if(board[r-1][c-2]){
                return false;
            }
        }
        if(r>=1&&c+2< board.length){
            if(board[r-1][c+2]){
                return false;
            }
        }
        return true;
    }
    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean q : row) {
                if (q) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }

            }
            System.out.println();
        }
    }
}
