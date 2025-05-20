package Recursion.array;

public class CheckIfSorted {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}; // Sorted
        int[] arr2 = {5, 4, 3, 2, 1}; // Not Sorted
        int[] arr3 = {1, 1, 2, 3, 3, 4}; // Sorted with duplicates
        int[] arr4 = {1, 3, 2, 4, 5}; // Not Sorted (out of order)
        int[] arr5 = {10}; // Single element (always sorted)
        int[] arr6 = {}; // Empty array (considered sorted)

        System.out.println(check(arr1)); // true
        System.out.println(check(arr2)); // false
        System.out.println(check(arr3)); // true
        System.out.println(check(arr4)); // false
        System.out.println(check(arr5)); // true
        System.out.println(check(arr6)); // true
    }
    public static boolean check(int[]arr){
        if(arr.length<1){
            return true;
        }
        return check(arr,0);
    }
    public static boolean check(int[] arr,int index){
        if(index== arr.length-1){
            return true;
        }
        if(arr[index]<=arr[index+1]){
            return check(arr,index+1);
        }else {
            return false;
        }

    }
}
