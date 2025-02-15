class Solution {
    public int findChampion(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[1]][edge[0]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            int count = 0;
            for (int j = 0;j<n;j++) {
                count += graph[i][j];
            }
            if (count == 0) {
                ans.add(i);
            }
        }
        if (ans.size() == 1) {
            return ans.get(0);
        }
        return -1;
    }
}