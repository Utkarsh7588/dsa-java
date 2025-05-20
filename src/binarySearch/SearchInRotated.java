package binarySearch;

public class SearchInRotated {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));
    }

    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int pivot=-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                pivot = mid + 1;
                break;
            } else if (arr[mid - 1] > arr[mid]) {
                pivot = mid;
                break;
            } else if (arr[mid] >= arr[start]) {//this will fail if array has duplicate elements so in cases where arr[mid]==arr[start]a==arr[end] move both pointers
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        int result = searchInAscending(arr, 0, pivot - 1, target);
        if (result != -1) return result;
        result = searchInAscending(arr, pivot, arr.length - 1, target);
        return result;
    }

    public static int searchInAscending(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }
    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
