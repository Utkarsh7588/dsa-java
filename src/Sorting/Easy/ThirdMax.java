package Sorting.Easy;

public class ThirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{-2147483648, 1, 1}));
    }

    public static int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;

        for (int num : nums) {

            if (num > max1) {

                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2&&num < max1 ) {
                max3 = max2;
                max2 = num;

            } else if (num > max3&&num < max2  ) {
                max3 = num;

            }
        }
        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }
}
