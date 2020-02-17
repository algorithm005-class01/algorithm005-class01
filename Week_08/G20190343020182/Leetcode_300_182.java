package week008;

import org.junit.Test;

/*
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

	@Test
	public void test() {
		int[] nums1 = {10,9};
		System.out.println(lengthOfLIS(nums1));
		int[] nums2 = {10,9,2,5,3,4};
		System.out.println(lengthOfLIS(nums2));
		int[] nums3 = {10,9,8,11,12};
		System.out.println(lengthOfLIS(nums3));
		int[] nums4 = {10};
		System.out.println(lengthOfLIS(nums4));
		int[] nums5 = {10,9,2,5,6,3,4,5,6,11,12,13};
		System.out.println(lengthOfLIS(nums5));
		
		int[] nums6 = {2,2};
		System.out.println(lengthOfLIS(nums6));
		
		int[] nums7 = {1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLIS(nums7));
	}
}
