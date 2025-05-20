package binarySearch;

public class CeilingNum {
    public static void main(String[] args) {
        System.out.println(ceil(
                new int[]{1,2,3,5,6,7},4
        ));
    }
    static int ceil(int [] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
               return mid;
            }
            if(arr[mid]<target){
                start=mid+1;
            }
            if(arr[mid]>target){
                end=mid-1;
            }
        }
        return start;
    }
}
