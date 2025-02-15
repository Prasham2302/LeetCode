class Block implements Comparable<Block>{
    int x;
    int y;
    int value;
    Block(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Block other) {
        return this.value - other.value;
    }

}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Block> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        for (int i = 0;i<heightMap.length;i++) {
            Block topBlock = new Block(i, 0, heightMap[i][0]);
            Block bottomBlock = new Block(i, heightMap[0].length-1, heightMap[i][heightMap[0].length-1]);
            queue.add(topBlock);
            queue.add(bottomBlock);
            visited[topBlock.x][topBlock.y] = true;
            visited[bottomBlock.x][bottomBlock.y] = true;
        }
        for (int i = 0;i<heightMap[0].length;i++) {
            Block topBlock = new Block(0, i, heightMap[0][i]);
            Block bottomBlock = new Block(heightMap.length-1, i, heightMap[heightMap.length-1][i]);
            queue.add(topBlock);
            queue.add(bottomBlock);
            visited[topBlock.x][topBlock.y] = true;
            visited[bottomBlock.x][bottomBlock.y] = true;
        }
        int[] dirs = new int[] {-1,0,1,0,-1};
        int count = 0;
        while (!queue.isEmpty()) {
            Block curr = queue.poll();
            for (int i = 1;i<dirs.length;i++) {
                int newx = curr.x + dirs[i-1];
                int newy = curr.y + dirs[i];
                if (newx >= heightMap.length || newy >= heightMap[0].length || newx < 0 || newy < 0 || visited[newx][newy]) {
                    continue;
                }
                visited[newx][newy] = true;
                if (curr.value > heightMap[newx][newy]) {
                    count += curr.value - heightMap[newx][newy];
                }
                queue.add(new Block(newx, newy, Math.max(curr.value, heightMap[newx][newy])));
            }
        }
        return count;
    }
}
