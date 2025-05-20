package Recursion;

public class PrintNumbers {
    public static void main(String[] args) {
//        printNum(10);
        printreverse(10);
    }

    public static void printNum(int n) {
        if (n > 1) {
            printNum(n - 1);
        }
        System.out.println(n);

    }

    public static void printreverse(int n) {
        System.out.println(n);
        if (n > 1) {
            printreverse(n - 1);
        }
    }
}
