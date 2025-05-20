package binarySearch;

import java.util.Arrays;

public class FirstAndLast {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(search(new int[]{5,7,7,7,7,8,8,10},7)));
    }
    public static int [] search(int[] arr,int target){

        return new int[] {start(arr,target),end(arr,target)};
    }
    public static int start(int[]arr,int target){
        boolean found=false;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                end=mid-1;
                found=true;
            }
            if(arr[mid]<target){
                start=mid+1;
            }
            if(arr[mid]>target){
                end=mid-1;
            }
        }
        return found? start:-1;
    }
    public static int end(int[]arr,int target){
        boolean found=false;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                start=mid+1;
                found=true;
            }
            if(arr[mid]<target){
                start=mid+1;
            }
            if(arr[mid]>target){
                end=mid-1;
            }
        }
        return found?end:-1;
    }

}
