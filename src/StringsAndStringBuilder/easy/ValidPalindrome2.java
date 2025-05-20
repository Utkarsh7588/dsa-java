package StringsAndStringBuilder.easy;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }

    //    public static boolean validPalindrome(String s) {
//        char[] arr=s.toCharArray();
//        return check(arr,-1);
//    }
//
//    public static boolean check(char[]arr,int ignoreIndex){
//        int i=0;
//        int j=arr.length-1;
//        while(i<=j){
//            if(i==ignoreIndex){
//                i++;
//            }
//            if(j==ignoreIndex){
//                j--;
//            }
//            char ch=arr[i];
//            char ch1=arr[j];
//            if(ch!=ch1){
//                if(ignoreIndex==-1){
//                    if(check(arr,i)){
//                        return true;
//                    }
//                    else if(check(arr,j)){
//                        return true;
//                    }
//                    else{
//                        return false;
//                    }
//                }
//                else{
//                    return false;
//                }
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
    private static boolean isValid(String s, int left, int right, boolean canDelete) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (!canDelete) {
                    return false;
                }

                return isValid(s, left + 1, right, false) || isValid(s, left, right - 1, false);
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, true);
    }
}
