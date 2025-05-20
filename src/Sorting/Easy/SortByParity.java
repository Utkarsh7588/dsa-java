package Sorting.Easy;

import java.util.Arrays;

public class SortByParity {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(sortArrayByParity(new int[]{0, 2, 1})));
    }

    public static int[] sortArrayByParity(int[] nums) {
//        int i = 1;
//        int j = 0;
//        while (i < nums.length && j < nums.length) {
//
//            if (nums[i] % 2 == 0 && i!=j) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                j++;
//            } else {
//                i++;
//            }
//        }
//        return nums;
        int[] res = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                res[r] = nums[i];
                r--;
            } else {
                res[l] = nums[i];
                l++;
            }
        }

        return res;
    }
}
