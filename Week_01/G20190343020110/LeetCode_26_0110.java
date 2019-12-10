/**
 * @Author huangxiong
 * @Date 2019/11/11
 * @Description leetcode题目26
 **/
public class Code_26 {
    /**
     * 数组完成排序后，我们可以放置两个指针 ii 和 jj，其中 ii 是慢指针，
     * 而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj 以跳过重复项。
     * 当我们遇到 nums[j] \neq nums[i]nums[j]
     *  =nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]nums[j]）的值复制到
     *  nums[i + 1]nums[i+1]。然后递增 ii，接着我们将再次重复相同的过程，
     *  直到 jj 到达数组的末尾为止。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }
}
