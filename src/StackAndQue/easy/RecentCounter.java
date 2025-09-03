package StackAndQue.easy;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    public static void main(String[] args) {
        RecentCounter rc=new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
    Queue<Integer> queue;
    public RecentCounter() {
        queue=new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        if(t-3000<=0){
            return queue.size();
        }
        else{
            while(queue.peek()<t-3000){
                queue.remove();
            }
            return queue.size();
        }

    }
}
