package StackAndQue.medium;

import java.util.Stack;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }

//    public static int minAddToMakeValid(String s) {
//        Stack<Character> open = new Stack<>();
//        Stack<Character> close = new Stack<>();
//
//        for (char ch : s.toCharArray()) {
//
//            if (ch == ')' && open.isEmpty()) {
//                close.push(ch);
//            }
//            if (ch == ')' && !open.isEmpty()) {
//                open.pop();
//            }
//
//            if (ch == '(') {
//                open.push(ch);
//            }
//        }
//        return open.size() + close.size();
//    }

    // single stack solution
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();


        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }

        }
        return stack.size();
    }

}
