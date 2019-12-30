package week_02.commit;

import java.util.*;

// 49. 字母异位词分组
// https://leetcode-cn.com/problems/group-anagrams/
public class Solution_49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        if (null == strs || strs.length == 0) {
            return groupAnagrams;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        groupAnagrams = new ArrayList<>(map.values());
        return groupAnagrams;
    }
}
