package Recursion.string;

public class SkipChar {
    public static void main(String[] args) {
        System.out.println(skip("absaca",0));
//        skip("","absaca");
    }

    public static String skip(String str, int index){
        String s="";
        if(index==str.length()){
            return "";
        }
        if(str.charAt(index)=='a'){
            return s+skip(str,index+1);
        }
        return s+str.charAt(index)+skip(str,index+1);
    }

    public static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        if(up.charAt(0)=='a'){
            skip(p,up.substring(1));
        }
        else{
            skip(p+up.charAt(0),up.substring(1));

        }

    }
}
