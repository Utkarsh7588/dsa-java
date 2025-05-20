package binarySearch.easy;

public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot obj=new SquareRoot();
        System.out.println(obj.mySqrt(5));
    }
    public int mySqrt(int x){
        int start=0;
        int end=x;
        while(start<=end && x!=0 && x!=1){
            int mid=(start+end)/2;
            if(mid==x/mid){
                return mid;
            }
            if(mid> (x/mid)){
                end=mid-1;
            }
            if(mid<(x/mid)){
                start=mid+1;
            }
        }
        return end;
    }
}