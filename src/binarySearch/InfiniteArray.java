package binarySearch;

import java.util.Arrays;

public class InfiniteArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{2,3,5,6,7,8,10,11,12,15,20,23,30},15));
    }
    public static int search(int[]arr,int target){
        int range=1;
        int start=0;
        boolean found=false;
        while(!found){
            int end= Math.min(start + range, arr.length - 1);
            int result=binarySearch(arr,target,start,end);
            if(result!=-1){
                found=true;
                return result;
            }
            else{
                range=range*2;
                start=end+1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[]arr,int target, int start, int end){
        while (start<=end){
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
        return -1;
    }
}
