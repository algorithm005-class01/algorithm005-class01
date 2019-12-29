class TwoSum {

    //1.哈希表
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[0];
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    result = new int[]{map.get(diff), i};
                    break;
                } else {
                    map.put(nums[i], i);
                }
            }
            return result;
        }
    }

}