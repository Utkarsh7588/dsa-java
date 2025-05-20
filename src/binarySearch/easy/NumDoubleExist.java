package binarySearch.easy;

import java.util.HashMap;
import java.util.HashSet;

public class NumDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2))) {
                return true; // Found the valid pair
            }
            set.add(num);
        }
        return false;
    }
}
