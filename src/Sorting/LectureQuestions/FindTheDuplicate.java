package Sorting.LectureQuestions;

public class FindTheDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[]arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(i<=arr.length-1&&arr[correct]!=arr[i]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }

        for(int j=0;j< arr.length;j++){
            if(arr[j]!=j){
                return arr[j];
            }
        }
        return -1;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
