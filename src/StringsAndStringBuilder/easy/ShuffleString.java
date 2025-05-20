package StringsAndStringBuilder.easy;

public class ShuffleString {
    public String restoreString(String s, int[] indices) {
//        StringBuilder res = new StringBuilder(" ".repeat(indices.length));
//        for(int i=0;i<indices.length;i++){
//            res.setCharAt(indices[i], s.charAt(i));
//        }
//        return res.toString();
        int n=s.length();
        char ch[] = new char[n];
        int j=0;
        for(int i:indices){
            ch[i]=s.charAt(j);
            j++;
        }
        return new String(ch);
    }
}
