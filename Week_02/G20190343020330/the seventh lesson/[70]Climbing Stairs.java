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



//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int climbStairs(int n) {
//        if (n <= 2) return n;
//        int a = 1, b = 2, c = 0;
//        while (n > 2) {
//            c = a + b;
//            a = b;
//            b = c;
//            n--;
//        }
//        return n;
//    }
//}

class Solution {
    public int climbStairs(int n) {
        int[] mark = new int[n + 1];
        return climb_Stairs(mark, n);
    }
    public int climb_Stairs(int[] mark, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (mark[n] > 0) {
            return mark[n];
        }
        mark[n] = climb_Stairs(mark, n - 1) + climb_Stairs(mark, n - 2);
        return mark[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)