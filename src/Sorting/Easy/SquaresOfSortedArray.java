package Sorting.Easy;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j= nums.length-1;
        int k= nums.length-1;
        int[] res=new int[nums.length];
        while(j>=i){
            if(nums[j]*nums[j]>nums[i]*nums[i]){
                res[k]=nums[j]*nums[j];
                j--;
            }
            else{
                res[k]=nums[i]*nums[i];
                i++;
            }
            k--;
        }
        return res;
    }
}
