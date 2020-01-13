package week_05.commit;

// 647. 回文子串
// https://leetcode-cn.com/problems/palindromic-substrings/
public class Solution_647_01 {

    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int b[][] = new int[c.length][c.length];
        for (int i = 0; i < c.length; i++) {
            b[i][i] = 1;

        }
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                b[i][i + 1] = 1;
            } else {
                b[i][i + 1] = 0;
            }
        }

        int l = 2;
        while (l < c.length) {
            for (int i = 0; i < c.length - l; i++) {
                int j = i + l;
                if (c[i] == c[j] && b[i + 1][j - 1] == 1) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = 0;
                }
            }
            l++;
        }
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (b[i][j] == 1) {
                    count++;

                }
            }
        }
        return count;
    }
}
