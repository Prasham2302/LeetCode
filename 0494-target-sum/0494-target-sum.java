class Solution {
    HashMap<Pair, Integer> cache;
    public int findTargetSumWays(int[] nums, int target) {
        cache = new HashMap<>();
        return helper(nums, 0, 0, target);
    }
    public int helper(int[] nums, int index, int currSum, int target) {
        if (index == nums.length) {
            if (currSum == target) {
                return 1;
            }
            return 0;
        }
        Pair cacheKey = new Pair(index, currSum);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        int count = helper(nums, index+1, currSum + nums[index], target) + helper(nums, index+1, currSum-nums[index], target);
        cache.put(cacheKey, count);
        return count;
    }
}
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())  return false;
        Pair cKey = (Pair) obj;
        return x == cKey.x && y == cKey.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}