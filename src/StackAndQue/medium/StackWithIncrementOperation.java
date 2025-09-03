package StackAndQue.medium;

import java.util.Stack;

public class StackWithIncrementOperation {
    public static void main(String[] args) {
        StackWithIncrementOperation obj = new StackWithIncrementOperation(3);
        obj.push(1);
        obj.push(2);
        obj.pop();
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.increment(5, 100);
        obj.increment(2, 100);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
    }

    int index = 0;
    int[] stack;

    public StackWithIncrementOperation(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (index < stack.length) {
            stack[index] = x;
            index++;
        }
    }

    public int pop() {
        if (index != 0) {
            index--;
            return stack[index];
        }
        return -1;
    }


    public void increment(int k, int val) {
        for (int i = 0; i < k && i < stack.length; i++) {
            stack[i] += val;
        }
    }
}
