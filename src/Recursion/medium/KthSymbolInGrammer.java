package Recursion.medium;

public class KthSymbolInGrammer {
    public static void main(String[] args) {
        System.out.println(kthGrammar(4, 1));
        System.out.println(kthGrammar(4, 2));
        System.out.println(kthGrammar(4, 3));
        System.out.println(kthGrammar(4, 4));
        System.out.println(kthGrammar(4, 5));
        System.out.println(kthGrammar(4, 6));
        System.out.println(kthGrammar(4, 7));
        System.out.println(kthGrammar(4, 8));
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int len = (int) Math.pow(2, n - 1);
        int mid = len / 2;
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        }
        return kthGrammar(n - 1, k - mid) == 0 ? 1 : 0;
    }

}
