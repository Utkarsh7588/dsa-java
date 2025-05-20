package StringsAndStringBuilder.easy;

public class SentenceSorting {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
    public static String sortSentence(String s) {
        String [] arr=s.split(" ");
        String[] res=new String[arr.length];
        for(String str:arr){
            char ch=str.charAt(str.length()-1);
            res[Character.getNumericValue(ch)-1]=str.substring(0,str.length()-1);
        }
        StringBuilder builder=new StringBuilder();
        for(int i=0;i< res.length;i++){
            builder.append(res[i]);
            if(i!= res.length-1){
                builder.append((" "));
            }
        }
        return builder.toString();
    }
}
