package Recursion.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetArr {
    public static void main(String[] args) {
        int [] arr={1,2,3};
        List<List<Integer>> ans=findSubset(arr);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> findSubset(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:arr){
            int n=outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }


}
