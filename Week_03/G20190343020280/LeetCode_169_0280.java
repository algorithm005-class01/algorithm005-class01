//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        /*int n = nums.length/2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key)>n) {
                return key;
            }
        }
        return -1;*/
        return majorityElementByVote(nums);
    }

    //不知道怎么有人知道这种方法
    private int majorityElementByVote (int[] nums) {
        int count = 0;
        int cadidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count==0) {
                cadidate = nums[i];
            }
            if (cadidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return count>0? cadidate : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
