package StackAndQue.easy;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        return removeOuterParentheses(s, stack, 0, 0);
    }

    public static String removeOuterParentheses(String s, Stack<Character> stack, int index, int startIndex) {
        if (stack.isEmpty() && index >= s.length()) {
            return "";
        }

        if (s.charAt(index) == '(') {
            stack.push('(');
        }
        if (s.charAt(index) == ')' && !stack.isEmpty()) {
            stack.pop();
        }
        if (stack.isEmpty() && index != 0) {
            return s.substring(startIndex + 1, index ) + removeOuterParentheses(s, stack, index + 1, index + 1);
        }
        return removeOuterParentheses(s, stack, index + 1, startIndex);
    }
}
