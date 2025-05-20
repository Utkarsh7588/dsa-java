package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(printFibo(50));
    }
    public static int printFibo(int n){
        if(n==0||n==1){
            return n;
        }
            int num=  printFibo(n-1)+printFibo(n-2);
            return num;

    }
}
