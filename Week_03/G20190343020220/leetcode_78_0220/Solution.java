package Week_03.G20190343020220.leetcode_78_0220;

import java.util.ArrayList;
import java.util.List;
/*给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

/**
 * @author Darcy
 * @date 2019-12-27 11:32
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetsHelper(ans, new ArrayList<>(), 0, nums);
        return ans;

    }

    private void subsetsHelper(List<List<Integer>> ans, ArrayList<Integer> integers, int level, int[] nums) {
        if (level == nums.length) {
            ans.add(integers);
            return;
        }
        /*不选择当前这层*/
        subsetsHelper(ans, integers, level + 1, nums);
        /*选择当前这层*/
        integers.add(nums[level]);
        subsetsHelper(ans, integers, level + 1, nums);
        /*没有得到解, 回溯*/
        integers.remove(integers.size() - 1);
    }
}
