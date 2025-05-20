package StringsAndStringBuilder.easy;

public class FirstOccurance {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
//        int j=0, i=0;
//        while (i<haystack.length()&&j<needle.length()){
//            char ch=haystack.charAt(i);
//            char ch1=needle.charAt(j);
//            if(ch==ch1){
//                j++;
//            }
//            else{
//                if(ch==needle.charAt(0)){
//                    j=1;
//                }
//                if(i!=0&&haystack.charAt(i-1)==needle.charAt(0)){
//                    j=1;
//                    i=i-1;
//                }
//                else{
//                    j=0;
//                }
//            }
//            i++;
//        }
//        if(j>needle.length()-1){
//            return i-j;
//        }
//        return -1;
    }
}
