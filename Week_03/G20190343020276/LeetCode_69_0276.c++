class Solution {
public:
    int mySqrt(int x) {
        
        if(x == 0 || x == 1)
            return x;
        long left = 1;
        long right = x/2 + 1;
        while(left<right)
        {
            long mid = (left + right + 1) >> 2;

            if(mid*mid>x)
            {
                right = mid -1;
            }
            else
            {
                left = mid;
            }
        }

        return left;
    }
};
