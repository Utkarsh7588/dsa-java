package Sorting.Easy;

import java.util.HashSet;

public class ContainsDuplicate {
    //best time approach is to use hashset and serach time complexity O(n) space complexity O(n)
    //best space approach is sorting time complexity nO(log n) and space O(1)
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            else{
                set.add(num);
            }
        }
        return false;
    }
}
