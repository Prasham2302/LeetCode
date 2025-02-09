class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> val: map.entrySet()){
            maxHeap.add(val);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int i = k;
        int[] arr = new int[k];
        while(!maxHeap.isEmpty()){
            arr[--i] = maxHeap.poll().getKey();
        }
        return arr;
    }
}