class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        int left = 1;
        int right = x;
        while (right - left > 1) {
            int mid = left + (right - left)/2;
            if (x / mid < mid) {
                right = mid ;
            } else {
                left = mid ;
            }
        }
        return left;
    }
}