package week_03.commit;

import java.util.Arrays;

// 455. 分发饼干
// https://leetcode-cn.com/problems/assign-cookies/description/
public class Solution_455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int pointG = 0;
        int pointS = 0;

        while (pointG < g.length && pointS < s.length) {
            if (g[pointG] <= s[pointS]) {
                pointG++;
                pointS++;
            } else {
                pointS++;
            }
        }

        return pointG;
    }
}
