//1. 两数之和
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //暴力法，枚举，O(n*n)
        // for (int i = 0; i<nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++ ) {
        //         if (nums[i] + nums[j] == target ) {
        //             return new int[]{i,j};
        //         }

        //     }

        // }  
        // return null;    


        //哈希表,在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}