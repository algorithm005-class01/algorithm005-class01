package Week2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 */
public class LeetCode_49_0256 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagramsByMap(strs);
    }

    private List<List<String>> groupAnagramsByMap(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sorted = sortString(str);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted,  list);
            }
        }
        return new ArrayList<>(map.values());
    }
    private String sortString(String str) {
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }


}
