package Recursion;

public class ReverseNum {
     static int sum=0;

    public static void main(String[] args) {
//        reverse(134);
//        System.out.println(sum);
        int digits=(int) Math.log10(1456)+1  ;
        System.out.println(method2(1456,digits));
    }
    public static void reverse(int n){
        sum=sum*10+n%10;
        if(n/10!=0){
            reverse(n/10);
        }
    }
    public static int method2(int n,int pow){
        if(n/10==0){
            return n;
        }
        return  n%10*(int)Math.pow(10,pow-1)+method2(n/10,pow-1) ;
    }
}
