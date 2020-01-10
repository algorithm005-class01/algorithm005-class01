package week_05.commit;

// 76. 最小覆盖子串
// https://leetcode-cn.com/problems/minimum-window-substring/
public class Solution_76_01 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        int[] s_dict = new int[256];
        int[] t_dict = new int[256];
        for (char c : t.toCharArray()) t_dict[c]++;

        int hi = nextPos(0, s, t_dict);
        if (hi == s.length()) return "";

        int lo = hi, sCount = 0;
        String res = "";
        while (lo <= hi && hi < s.length()) {
            if (s_dict[s.charAt(hi)]++ < t_dict[s.charAt(hi)]) sCount++;

            while (lo < s.length() && sCount == t.length()) {
                if (res.isEmpty() || hi - lo + 1 < res.length()) {
                    res = s.substring(lo, hi + 1);
                }
                if (s_dict[s.charAt(lo)]-- <= t_dict[s.charAt(lo)]) sCount--;
                lo = nextPos(lo + 1, s, t_dict);
            }
            hi = nextPos(hi + 1, s, t_dict);
        }
        return res;
    }

    private int nextPos(int start, String s, int[] t_dict) {
        while (start < s.length()) {
            char c = s.charAt(start);
            if (t_dict[c] != 0) return start;
            start++;
        }
        return start;
    }
}
