package StringsAndStringBuilder.easy;

public class ValidPalindrom {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }
    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            char ch=Character.toLowerCase(s.charAt(i));
            char ch1=Character.toLowerCase(s.charAt(j));
            while(!Character.isLetterOrDigit(ch)){
                i++;
                if(i>=s.length()){
                    ch=' ';
                    break;
                }
                ch=Character.toLowerCase(s.charAt(i));
            }
            while(!Character.isLetterOrDigit(ch1)){
                j--;
                if(j<0){
                    ch1=' ';
                    break;
                }
                ch1=Character.toLowerCase(s.charAt(j));
            }
            if(ch!=ch1){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
