package binarySearch.easy;

import java.util.Arrays;

public class SpecialArray {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{0,0}));
    }
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<= nums.length;i++){
            int indexFound=search(nums,i);
            int count=nums.length-indexFound;
            if(count==i){
                return i;
            }
        }
        return -1;
    }
    private static int search(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
if (nums[mid]<target) {
                start=mid+1;

            }else{
                end=mid-1;
            }
        }
        return start;
    }
}
