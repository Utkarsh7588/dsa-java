package Recursion;

public class DiceRoll {
    public static void main(String[] args) {
        rolls("",4);
    }
    static void rolls(String p, int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=target;i++){
            rolls(p+i,target-i);
        }
        return;
    }
}
