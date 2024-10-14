class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add((double) num);
        }
        long score = 0;
        while (k > 0) {
            double curr = pq.poll();
            // System.out.println(curr);
            score += curr;
            pq.add(Math.ceil(curr / 3));
            k--;
        }
        return score;
    }
}