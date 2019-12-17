public class LeetCode_26_0192 {

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    // 解题思路：
    // 1. 利用快慢指针进行比较，初始差为1
    // 2. 2个指针对应的元素相同时，说明存在重复，慢指针当前位置之后的位置可以被覆盖掉
    // 3. 2个指针对应的元素不同时，将新元素填充到慢指针的数组（慢指针是连续递增的）
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1){
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
