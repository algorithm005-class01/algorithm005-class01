import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // return hashMapMethod(nums);
        // return sortMethod(nums);
        // return voteMethod(nums);
        return binaryMethod(nums);

    }

    /**
     * 四.位运算法: 主题思想是将所有int类型的数字都当成二进制，统计用1作为掩码，依次与运算判断结果是否为1，统计在同一
     *          级上是1多还是0多，将多的那个拼接到结果上(因为众数既然超过1/2，那么同一级上一定是众数是大多数),由于int
     *          是32位的所以外层要判断32层
     * 复杂度分析：
     *      时间：O(32n)
     *      空间：O(1)
     * @param nums
     * @return
     */
    public int binaryMethod(int[] nums){
        int majority = 0;
        int n = nums.length;
        for (int i = 0,mask = 1; i < 32; i++, mask <<= 1) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) == mask) {
                    count++;
                }
                if (count > n/2) {
                    majority |= mask;
                }
            }
        }

        return majority;

    }


    /**
     * 三.投票法：申请一个计数器和候选者，当计数器为0的时候，下一个数字就是候选者，如果非零，下一个数是候选者就+1，否则-1
     *        思想就是将一个数组中的数，众数当成1，非众数当成-1，那么结果一定大于0.实则就是抵消
     *        抵消其实有两种，一种是众数非众数抵消，另一种则是两个非众数抵消，无论哪种情况，最后都会是众数剩下
     * 复杂度分析：
     *      时间：O(n)
     *      空间：O(1)
     *      
     * @param nums
     * @return
     */
    public int voteMethod(int[] nums){
        int count = 0;
        Integer candidate = null;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count += i == candidate?1:-1;
        }
        return candidate;
    }



    /**
     * 二.排序法: 先将数组排序，那么n/2这个位置(实际是第n/2 + 1这个数)一定是众数，所以返回即可
     * 复杂度分析：
     *      时间：O(nlogn)
     *      空间：O(1)
     * @param nums
     * @return
     */
    public int sortMethod(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    /**
     * 一.暴力法hash： 遍历数组，将元素存到map中，key为元素值，value为下表每次存的时候都判断是否大于n/2
     *      如果是，则返回该元素
     * 复杂度分析：
     *      时间：O(n)
     *      空间：O
     * @param nums
     * @return
     */
    public int hashMapMethod(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int half = nums.length/2;
        if (half == 0) {
            return nums[0];
        }
        if ( nums.length%2 != 0) {
            half++;
        }
        for (int i : nums) {
            if (map.containsKey(i)) {
               int count = map.get(i)+1;
               if (count>=half) {
                   return i;
               }else{
                   map.put(i, count);
               }
            }else{
                map.put(i, 1);
            }
        }
        return 0;
    }
}
// @lc code=end

