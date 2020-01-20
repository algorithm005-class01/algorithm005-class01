"""
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


"""


class Solution:
    def climbStairs(self, n: int) -> int:
        stack, x, count, kind, m = [], 0, 0, 1, n - 1
        # x为指针表示索引，count为弹出‘1’的数量，kind是不同爬楼梯方法的种数，m参考下述while循环代码来理解（为了阶乘）
        for i in range(n):
            stack.append(1)  # 生成具有n个1的列表
        while x < n // 2:  # 动态规划，思考n//2与len(stack)-1的区别
            if stack[x] == stack[x + 1] == 1:
                stack.pop()
                count += 1
                x += 1  # 若该索引处的元素与下一索引处元素同为1，则合成这两个1为2，指针右移一个单位。

                factorial = factorial_count = 1
                while m > n - 2 * count:  # 2*count注意一下！ 因为每次循环都要count的阶乘次
                    factorial *= m
                    m -= 1  # factorial表示阶乘（n-count）的一部分，取（n-2count-1）到（n-count）的部分。
                m += count - 1  # 对m进行校正，便于下一次循环while m > n-2*count的进行。
                for r in range(1, count + 1):
                    factorial_count *= r  # factorial_count表示阶乘count
                kind += factorial / factorial_count
                # 将每次合1为2后的各种1、2排序种类累加即可。factorial要除以count的阶乘是由于出现了阶乘count次重复情况，结合排列组合的组合问题来理解这一步。
        return int(kind)
