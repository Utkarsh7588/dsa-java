package StringsAndStringBuilder.easy;

import java.util.HashSet;
import java.util.Set;

public class RobotMoves {
    public boolean judgeCircle(String moves) {
        char[] chs=moves.toCharArray();
        int [] pos={0,0};
        for(char ch:chs){
            if(ch=='U'){
                pos[1]+=1;
            }
            if(ch=='L'){
                pos[0]-=1;
            }
            if(ch=='D'){
                pos[1]-=1;
            }
            if(ch=='R'){
                pos[0]-=1;
            }
        }
        return pos[0]==0&&pos[1]==0;
    }
}
