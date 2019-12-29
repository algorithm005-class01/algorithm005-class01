class Solution {
    public int trap(int[] height) {
        /*
            0 1 0 2 1 0 1 3 2 1 2 1 
                          *
                  *       * *   *
              *   * *   * * * * * *
            0 1 2 3 4 5 6 7 9 0 1 11
            l                     r
            
            leftMax = 0
            rightMax = 0
            res = 0
        */
        int left = 0,
            right = height.length - 1,
            leftmax = 0,
            rightmax = 0,
            res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftmax = Math.max(height[left], leftmax);
                res += leftmax - height[left];
                ++ left;
            }
            else {
                rightmax = Math.max(height[right], rightmax);
                res += rightmax - height[right];
                -- right;
            }
        }
        return res;
    }
}
