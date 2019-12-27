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


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String.
                    String sortStr = String.copyValueOf(chars);
            if (map.get(sortStr)==null) {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sortStr, list);
                lists.add(list);
            } else {
                List<String> list = map.get(sortStr);
                list.add(s);
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
