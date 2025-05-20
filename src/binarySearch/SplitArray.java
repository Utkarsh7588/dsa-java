package binarySearch;

import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        SplitArray solution = new SplitArray();

        // Test case 1
        int[] nums1 = {7, 2, 5, 10, 8};
        int k1 = 2;
        System.out.println("Test Case 1 Output: " + solution.splitArray(nums1, k1)); // Expected: 18

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("Test Case 2 Output: " + solution.splitArray(nums2, k2)); // Expected: 9

        // Test case 3
        int[] nums3 = {1, 4, 4};
        int k3 = 3;
        System.out.println("Test Case 3 Output: " + solution.splitArray(nums3, k3)); // Expected: 4
    }
    public int splitArray(int[] nums,int k){
        int count=1;
        int start=0;
        int end=0;
        for (int num : nums) {
            if (num > start) {
                start = num;
            }
            end += num;
        }
        while(start<end){
            count=1;
            int mid=start+(end-start)/2;
            int sum=0;
            for(int num:nums){
                sum+=num;
                if(sum>mid){
                    sum=num;
                    count++;
                }
            }
            if(count<=k){
                end=mid;
            }
            else {
                start=mid+1;
            }
        }
        return start;
    }
}
