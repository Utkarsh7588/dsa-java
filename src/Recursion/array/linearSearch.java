package Recursion.array;

public class linearSearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 3)); // ➜ 2
        System.out.println(search(new int[]{10, 20, 30, 40}, 10)); // ➜ 0
        System.out.println(search(new int[]{10, 20, 30, 40}, 40)); // ➜ 3
        System.out.println(search(new int[]{1, 2, 3, 4}, 5)); // ➜ -1 (Not found)
        System.out.println(search(new int[]{7}, 7)); // ➜ 0 (Single element match)
        System.out.println(search(new int[]{7}, 10)); // ➜ -1 (Single element not match)
        System.out.println(search(new int[]{5, 5, 5, 5}, 5)); // ➜ 0 (First occurrence)
        System.out.println(search(new int[]{}, 5)); // ➜ ArrayIndexOutOfBoundsException
    }

    public static int search(int[] arr, int target){
        if(arr.length<1){
            return -1;
        }
        return search(arr,target,0);
    }
    public static int search(int[]arr,int target,int index){
        if(index==arr.length-1&&arr[index]!=target){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return search(arr, target,index+1);
    }
}
