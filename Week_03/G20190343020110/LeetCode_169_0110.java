/**
 * @Author huangxiong
 * @Date 2019/12/26
 * @Description
 **/
public class LeetCode_169_0110 {

    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }

        }
        return -1;
    }
}
