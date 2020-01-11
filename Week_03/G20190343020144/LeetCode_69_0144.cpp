/**
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

/**
 * 1. 二分
 * 2. 牛顿迭代
*/

/**
 * 注意 
 * 1. long long 乘积超出范围
 * 2. x == 1 的边界值判断
 * 
*/
class Solution {
public:
    // 这种做法如果不注意就会溢出
    int mySqrtMy(long long x) {
        if (x == 1) return 1;
        long long temp = x / 2;
        while (temp * temp > x) {
            temp = (temp + x / temp) / 2;
        }
        return temp;
    }

    // 这种写法是错误的 , 看着效率高 但是结果是错误的, 而且 超时
    int mySqrtWrong(int x) {
        if (x == 0) return 0;
        int cur = 1, pre = 1;
        int deta = 0.0001;
        while (true) {
            pre = cur;
            cur = (cur + x / cur) / 2;
            if (fabs(cur - pre) < deta) {
                return cur;
            }
        }
        return cur;
    }


    /// 错误
    int mySqrt(int x){
        if (x == 0) return 0;
        int left = 0; 
        int right = x;
        while (left < right) {
            int middle = left + (right - left) / 2;
            long long ret = middle * middle;
            if (ret == x) {
                return middle;
            } else if (ret < x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    /** 正确的二分
     * 
     * corner case and boundary
     * 
     * https://leetcode.com/problems/sqrtx/discuss/25066/Solve-this-problem-with-Binary-Search
    */
    int mySqrt(int x) {
        if (x == 0) return 0;
        // 为什么起点是 1 
        int left = 1; 
        int right = x;
        int ans = right;
        // 截止条件
        while (left <= right) {
            int mid = left + (right - left)/2;
            // 边界条件
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 
     * 
    */
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
 