package Sorting.Easy;

import java.util.Arrays;

public class SortByParity2 {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(sortArrayByParityII(new int[]{4,2,5,7})));
    }
    public static int[] sortArrayByParityII(int[] nums) {
//        int i=0;
//        int j=1;
//        int[] res=new int[nums.length];
//        for(int num:nums){
//            if(num%2==0){
//                res[i]=num;
//                i=i+2;
//            }
//            else{
//                res[j]=num;
//                j=j+2;
//            }
//        }
//        return res;
        

        int i=0;
        int j=1;
        int[] res=new int[nums.length];
        int k=0;
        int l= nums.length-1;
        while(k<l){
            if(nums[k]%2==0){
                res[i]=nums[k];
                i=i+2;
            }
            else{
                res[j]=nums[k];
                j=j+2;
            }
            if(nums[l]%2==0){
                res[i]=nums[l];
                i=i+2;
            }
            else{
                res[j]=nums[l];
                j=j+2;
            }
            k++;
            l--;
        }

        return res;
    }
}
