package Sorting.Easy;

public class HeightChecker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
    }
    //other method is sort and compare complexity nlogn
    public static int heightChecker(int[] heights) {
        // Step 1: Find the maximum height for array size
        int maxHeight = 100; // Based on constraints (common in height problems)
        int[] count = new int[maxHeight + 1];

        // Step 2: Count frequency of each height
        for (int height : heights) {
            count[height]++;
        }

        // Step 3: Compare original heights with sorted order
        int index = 0, mismatchCount = 0;

        for (int i = 0; i <= maxHeight; i++) {
            while (count[i] > 0) {
                if (heights[index] != i) {
                    mismatchCount++;
                }
                index++;
                count[i]--;
            }
        }

        return mismatchCount;
    }
}
