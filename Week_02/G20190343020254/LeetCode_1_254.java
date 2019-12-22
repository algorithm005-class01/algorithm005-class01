

/**
 题目：两数之和
 链接：https://leetcode-cn.com/problems/two-sum/description/
 详情：
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */

/**
 * 解法1：
 * 暴力法
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


/*
其他方法，供后续学习使用

解法2： 两边hash

class Solution {
       public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组，将数组元素放到hash表中
        for(int t=0; t < nums.length; t++){
            map.put(nums[t], t);
        }
         for (int i = 0; i < nums.length; i++) {
             //找到目标数
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");   
    }
｝

解法3： 一遍hash
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
} 

另一个经典代码：  faster 98.94%  in 2ms
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.get(target - nums[i]) != null){
                int[] result = new int[2];
                result[0]=map.get(target - nums[i]);
                result[1]=i;
                return result;
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }
}



 */
