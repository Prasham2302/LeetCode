
class Pair{
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class NeighborSum {
    int[][] grid;
    HashMap<Integer, Pair> location;
    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.location = new HashMap<>();
        for (int i = 0;i<grid.length;i++) {
            for (int j = 0;j<grid[0].length;j++) {
                this.location.put(grid[i][j], new Pair(i, j));
            }
        }
    }
    
    public int adjacentSum(int value) {
        Pair adr = this.location.get(value);
        return getValue(adr.x + 1, adr.y) + getValue(adr.x - 1, adr.y) + getValue(adr.x, adr.y + 1) + getValue(adr.x, adr.y - 1);

    }
    
    public int diagonalSum(int value) {
        Pair adr = this.location.get(value);
        return getValue(adr.x + 1, adr.y + 1) + getValue(adr.x - 1, adr.y - 1) + getValue(adr.x - 1, adr.y + 1) + getValue(adr.x + 1, adr.y - 1);
    }

    public int getValue(int x, int y) {
        if (x < 0 || y < 0 || x >= this.grid.length || y >= this.grid[0].length) {
            return 0;
        }
        return this.grid[x][y];
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */