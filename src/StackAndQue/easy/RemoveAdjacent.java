package StackAndQue.easy;

import java.util.Stack;

public class RemoveAdjacent {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            }
            else{
                if(stack.peek()==ch){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
        }
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
