package StringsAndStringBuilder.easy;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuilder builder=new StringBuilder();
        for(int j=0;j<arr.length;j++){
            StringBuilder builder1=new StringBuilder();
            for(int i=arr[j].length()-1;i>=0;i--){
                builder1.append(arr[j].charAt(i));
            }
            builder.append(builder1.toString());
            if(j < arr.length-1){
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
