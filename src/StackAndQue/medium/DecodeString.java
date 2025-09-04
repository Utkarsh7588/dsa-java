package StackAndQue.medium;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();

        int currentNum = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(currentNum);
                stringStack.push(currentStr);

                currentNum = 0;
                currentStr = new StringBuilder();
            } else if (ch == ']') {
                int rep = numStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < rep; i++) {
                    decoded.append(currentStr);
                }
                currentStr = decoded;
            } else {
                currentStr.append(ch);
            }
        }

        return currentStr.toString();
    }
}
