class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        long score = 0;
        while (k > 0) {
            int curr = pq.poll();
            System.out.println(curr);
            score += curr;
            pq.add((int) Math.ceil((double) curr / 3));
            k--;
        }
        return score;
    }
}