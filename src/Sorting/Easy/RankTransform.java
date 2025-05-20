package Sorting.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransform {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(arrayRankTransform(new int[] {37,12,28,9,100,56,80,5,12})));
    }
    public static int[] arrayRankTransform(int[] arr) {
//        int [] copy=new int [arr.length];
        int [] copy=arr.clone();
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(copy);
        int k=1;
        for(int i=0;i< arr.length;i++){
            if(map.containsKey(copy[i])){
                continue;
            }
            map.put(copy[i],k++);
        }
        int [] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int rank=map.get(arr[i]);
            res[i]=rank;
        }
        return res;
    }
}
