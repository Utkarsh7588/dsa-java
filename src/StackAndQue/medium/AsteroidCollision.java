package StackAndQue.medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {-2,-2,1,-2};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (stack.peek() > 0 && i < 0) {
                    int sub = stack.peek() + i;
                    while (!stack.isEmpty() && sub < 0 && stack.peek() > 0) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            sub = stack.peek() + i;
                        }
                    }
                    if (sub == 0) {
                        stack.pop();
                    } else if (sub < 0) {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i--;
        }
        return result;
    }
}
