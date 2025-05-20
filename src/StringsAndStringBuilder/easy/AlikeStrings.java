package StringsAndStringBuilder.easy;

public class AlikeStrings {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("MerryChristmas"));
    }
    public static boolean halvesAreAlike(String s) {
        String s1=s.substring(0,s.length()/2);
        String s2=s.substring(s.length()/2,s.length());
        int count1=0;
        int count2=0;
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1=='A'||c1=='E'||c1=='I'||c1=='O'||c1=='U'||c1=='a'||c1=='e'||c1=='i'||c1=='o'||c1=='u'){
                count1++;
            }
            if(c2=='A'||c2=='E'||c2=='I'||c2=='O'||c2=='U'||c2=='a'||c2=='e'||c2=='i'||c2=='o'||c2=='u'){
                count2++;
            }
        }
        return count1==count2;
    }
}
