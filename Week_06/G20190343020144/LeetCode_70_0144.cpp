/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

解法一: 递归暴力法 超时 O(2^n)/O(n)
解法二: 递归加备忘录 优化 O(n)/O(n)
解法三: 动态规划 O(n)/O(n)
解法四: 斐波那契数 (仅记录相关两级台阶的次数) O(n)/O(1)
解法五: Binets 方法: 线代向量处理  O(logn)/O(1)
解法六: 斐波那契公式法  O(logn)/O(1)


 * 
 * climbStairs
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    /**
     * 
     * 解题思路
     * 1. 多看题 
     * 2. 用例 查看规律
     * 3. 要明白程序员写的代码是给机器执行的, 而机器逻辑能力不强, 基本只能执行 if-else ,for-loop, recursive 等操作
     * 所以你只要把边界条件和小问题弄明白, 后面的就会自然很多. 
     * 
     * 明天数学归纳法, 小问题 => 推荐大问题的思想
     * 
     * 
     * 类似这种多少可能的解法问题, 一般是动态的规划, 可以递归,改写 while 等
     * 明白动态迁移方程, 与基础条件
     * f(n) = f(n-1) + f(n-2);
    */
    int climbStairs(int n)
    {
        if (n <= 3)
        {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3, i = 3;
        // 明确这里的循环次数, 可以尝试以 3 为 用例测试这里
        while (i <= n)
        {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            i++;
        }
        return f3;
    }
};

class Solution
{
    int climbStairs(int n)
    {
        int memo[n + 1];
        for (int i = 0; i < n + 1; i++)
        {
            memo[i] = 0;
        }
        return climb_Stairs(0, n, memo);
    }

    // 从 i 走到 n 的可能
    int climb_Stairs(int i, int n, int memo[])
    {
        if (i > n)
        {
            return 0;
        }
        if (i == n)
        {
            return 1;
        }
        if (memo[i] > 0)
        {
            return memo[i];
        }
        // 注意 后面是 i+1 , i + 2 ; 要理解 climb_Stairs(i,n,memo) 的含义
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}

class SolutionDP
{
public:
    int climbStairs(int n)
    {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};

int main()
{
    int ret = Solution().climbStairs(6);
    cout << "ret: " << ret << endl;
}