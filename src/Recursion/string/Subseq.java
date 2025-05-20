package Recursion.string;

import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
//        findSubsets("","abc");
        System.out.println(findSubsets1("","abc"));
    }
    public static void findSubsets(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch=unprocessed.charAt(0);
        findSubsets(processed,unprocessed.substring(1));
        findSubsets(processed+ch,unprocessed.substring(1));
    }
    public static ArrayList<String> findSubsets1(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(processed.trim());
            return list;
        }
        char ch=unprocessed.charAt(0);
        ArrayList<String> list1=findSubsets1(processed,unprocessed.substring(1));
        ArrayList<String> list2=findSubsets1(processed+ch,unprocessed.substring(1));
        list1.addAll(list2);
        return list1;
    }
}
