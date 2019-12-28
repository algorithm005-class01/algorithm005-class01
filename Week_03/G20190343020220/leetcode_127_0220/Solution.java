package Week_03.G20190343020220.leetcode_127_0220;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Darcy
 * @date 2019-12-28 10:50
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        //hashset的好处：去重也完成了
        //开始端
        Set<String> start = new HashSet<>(Collections.singleton(beginWord));
        //结束端
        Set<String> end = new HashSet<>(Collections.singleton(endWord));
        //所有字符串的字典
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) {
            return 0;
        }
        //经历过上面的一系列判定，到这里的时候，若是有路径，则最小是2，所以以2开始
        return bfs(start, end, dic, 2);

    }

    public int bfs(Set<String> st, Set<String> ed, Set<String> dic, int l) {
        //双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
        if (st.size() == 0) {
            return 0;
        }
        //双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
        if (st.size() > ed.size()) {
            return bfs(ed, st, dic, l);
        }
        //BFS的标记行为，即使用过的不重复使用
        dic.removeAll(st);
        //收集下一层临近点
        Set<String> next = new HashSet<>();
        for (String s : st) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];

                //26个字母依次替换
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) {
                        continue;
                    }
                    arr[i] = c;
                    String nstr = new String(arr);
                    if (dic.contains(nstr)) {
                        if (ed.contains(nstr)) {
                            return l;
                        } else {
                            next.add(nstr);
                        }
                    }
                }
                //复原
                arr[i] = tmp;
            }
        }
        return bfs(next, ed, dic, l + 1);
    }
}
