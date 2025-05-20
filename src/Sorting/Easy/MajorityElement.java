package Sorting.Easy;

public class MajorityElement {
    //solved by boyers-moores algo alternate approach is to sort and check or divide the array into 2 halves
    public int majorityElement(int[] nums) {
        int candidate=0;
        int count =0;
        for(int num:nums){
            if(count==0){
                candidate=num;
            }
            count+=num==candidate?1:-1;
        }
        return candidate;
    }
}
