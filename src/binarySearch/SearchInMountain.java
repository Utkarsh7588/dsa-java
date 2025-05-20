package binarySearch;

public class SearchInMountain {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,8,3,2,1},1));
    }

    public static int search(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int mid=start+(end-start)/2;

            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        int peak= start;
        int result=    searchInAscending(arr,0,peak,target);
    if(result!=-1)return result;
    result= searchInDescending(arr,peak,arr.length-1,target);
    return result;
    }
    public static int searchInAscending(int[] arr,int start,int end, int target){
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                start=mid+1;
            }
            if(arr[mid]>target){
                end=mid-1;
            }
        }
        return -1;
    }

    public static int searchInDescending(int[] arr,int start,int end,int target){
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                start=mid+1;
            }
            if(arr[mid]<target){
                end=mid-1;
            }
        }
        return -1;
    }
}
