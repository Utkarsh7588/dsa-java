package StackAndQue.medium;


import java.util.Arrays;
import java.util.List;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(4, 2, 4, 6, 1);
        List<Integer> b = Arrays.asList(2, 1, 8, 5);
        int maxSum = 10;

        int result = twoStacks(maxSum, a, b);
        System.out.println("Maximum elements picked = " + result);
    }
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        return twoStacks(maxSum,a,b,0,0,0,0);
    }
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int indexA, int indexB, int count, int sum) {
        if(sum==maxSum){
            return count;
        }
        if(sum>maxSum){
            return count-1;
        }
        if(indexA==a.size()&&indexB==b.size()){
            return count-1;
        }
        int score=Math.max(twoStacks(maxSum,a,b,indexA+1, indexB,count+1,sum+a.get(indexA)),twoStacks(maxSum,a,b,indexA,indexB+1,count+1,sum+b.get(indexB)));
        return score;
    }
}
