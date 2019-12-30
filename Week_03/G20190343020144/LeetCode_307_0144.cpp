/**

给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-perfect-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

这个题和 sqrt 一样的解法
 * 
*/

#include <iostream>

class Solution {
public:
    bool isPerfectSquare(int num) {
        int sqt = mySqrt(num);
        return sqt * sqt == num;
    }

    int mySqrt(int x) {
        int l=0,r=x;
        while (l<r) {
            // 边界 , 注意 (r-l + 1) 可能越界
            int m = l + (r - l)/2 + 1;
            if (m>x/m) r=m-1;
            else l=m; // 左边界
        }
        return r;
    }
};

