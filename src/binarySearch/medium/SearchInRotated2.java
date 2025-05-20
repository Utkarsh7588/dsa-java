package binarySearch.medium;

public class SearchInRotated2 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 5}, 7)); // -1
        System.out.println(search(new int[]{4, 5, 6, 7,7, 0, 1, 2}, 0)); // 4
        System.out.println(search(new int[]{3, 1}, 1)); // 1
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = findPivot(nums);

        // If no pivot is found, array is not rotated -> normal binary search
        if (pivot == -1) {
            return binarySearch(0, nums.length - 1, nums, target);
        }

        // If target is at pivot
        if (nums[pivot] == target) {
            return pivot;
        }

        // Search in the first sorted part
        if (target >= nums[0]) {
            return binarySearch(0, pivot - 1, nums, target);
        }

        // Search in the second sorted part
        return binarySearch(pivot + 1, nums.length - 1, nums, target);
    }

    public static int findPivot(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the pivot
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // Adjust search range
            if (nums[mid] == nums[start]&&nums[mid] == nums[end]) {
                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (start < end && nums[end] < nums[end - 1]) {
                    return end;
                }
                end--;
            }
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1; // No pivot means array is sorted
    }

    public static int binarySearch(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
