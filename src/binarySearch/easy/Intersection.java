package binarySearch.easy;
import java.util.*;
public class Intersection {
    public static void main(String[] args) {
        int[] arr=intersection(new int[] {4,9,5}, new int []{9,4,9,8,4});

        System.out.println(Arrays.toString(arr));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result= new ArrayList<>();
        boolean firstbigger=false;
        int length=-1;
        if(nums1.length>nums2.length){
            firstbigger=true;
            length=nums2.length;
            Arrays.sort(nums1);
        }else {
            length= nums1.length;
            Arrays.sort(nums2);
        }
        for(int i=0;i<length;i++){
            if(firstbigger){
                int target=nums2[i];
                if(result.contains(target)){
                    continue;
                }
                boolean found=binarySearch(nums1,target);
                if(found){
                    result.add(target);
                }
            }
            else{
                int target=nums1[i];
                boolean found=binarySearch(nums2,target);
                if(found){
                    result.add(target);
                }
            }
        }
        Integer[] numArray = result.toArray(new Integer[0]);
        int[] primitiveArray = new int[numArray.length];
        for (int i = 0; i < numArray.length; i++) {
            primitiveArray[i] = numArray[i];
        }
        return primitiveArray;
    }
    private static boolean binarySearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }

    public  static int[] hashmapApproach(int[] nums1, int[] nums2){
        HashSet<Integer> set1=new HashSet<>();
        ArrayList<Integer> resultArr=new ArrayList<>();
        for (int num:nums1){
            set1.add(num);
        }
        for (int num:nums2){
            if(set1.contains(num)&& !resultArr.contains(num)){
                resultArr.add(num);
            }
        }
        return resultArr.stream().mapToInt(Integer::intValue).toArray();

    }
}
