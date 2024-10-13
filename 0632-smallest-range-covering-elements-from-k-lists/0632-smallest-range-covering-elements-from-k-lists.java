class Entry {
    int val;
    int row;
    int col;
    Entry(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
    void print(){
        System.out.println(val +" "+row+" "+col);
    }
}
class EntryComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
        return e1.val - e2.val;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(new EntryComparator());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<nums.size();i++){
            pq.add(new Entry(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int finalMin = -1;
        int finalMax = -1;
        while (pq.size() == nums.size()) {
            Entry poppedElement = pq.poll();
            if (max - poppedElement.val < range){
                range = max - poppedElement.val;
                finalMin = poppedElement.val;
                finalMax = max;
            }
            // poppedElement.print();
            if (poppedElement.col + 1 < nums.get(poppedElement.row).size()) {
                Entry newElement = new Entry(nums.get(poppedElement.row).get(poppedElement.col+1), poppedElement.row, poppedElement.col+1);
                if (newElement.val > max){
                    max = newElement.val;
                }
                pq.add(newElement);
            }
        }
        return new int[] {finalMin, finalMax};
    }
}