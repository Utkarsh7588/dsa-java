package binarySearch.easy;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char []{'c','f','j'},'j'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        if(letters[end]<=target){
            return letters[0];
        }
        while(start<end){
            int mid=start+(end-start)/2;
            if(letters[mid]==target){
                if(letters[mid+1]==target){
                    mid=mid+1;
                }
            }
            if(letters[mid]>target){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return letters[end];
    }
}
