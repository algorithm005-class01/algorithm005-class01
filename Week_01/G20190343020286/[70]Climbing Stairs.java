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
class Solution {
    /**
     * 方法一：斐波那契数列，循环
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }



    /**
     * 方法二：动态规划
     * @param n
     * @return
     */
    /*public int climbStairs(int n) {
        int[] f = new int[n + 1];
        if(n == 1){//以防后面赋值f[2]=2时越界
            return 1;
        }
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i < f.length; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
