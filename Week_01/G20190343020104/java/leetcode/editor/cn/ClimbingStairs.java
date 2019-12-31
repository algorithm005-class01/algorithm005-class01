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

        System.out.println(solution.climbStairs(20));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.傻递归
         * 2.记忆递归
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            int[] ns = new int[n + 1];
            return climb_Stairs(0, n, ns);
        }

        /**
         * 递归
         *
         * @param i 起始台阶
         * @param n 台阶数
         * @param ns 保存中间结果的数组。
         * @return
         */
        public int climb_Stairs(int i, int n, int[] ns) {
            if (i > n) {
                return 0;
            }
            //i==n表示楼梯树和起始数一致。比如i=1,n=1时，就只有一种走法。
            if (i == n) {
                return 1;
            }
            if (ns[i] > 0) {
                //如果已经计算过了，就返回
                return ns[i];
            }
            //递归计算向上爬1阶和2阶需要的次数。
            ns[i] = climb_Stairs(i + 1, n, ns) + climb_Stairs(i + 2, n, ns);
            return ns[i];

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}