package StringsAndStringBuilder.easy;

public class Decypher {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }
    //        a to i 1 to9
//    j to z 10# to 26#
    public static String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        int alphabateBase = (int) 'a' - 1;
        int i=0;
        while(i < s.length()) {
            int addToBase = 0;
            if (i+2<s.length()&&s.charAt(i + 2) == '#') {
                String s1 = s.substring(i, i + 2);
                addToBase = Integer.parseInt(s1);
                i+=3;
            } else {
                addToBase = Integer.parseInt(s.substring(i, i + 1));
                i+=1;
            }
            char ch = (char) (alphabateBase + addToBase);
            builder.append(ch);
        }
        return builder.toString();
    }

}
