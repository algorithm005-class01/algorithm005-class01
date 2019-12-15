package ThreeSum;

/**
 * https://leetcode.com/problems/3sum
 * https://leetcode-cn.com/problems/3sum
 *
 * @author yx101 (David Qu)
 *
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;

class Solution {

    // 时间复杂度：O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // 忽略相同结果
                    while (j < k && nums[k] == nums[k + 1]) k--;  // 忽略相同结果
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    // 时间复杂度：O(n^2)
    public List<List<Integer>> threeSum3(int[] num) {
        Arrays.sort(num);
        LinkedList<List<Integer>> ret = new LinkedList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                if (num[i] + num[start] + num[end] == 0) {
                    LinkedList<Integer> oneResult = new LinkedList<>();
                    oneResult.add(num[i]);
                    oneResult.add(num[start]);
                    oneResult.add(num[end]);
                    set.add(oneResult);
                    start++;
                    end--;
                } else {
                    if (num[i] + num[start] + num[end] < 0)
                        start++;
                    else
                        end--;
                }
            }
        }
        ret.addAll(set);
        return ret;
    }

    // 暴力求解 时间复杂度：O( n^3 ) 超时
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++) {
                for (int k=j+1;k<nums.length;k++) {
                    if (nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> list1 = Arrays.asList(nums[i], nums[k], nums[j]);
                        if (list.indexOf(list1) == -1) {
                            list.add(list1);
                        }
                    }
                }
            }
        }
        return list;
    }
}
