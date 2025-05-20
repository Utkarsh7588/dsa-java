package binarySearch.easy;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
    public static boolean isPerfectSquare(int num) {
        int start=0;
        int end=num;
        while(end>=start){
            int mid=start+(end-start)/2;
            if(mid== num/(double)mid){
                return true;
            }
            if(mid>num/(double)mid){
                end=mid-1;
            }
            if(mid<num/(double)mid){
                start=mid+1;
            }
        }
        return false;
    }
}
