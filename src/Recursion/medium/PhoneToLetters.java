package Recursion.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneToLetters {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    //    public static List<String> letterCombinations(String digits) {
//        if(digits.length()==0){
//            return new ArrayList<>();
//        }
//        Map<Character, String> phoneMap = new HashMap<>();
//        phoneMap.put('2', "abc");
//        phoneMap.put('3', "def");
//        phoneMap.put('4', "ghi");
//        phoneMap.put('5', "jkl");
//        phoneMap.put('6', "mno");
//        phoneMap.put('7', "pqrs");
//        phoneMap.put('8', "tuv");
//        phoneMap.put('9', "wxyz");
//        StringBuilder builder=new StringBuilder();
//        return letterCombinations(builder,digits,phoneMap);
//    }
//    private static List<String> letterCombinations(StringBuilder p, String up, Map<Character,String> phoneMap){
//        if(up.isEmpty()){
//            List<String> list=new ArrayList<>();
//            list.add(p.toString());
//            return list;
//        }
//        String letters=phoneMap.get(up.charAt(0));
//        List<String> list1=new ArrayList<>();
//        for(int i=0;i<letters.length();i++){
//            StringBuilder s=new StringBuilder(p.toString()+letters.charAt(i));
//            List<String> l1=letterCombinations(s,up.substring(1),phoneMap);
//            list1.addAll(l1);
//        }
//        return list1;
//    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(result, new StringBuilder(), digits, 0, phoneMap);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, String digits, int index, Map<Character, String> phoneMap) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters=phoneMap.get(digits.charAt(index));
        for(char ch:letters.toCharArray()){
            current.append(ch);
            backtrack(result,current,digits,index+1,phoneMap);
            current=current.deleteCharAt(current.length()-1);
        }
    }
}
