package Recursion.array;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {4,5,3,2,9,6},0,5)));
    }
    //    [4,5,3,2,9,6]
    public static int[] sort(int[] arr, int i,int j){
        if(j==0){
            return arr;
        }
        if(arr[i]>arr[j]){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        if(i<j){
            return sort(arr,i+1,j);
        }else{
            return sort(arr,0,j-1);
        }
    }
}
