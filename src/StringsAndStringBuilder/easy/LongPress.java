package StringsAndStringBuilder.easy;

import java.util.HashMap;

public class LongPress {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("saeed","ssaaedd"));
    }
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;

        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++; // Move in name
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false; // Not a valid long press
            }
            j++; // Move in typed
        }

        return i == name.length();
    }
}
