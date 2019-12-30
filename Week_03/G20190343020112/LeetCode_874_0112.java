class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            long ox = (long)obstacle[0] + 30000;
            long oy = (long)obstacle[1] + 30000;
            obSet.add((ox << 16) + oy);
        }
        // up right down left
        int[] dx = {0, 1, 0, -1};
        int[] dy= {1, 0, -1, 0};

        int x = 0, y = 0, di = 0;
        int res = 0;
        for (int command : commands) {
            if (command == -2) {
                // left forward, right + 3
                di = (di + 3) % 4;
            } else if (command == -1) {
                // right forward, rigth + 1
                di = (di + 1) % 4;
            } else {
                // forward
                for (int i = 0; i < command; i++) {
                    int xtmp = x + dx[di];
                    int ytmp = y + dy[di];
                    long code = (((long)xtmp + 30000) << 16) + ((long)ytmp + 30000);
                    if (!obSet.contains(code)) {
                        x = xtmp;
                        y = ytmp;
                        res = Math.max(res, x*x + y*y);
                    }else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}