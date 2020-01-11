//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 排序，中间元素就是多数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        return nums[mid];
    }

    /**
     * 暴力法：遍历数组，用循环记录每个元素出现个数，若大于n/2就返回该元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int ele: nums) {
                if(num == ele){
                    count++;
                }
            }
            if(count > nums.length/2){
                return num;
            }
        }
    }

    /**
     * 利用哈希表记录每个元素出现个数，用两个变量maxCount和maxNum记录
     * 最后最大的maxCount对应的maxNum就是多数元素，因为一定存在多数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxNum = nums[0];
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            int count = map.get(num);
            if(count > maxCount){
                maxCount = count;
                maxNum = num;
            }
        }
        return maxNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
