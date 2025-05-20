package Recursion.string;

public class SkipString {
    public static void main(String[] args) {
        System.out.println(skip("abcsaabccaabc",0));
        skip("","abcsaabccaabc");
    }

    public static String skip(String str, int index){
        String s="";
        String s1=str.substring(index,index+3);
        if(index==str.length()-3){
            if(s1.equals("abc")){
                return "";
            }
            else{
                return str.substring(index,index+3);
            }
        }

        if(s1.equals("abc")){
            return s+skip(str,index+3);
        }
        return s+str.charAt(index)+skip(str,index+1);
    }

    public static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        if(up.startsWith("abc")){
            skip(p,up.substring(3));
        }
        else{
            skip(p+up.charAt(0),up.substring(1));

        }

    }
}
