package Sorting;

public class InsertionSort {
public static void sort(int[]arr){
    for(int i=0;i<arr.length-1;i++){
        for(int j=i+1;j>0;j--){
            if(arr[j]<arr[j-1]){
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
            }else{
                break;
            }
        }
    }
}
}
