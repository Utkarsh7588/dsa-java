package binarySearch.easy;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        System.out.println("args = " + Arrays.toString(twoSum(new int[]{3,24,50,79,88,150,345},200)));
    }
    public static int[] twoSum(int[] numbers, int target){
        //two pointer method is more efficient
        for(int i=0;i<numbers.length;i++){
            int num=numbers[i];
            int ans=binarySearch(numbers,target-num,i+1,numbers.length-1);
            if(ans !=-1){
                return new int[]{i,ans};
            }
        }
        return new int[]{-1,-1};
    }

    private static int binarySearch(int[] numbers, int target, int start, int end) {
        while(start<=end){
            int mid=start+(end-start)/2;
            if(numbers[mid]==target){
                return mid;
            }
            if(numbers[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }

}
