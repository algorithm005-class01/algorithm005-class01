public class LeetCode_367_0190 {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2, right = num >> 1, temp, mid = left + right >> 1;
        while (left <= right) {
            temp = mid * mid;
            if (temp == num) return true;
            else if (temp > num) right = mid - 1;
            else left = mid + 1;
            mid = left + right >> 1;
        }
        return false;
    }
}
