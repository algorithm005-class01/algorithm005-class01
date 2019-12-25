import java.util.*;

public class LeetCode_49_0192 {

    // 49. 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return Collections.EMPTY_LIST;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKeyByArray(str);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }

        return new LinkedList<>(map.values());
    }

    public String getKeyByArray(String str) {
        char[] charArr = new char[26];
        for (char c : str.toCharArray()) {
            charArr[c - 'a']++;
        }
        return new String(charArr);
    }

}
