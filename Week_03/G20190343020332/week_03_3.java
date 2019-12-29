class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x/2+1;
        while(left<right){
            long mid = (left+right+1)>>>1;
            if(mid*mid>x)
                right = mid-1;
            else
                left = mid;
        }
        return (int)left;
    }
}
