package G20190343020220.leetcode_49_0220;

/*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序
*/

import java.util.*;

/**
 * @author Darcy
 * @date 2019-12-16 21:23
 */
public class Sulotion {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String newS = new String(array);
            if (map.containsKey(newS)) {
                map.get(newS).add(s);
            } else {
                List<String> nyList = new ArrayList<>();
                nyList.add(s);
                list.add(nyList);
                map.put(newS, nyList);
            }
        }
        return list;
    }
}
