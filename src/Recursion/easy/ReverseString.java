package Recursion.easy;

public class ReverseString {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
    private void helper(char[] s,int start,int end){
        if(start>end){
            return;
        }
        char ch=s[start];
        s[start]=s[end];
        s[end]=ch;
        helper(s,start+1,end-1);
    }
}
