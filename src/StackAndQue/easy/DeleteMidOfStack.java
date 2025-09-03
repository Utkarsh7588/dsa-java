package StackAndQue.easy;

import java.util.Stack;

public class DeleteMidOfStack {
    public void deleteMid(Stack<Integer> s) {
        int halfIndex=s.size()/2;
        deleteMid(s,0,halfIndex);
    }

    public void deleteMid(Stack<Integer> s, int index, int halfIndex) {
        if(index==halfIndex){
            s.pop();
            return;
        }
        int value=s.pop();
        deleteMid(s,index+1,halfIndex);
        s.push(value);
    }
}
