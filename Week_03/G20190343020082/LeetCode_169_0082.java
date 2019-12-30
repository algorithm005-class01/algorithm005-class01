public class LeetCode_169_0082 {
	public int majorityElement(int[] nums) {
		int c = nums[0];
		int count = 0;
		for (int i : nums) {
			if (i == c) {
				count ++;
			} else if (count > 0) {
				count --;
			} else {
				c = i;
				count ++;
			}
		}
		return c;
	}
}