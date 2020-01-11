package week_03.commit;

// 33. 搜索旋转排序数组
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
public class Solution_33 {

    public static int search(int A[], int target) {
        int n = A.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] > A[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        int rot = lo;
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % n;
            if (A[realmid] == target)
                return realmid;
            if (A[realmid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}
