package Sorting.Easy;

import java.awt.*;
import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int [] nums1= new int[] {1,2,3,0,0,0};
        int [] nums2=new int[] {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println("args = " + Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] result=new int[m+n];
        int i=0,j=0,k=0;
        while((i<m || j<n)&&k<m+n){
            if(i>m&&j<n){
                result[k]=nums2[j];
                j++;
            } else if (j>n&&i<m) {
                result[k]=nums1[i];
                i++;
            }else {
                if(nums1[i]<nums2[j]){
                    result[k]=nums1[i];
                }
                else{
                    result[k]=nums2[j];
                }
                i++;
                j++;
            }
            k++;
        }
        nums1=result;
        System.out.println(Arrays.toString(result));
    }
}
