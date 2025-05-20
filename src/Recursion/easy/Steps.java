package Recursion.easy;

public class Steps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }
    public static int numberOfSteps(int num) {
        return numberOfSteps(num,0);
    }

    public static int numberOfSteps(int num,int steps){
        if(num==0){
            return steps;
        }
        if((num%2==0&&num/2==0)||(num%2!=0&&num-1==0)){
            return steps+1;
        }

        return numberOfSteps(num%2==0?num/2:num-1,steps+1);
    }


}
