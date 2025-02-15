class Solution {
    public int findMaxFish(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0;i<grid.length;i++) {
            for (int j = 0;j<grid[0].length;j++) {
                if (grid[i][j] > 0) {
                    count = Math.max(dfs(grid, i, j, visited), count);
                }
            }
        }
        return count;
    }
    public int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        int[] dirs = new int[] {-1, 0, 1, 0, -1};
        int count = grid[row][col];
        visited[row][col] = true;
        for (int i =1;i<dirs.length;i++) {
            // System.out.println(dirs[i] + " "+dirs[i-1]);
            count += dfs(grid, row + dirs[i], col + dirs[i-1], visited);
        }
        // System.out.println(row +" "+ col + " "+count);
        return count;
    }
}