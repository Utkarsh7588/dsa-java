package Recursion;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZero(1000800000));
    }
    public static int countZero(int n){
        return countZero(n,0);
    }
    public static int countZero(int n, int count){
        if(n/10==0){
            return count;
        }
        return countZero(n/10,n%10==0?count+1:count);
    }
}
