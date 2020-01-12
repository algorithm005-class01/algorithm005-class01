class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c- 'A']++;
        }

        int times = 0;
        Arrays.sort(map);
        while(map[25] > 0) {
            int i = 0;
            while (i <= n && map[25] > 0) {
                int pos = 25 - i;
                if (pos >= 0 && map[pos] > 0) map[pos]--;
                times++;
                i++;
            }
            Arrays.sort(map);
        }

        return times;
    }
}