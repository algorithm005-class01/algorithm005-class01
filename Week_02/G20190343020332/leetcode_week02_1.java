class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int minisNum;
        for(int i=0;i<nums.length;i++)
        {
            minisNum = target - nums[i];
            if (map.containsKey(minisNum))
            {
                return new int[]{map.get(minisNum),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}