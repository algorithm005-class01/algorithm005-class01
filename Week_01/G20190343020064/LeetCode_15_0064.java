package G20190343020064;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 三数之和
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-21 4:41 下午
 */
public class LeetCode_15_0064 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        if (nums.length > 0 && nums[0] > 0) {
            return result;
        }
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int k = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (k < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    if (nums[k] == nums[k+1]) {k++;}
                    if (nums[j] == nums[j-1]) {j--;}
                    k++;
                    j--;
                }
                if (sum < 0) {
                    k++;
                }
                if (sum > 0) {
                    j--;
                }
            }
        }
        return result;
    }

}
