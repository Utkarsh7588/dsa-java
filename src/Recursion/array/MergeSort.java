package Recursion.array;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{4, 5, 3, 2, 9, 6})));
    }

    public static int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] result = new int[len1 + len2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                k++;
                i++;
            } else if (arr2[j] < arr1[i]) {
                result[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < len1) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < len2) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }
}
