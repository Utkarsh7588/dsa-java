package Recursion.medium;

public class KthBit {
    public static void main(String[] args) {
        System.out.println(findKthBit(3,1));
    }
    public static  char findKthBit(int n, int k) {
        //most efficient way
//        if (n == 1)
//            return '0';
//
//        int len = (1 << n) - 1;
//        int mid = len / 2 + 1;
//
//        if (k < mid)
//            return findKthBit(n - 1, k);
//
//        if (mid == k)
//            return '1';
//
//        return findKthBit(n - 1, len - k + 1) == '0' ? '1' : '0';
        String s=findString(n).toString();
        return s.charAt(k-1);
    }

    public static StringBuilder findString(int n) {
        StringBuilder builder=new StringBuilder();
        if (n == 1) {
            return builder.append("0");
        }
        String s = findString(n - 1).toString();
//        return s + "1" + reverse(s);
        builder.append(s);
        builder.append("1");
        builder.append(reverse(s));
        return builder;
    }

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                builder.append('0');
            } else {
                builder.append('1');
            }
        }
        return builder.toString();
    }
}
