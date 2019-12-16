//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

import java.util.*
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一：暴力枚举法
     * @param nums
     * @param target
     * @return
     */
    /*public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }*/

    /**
     * 方法二：借助哈希表记录
     * @param nums
     * @param target
     * @return
     */
    /*public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{i,map.get(temp)};
            }
        }
        return new int[]{-1,-1};
    }*/

    /**
     * 方法三：一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{i,map.get(temp)}
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

}
//leetcode submit region end(Prohibit modification and deletion)
