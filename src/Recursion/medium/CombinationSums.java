package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSums {
    public static void main(String[] args) {


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
            helper(candidates,target,ans,new ArrayList<>(),0);
            return ans;
    }
    //[2,3,6,7]
    static void helper(int[] candidates, int target, List<List<Integer>> ans,List<Integer> list,int index){
            if(target==0){
               List<Integer>  l1=new ArrayList<>();
                for(int n:list){
                    l1.add(n);
                }
                ans.add(l1);
                return;
            }
        for(int i=index;i< candidates.length;i++){
            int num=candidates[i];
            if(target-num>=0){
                list.add(num);
                helper(candidates,target-num,ans,list,i);
                list.remove(list.size()-1);
            }

        }
    }
}
