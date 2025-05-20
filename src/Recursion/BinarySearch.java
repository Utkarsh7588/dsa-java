package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(bs(2,new int[]{-1,0,3,5,9,12},0,5));
    }
    public static int bs(int target,int[]arr, int start, int end){
        int mid=start+(end-start)/2;
        if(target==arr[mid]){
            return mid;
        }
        if(target>arr[mid]){
           return bs(target,arr,mid+1,end);
        }
        else{
            return bs(target,arr,start,mid-1);
        }
    }
}
