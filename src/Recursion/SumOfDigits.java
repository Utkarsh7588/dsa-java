package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(123));
    }
    public static int sum(int n){
        if(n/10==0){
            return n;
        }
        return sum(n/10)+n%10;
    }
}
