package StringsAndStringBuilder.easy;

public class SubStringOccurance {
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }
    public static int maxRepeating(String sequence, String word) {
        int count =0;
        StringBuilder s = new StringBuilder(word);
        while(sequence.contains(s)){
            count++;
            s.append(word);
        }
        return count;
    }
}
