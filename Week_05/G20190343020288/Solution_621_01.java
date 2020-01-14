package week_05.commit;

import java.util.*;

// 621. 任务调度器
// https://leetcode-cn.com/problems/task-scheduler/
public class Solution_621_01 {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int maxCnt = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (char c : tasks) {
            int cnt = m.getOrDefault(c, 0);
            maxCnt = Math.max(maxCnt, ++cnt);
            m.put(c, cnt);
        }

        int dup = 0;

        for (char c : m.keySet()) {
            if (m.get(c) == maxCnt) dup++;
        }

        int minInterval = (maxCnt - 1) * (n + 1) + dup;
        return Math.max(tasks.length, minInterval);
    }
}
