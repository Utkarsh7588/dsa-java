package binarySearch.easy;

public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }
    public static int arrangeCoins(int n) {
        int start=0;
        int end=n;
        while(start<=end){
            int mid=start+ (end-start)/2;
            long sum=(long)(mid)*(mid+1)/2;// for integer overflow
            if(sum<n){
                start=mid+1;
            }
            if(sum==n){
                return mid;
            }
            if(sum>n){
                end=mid-1;
            }
        }
        return end;
    }
}
