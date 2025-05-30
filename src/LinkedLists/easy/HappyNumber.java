package LinkedLists.easy;

public class HappyNumber {
    //not exactly a linked list question but a question on cycle and fast and slow pointer
    public static void main(String[] args) {
        System.out.println(isHappy(1));
    }
    public static boolean isHappy(int n) {
        if (n == 1 || n == 7) {
            return true;
        }
        int slow = n;
        int fast = sumOfSquareOfDigits(n);
        while (slow != fast) {
            if (slow == 1 || fast == 1) {
                return true;
            }
            slow=sumOfSquareOfDigits(slow);
            fast=sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
        }
        return false;
    }

    public static int sumOfSquareOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum = sum + (rem * rem);
            num = num / 10;
        }
        return sum;
    }

}
