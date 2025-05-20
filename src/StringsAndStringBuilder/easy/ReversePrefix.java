package StringsAndStringBuilder.easy;

import java.util.Stack;

public class ReversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd",'d'));
    }
    public static String reversePrefix(String word, char ch) {
        char[] arr =word.toCharArray();
        int i=0;
        int j=0;
        for(int k=0;k<arr.length;k++){
            if(arr[k]==ch){
                j=k;
                break;
            }
        }
        while(i<=j){
            char temp= arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
