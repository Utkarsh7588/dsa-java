package StackAndQue;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char [] arr=s.toCharArray();
        for(char ch:arr){
            if(ch=='}'||ch==')'||ch==']'){
                if(stack.isEmpty()){
                    return false;
                }
                char peak=stack.peek();
                if((peak=='{'&&ch=='}')||(peak=='('&&ch==')')||(peak=='['&&ch==']')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                stack.push(ch);
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
