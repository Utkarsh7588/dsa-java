package Recursion.string;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
//        findcoms("","abc");
        System.out.println(findcoms1("","abc"));
    }
    public static void findcoms(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        for(int i=0;i<=p.length();i++){
            String s=p.substring(0,i)+up.charAt(0)+p.substring(i);
            findcoms(s,up.substring(1));
        }
    }
    public static ArrayList<String> findcoms1(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> l= new ArrayList<>();
            l.add(p);
            return l;
        }
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String s=p.substring(0,i)+up.charAt(0)+p.substring(i);
            list.addAll(findcoms1(s,up.substring(1)));
        }
        return list;
    }
}
