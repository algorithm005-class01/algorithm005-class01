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
     *
     * @param nums
     * @param stack
     */
    public void traversal(int[] nums, Stack<Integer> stack) {
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
            traversal(nums, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        traversal2(nums.length, 0, nums);
        return list;
    }

    public void traversal2(int n, int begin, int[] nums) {
        //===============================================================================
        //  全部排列完则添加到结果中
        //===============================================================================
        if (begin == n) {
            List<Integer> list = new ArrayList();
            for (int num : nums) {
                list.add(num);
            }
            this.list.add(list);
            return;
        }
        //===============================================================================
        //  递归所有可能的顺序变化
        //===============================================================================
        for (int i = begin; i < n; i++) {
            swap(nums, begin, i);
            traversal2(n, begin + 1, nums);
            // 每次排列完，将顺序还原，
            swap(nums, begin, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
