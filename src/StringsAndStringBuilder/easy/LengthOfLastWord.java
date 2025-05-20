package StringsAndStringBuilder.easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }
    public static int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] != ' ') {
                len = j+1;
                break;
            }
        }

        for (int i = len-1; i >= 0; i--) {
            if (arr[i] == ' ') {
                return len - i-1;
            }
        }

        return len;
    }
}
