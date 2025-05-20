package binarySearch.easy;

public class CountNegativeInMatrix {
    public static int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int row = rows - 1;  // Start from the last row
        int col = 0;         // Start from the first column
        int count = 0;

        while (row >= 0 && col < cols) {
            if (grid[row][col] < 0) {
                count += (cols - col); // All elements in this row after 'col' are negative
                row--;  // Move up
            } else {
                col++;  // Move right
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println("Count of negative numbers: " + countNegatives(grid));
    }
}
