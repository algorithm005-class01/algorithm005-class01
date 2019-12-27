package G20190343020220.leetcode_46_0220;

import java.util.ArrayList;
import java.util.List;
/*Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/

/**
 * @author Darcy
 * @date 2019-12-20 19:10
 */
public class Sulotion {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private void permuteHelper(List<List<Integer>> res, ArrayList<Integer> integers, int[] nums) {
        if (integers.size() == nums.length) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (integers.contains(nums[j])) {
                continue;
            }
            integers.add(nums[j]);
            permuteHelper(res, integers, nums);
            integers.remove(integers.size() - 1);

        }
    }
}
