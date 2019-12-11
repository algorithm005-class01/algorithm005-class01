//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.傻递归
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            if (n == 3) {
                return climbStairs(1) + climbStairs(2);
            }

            if (n == 4) {
                return climbStairs(1) + climbStairs(2) + climbStairs(3);
            }
            for (int i = 0; i < n; i++) {

            }

            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}