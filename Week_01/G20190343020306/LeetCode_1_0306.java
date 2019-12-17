class Solution {
    public int[] twoSum(int[] nums, int target) {
        //做一个hash表
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //放进去之前检查是否存在解
            if (hashMap.containsKey(target - nums[i])) {
                //注意这里要反过来放, 因为找到的解肯定是先放入hash表的
                return new int[] { hashMap.get(target - nums[i]), i };
            }
            //hash表hash值为nums[i], 值为i
            hashMap.put(nums[i], i);
        }

        return null;
    }
}