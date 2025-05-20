package Sorting;

public class BubbleSort {
    //stable algo
public static void sort(int[]arr){
    boolean swapped=false;
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length-i;j++){
            if(arr[j]>arr[j+1]){
                swapped=true;
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        if(swapped)break;
    }
}
}
