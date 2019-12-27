//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 边界处理
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // 通过哈希表分组记录异位词
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 利用数据记录每个字符出现的频次
            // 每个字符位出现频次都相同的即异位词，频次记为分组 key
            int[] ascii = new int[26];
            for (char c : strs[i].toCharArray()) {
                ascii[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int ai = 0; ai < ascii.length; ai++) {
                sb.append(ascii[ai]);
            }
            String key = sb.toString();
            // 如果当前哈希表不存在该词的异位词，则新增
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            // 将当前单词计入异位词分组中49
            result.get(key).add(strs[i]);
        }
        return new ArrayList<>(result.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
