package G20190343020064;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 全排列
 * </p>
 *
 * @author mingke.yan  2019-12-22 10:38 下午
 */
public class LeetCode_46_0064 {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        traversal(nums,new Stack<Integer>());
        return list;
    }

    /**
     * 暴力递归 出该数组所有数字可能的组合，然后排除已包含的数据
     *
     * 更优的方案是 再数组直接变换顺序 // TODO
     *
     * @param nums
     * @param stack
     */
    public void traversal(int[] nums,Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //===============================================================================
            // 假如包含了已经存在的数字则跳过这次循环
            //===============================================================================
            if (stack.contains(nums[i])) {
                continue;
            }
            stack.push(nums[i]);
            traversal(nums,stack);
            stack.pop();
        }
    }

}
