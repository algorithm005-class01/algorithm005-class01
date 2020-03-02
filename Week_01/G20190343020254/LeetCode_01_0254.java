class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++){
            int otherNum = target - nums[index];
            if (map.containsKey(otherNum) && index != map.get(otherNum)) {
                int newIndex = map.get(otherNum);
                return new int[]{index, newIndex};
            }
            map.put(nums[index], index);
        }

        return new int[]{};
    }
}