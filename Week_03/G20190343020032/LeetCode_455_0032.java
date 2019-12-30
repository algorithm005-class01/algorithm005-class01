class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, count = 0;
        for (int i = 0; i < s.length && gi < g.length; i++) {
            if (s[i] >= g[gi]) {
                count++;
                gi++;
            }
        }
        return count;
    }
}