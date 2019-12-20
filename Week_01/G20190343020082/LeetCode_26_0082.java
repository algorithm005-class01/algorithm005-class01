class LeetCode_26_0082 {

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 0; j < nums.length; j ++) {
			if (nums[i] == nums[j]) {
				continue;
			}
			nums[++ i] = nums[j];
		}
		return ++ i;
	}

}