class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int lastPos = nums.length - 1;
        for ( int i = 0; i < lastPos && nums[i] != 0; ) {
            // 选出这一步跳到哪一个位置，下一步跳的最远
            int nnPos = 0;
            int nextPos = 0;
            for ( int j = 1; j <= nums[i]; j++) {
                int nextStep = i + j;
                if (nextStep >= lastPos) {
                    // 再跳一下就结束了
                    return ++step;
                }
                // 在下一步能跳的最远位置
                int maxPos = nextStep + nums[nextStep];
                if (maxPos >= nnPos) {
                    nnPos = maxPos;
                    nextPos = nextStep;
                }
            }
            step++;
            i = nextPos;
        }
        return step;
    }
}