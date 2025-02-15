class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] graph = new int[n];
        for (int[] edge : edges) {
            graph[edge[1]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            if (graph[i] == 0) {
                ans.add(i);
            }
        }
        if (ans.size() == 1) {
            return ans.get(0);
        }
        return -1;
    }
}