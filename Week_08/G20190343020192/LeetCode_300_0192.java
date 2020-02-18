import java.util.Arrays;

public class LeetCode_300_0192 {
    // 300. 最长上升子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
    // 超哥讲解 https://time.geekbang.org/course/detail/130-69783
    // 优秀题解 https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-e/

    /**
     * 解题思路
     * 1. 对原序列进行遍历，将每位元素二分插入 dp 数组中
     * 2. 如果： cell 中元素都比它小，将它插到最后
     *    否则： 用它覆盖掉比它大的元素中最小的那个
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
