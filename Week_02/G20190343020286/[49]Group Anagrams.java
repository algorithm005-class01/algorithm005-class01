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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 将每个字符串排序，排序后字符串作为key,List作为value存入map中
     * 最后返回map的values
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }


    /**
     * 方法二：将每个字符串对应26数组上，
     * 转换为0#0#2#3的字符串作为key，实际的字符串链表为value
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int[] arr = new int[26];
            for (char ch : strs[i].toCharArray()) {
                arr[ch - 'a']++;
            }
            String key = "";
            for (int j = 0; j < arr.length; j++) {
                key += arr[j] + "#";
            }
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
