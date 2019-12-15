/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length;i++){
            if(tempMap.containsKey(target - nums[i])){
                return new int[]{i,tempMap.get(target - nums[i])};
            }else{
                tempMap.put(nums[i],i);
            }
        }
        return null;
    }
    
}
// @lc code=end

