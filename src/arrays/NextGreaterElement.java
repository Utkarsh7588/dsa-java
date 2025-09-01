package arrays;

import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1a = {4, 1, 2};
        int[] nums2a = {1, 3, 4, 2};
        System.out.println("Test 1: " + Arrays.toString(nextGreaterElement(nums1a, nums2a)));
        // Expected: [-1, 3, -1]

        // Test case 2
        int[] nums1b = {2, 4};
        int[] nums2b = {1, 2, 3, 4};
        System.out.println("Test 2: " + Arrays.toString(nextGreaterElement(nums1b, nums2b)));
        // Expected: [3, -1]

        // Test case 3
        int[] nums1c = {1, 3, 5};
        int[] nums2c = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + Arrays.toString(nextGreaterElement(nums1c, nums2c)));
        // Expected: [2, 4, -1]

        // Test case 4 (edge case: single element)
        int[] nums1d = {1};
        int[] nums2d = {1};
        System.out.println("Test 4: " + Arrays.toString(nextGreaterElement(nums1d, nums2d)));
        // Expected: [-1]

        // Test case 5 (all decreasing order)
        int[] nums1e = {5, 3};
        int[] nums2e = {6, 5, 4, 3, 2};
        System.out.println("Test 5: " + Arrays.toString(nextGreaterElement(nums1e, nums2e)));
        // Expected: [-1, -1]
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        for(int k=0;k<nums1.length;k++){
            int num=nums1[k];
            int index=Integer.MAX_VALUE;
            for( int i=0; i<nums2.length;i++){
                if(num==nums2[i]){
                    index=i;
                }
            }
            result[k]=-1;
            for(int j=index+1;j<nums2.length;j++){
                if(nums2[j]>num){
                    result[k]=nums2[j];
                    break;
                }
            }

        }
        return result;
    }
}
