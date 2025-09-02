package StackAndQue.easy;

import java.util.Stack;

public class ImplementQueUsingStack {
    Stack<Integer> add;
    Stack<Integer> remove;
     public ImplementQueUsingStack() {
        this.add=new Stack<>();
        this.remove=new Stack<>();
    }

    public void push(int x) {
        this.add.push(x);
    }

    public int pop() {
        if(this.remove.isEmpty()){
            while(!this.add.isEmpty()){
                this.remove.push(this.add.pop());
            }
        }
        return this.remove.pop();
    }

    public int peek() {
        if(this.remove.isEmpty()){
            while(!this.add.isEmpty()){
                this.remove.push(this.add.pop());
            }
        }
        return this.remove.peek();
    }

    public boolean empty() {
        if(this.remove.isEmpty()&&this.add.isEmpty()){
            return true;
        }
        return false;
    }
}
