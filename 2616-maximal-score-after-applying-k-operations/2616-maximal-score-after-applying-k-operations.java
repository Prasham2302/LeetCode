class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        long score = 0;
        while (k > 0) {
            int curr = pq.poll();
            score += curr;
            pq.add((curr+2) / 3);
            k--;
        }
        return score;
    }
}