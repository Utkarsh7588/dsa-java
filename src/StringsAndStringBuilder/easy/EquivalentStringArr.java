package StringsAndStringBuilder.easy;

public class EquivalentStringArr {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder=new StringBuilder();
        StringBuilder builder1=new StringBuilder();
        for(String s:word1){
            builder.append(s);
        }
        for(String s1:word2){
            builder1.append(s1);
        }
        return builder1.toString().equals(builder.toString());
    }
}
