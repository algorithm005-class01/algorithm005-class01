//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        helper(res, list, nums, index + 1);
        list.add(nums[index]);
        helper(res, list, nums, index + 1);

        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
