package Sorting;

public class SelectionSort {
    //non stable algo
    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int maxIndex=0;
            for (int j=0;j<arr.length-i;j++){
                if(arr[maxIndex]<arr[j]){
                    maxIndex=j;
                }
            }
            int temp=arr[maxIndex];
            arr[maxIndex]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
    }
}
