package StringsAndStringBuilder.easy;

public class ToLowerCase {
    public String toLowerCase(String s) {
        char[] schar = s.toCharArray(); // Convert input string to character array

        for (int i = 0; i < schar.length; i++) {
            if (schar[i] >= 'A' && schar[i] <= 'Z') { // Check if uppercase
                schar[i] = (char) (schar[i] + 32); // Convert to lowercase
            }
        }
        return new String(schar);
    }
}
