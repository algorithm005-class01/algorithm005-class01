/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
		/**
         * 1.入参校验
         * 2.设定两根指针,由于已经是排好序的数组,那么相同的数一定相邻,p指针指向已经去重好的数组,而q指针去寻找需要
         * 前移的数
         * 3.如果p和q指向的数不相等,那么首先p指针向前移动,指向需要换位置的数,但是p向前移动后发现和q指向同一个数,
         * 那就没有必要换了,q指针会继续迁移寻找不同的数,如果两个数不相同且p,q指向不是同一个数,果断把q指针指向的
         * 数移动至p指针处.然后继续寻找.
         * 
         */
        if (nums == null || nums.length==0) {
            return 0;
        }
        int p = 0,q=1;
        while (q<nums.length) {
            if (nums[p] != nums[q]) {
                p++;
                if (p != q) {  
                    nums[p] = nums[q];
                }
            }
            q++;
        }
        return p+1;
    }
}
// @lc code=end

