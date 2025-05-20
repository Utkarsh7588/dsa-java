package binarySearch.medium;

public class SingleElement {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{ 1}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if(nums.length==1){
            return nums[0];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid != nums.length - 1 && mid!=0) {
                if (mid % 2 == 0) {
                    if (nums[mid + 1] != nums[mid] && nums[mid - 1] != nums[mid]) {
                        return nums[mid];
                    }
                    if (nums[mid - 1] == nums[mid]) {
                        end = mid - 2;
                    }
                    if (nums[mid + 1] == nums[mid]) {
                        start = mid + 2;
                    }
                } else {
                    if (nums[mid + 1] == nums[mid]) {
                        end = mid - 1;
                    }
                    if (nums[mid - 1] == nums[mid]) {
                        start = mid + 1;
                    }
                }
            }
            else if(mid== nums.length-1){
                if(nums[mid]==nums[mid-1]){
                    end=mid-2;
                }
                else{
                    return nums[mid];
                }
            } else if (mid==0) {
                if(nums[mid]==nums[mid+1]){
                    end=mid-1;
                }
                else{
                    return nums[mid];
                }
            }

        }
        return nums[start];
    }
}
