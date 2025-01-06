class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        int ops = 0;
        int count = 0;
        for(int i = 0;i<boxes.length();i++){
            res[i] += ops;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            ops += count;
        }
        System.out.println(Arrays.toString(res));
        ops = 0;
        count = 0;
        for(int i = boxes.length() - 1;i >= 0;i--){
            res[i] += ops;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            ops += count;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}