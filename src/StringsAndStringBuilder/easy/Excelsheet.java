package StringsAndStringBuilder.easy;

public class Excelsheet {
    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char ch = (char) ('A' + (columnNumber % 26));
            result.insert(0, ch);
            columnNumber /= 26;
        }

        return result.toString();
    }
}
