package StackAndQue.easy;

import java.util.*;

public class ReverseFirstK {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(7);
        q.add(7);
        q.add(5);
        q.add(6);
        q.add(5);
        q.add(10);
        System.out.println(reverseFirstK(q,8));
    }
    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if(q.isEmpty()||q==null||k>q.size()){
            return q;
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<k;i++){
            stack.push(q.remove());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        int n=q.size();
        for(int i=0;i<n-k;i++){
            q.add(q.remove());
        }
        return q;
    }
}
