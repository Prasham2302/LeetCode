class Solution {
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] vals = new int[row][col];
        for (int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                // Using -1 as a marker
                // Will help in preventing re-iteration of same (row, col)
                vals[i][j] = -1;
            }
        }
        int max = 0;
        for (int i = 0;i<row;i++) {
            max = Math.max(backtrack(grid, vals, i, 0, Integer.MIN_VALUE), max);
        }
        // We measured number of possible paths
        // We would need 1 less move to travel the path
        return max != 0 ? max - 1 : max;
    }
    public int backtrack(int[][] grid, int[][] vals, int row, int col, int prevValue) {
        // Filtering condition
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return Integer.MIN_VALUE;
        // Already traversed (row, col)
        if (vals[row][col] != -1) 
            return vals[row][col];
        // Check if this (row, val) can be included in our path
        if (prevValue >= grid[row][col]) 
            return Integer.MIN_VALUE;
        // Current (row, val) included so we will have max as 1
        int max = 1;
        // Traverse the next possible paths and try and increase the max
        max = Math.max(max, backtrack(grid, vals, row, col + 1, grid[row][col]) + 1);
        max = Math.max(max, backtrack(grid, vals, row + 1, col + 1, grid[row][col]) + 1);
        max = Math.max(max, backtrack(grid, vals, row - 1, col + 1, grid[row][col]) + 1);
        // Fill in the value to save time
        vals[row][col] = max;
        return max;
    }
}