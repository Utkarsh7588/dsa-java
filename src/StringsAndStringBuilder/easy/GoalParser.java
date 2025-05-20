package StringsAndStringBuilder.easy;

public class GoalParser {
    public String interpret(String command) {
        String res=command.replace("()","a");
        String res1=res.replace("(al)","al");
        return res1;
    }
}
