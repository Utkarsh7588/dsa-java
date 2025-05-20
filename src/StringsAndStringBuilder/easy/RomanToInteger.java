package StringsAndStringBuilder.easy;

import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
//        char[] arr = s.toCharArray();
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i != s.length() - 1) {
                int val2 = map.get(s.charAt(i+1));
                if (val2 > val) {
                    val = val2 - val;
                    i++;
                }
            }
            num += val;
        }
        return num;
    }
}
