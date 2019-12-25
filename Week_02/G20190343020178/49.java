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


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        int[] arr = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (int i = 0; i < strs.length; i++) {
            int count = 1;
            for(int j = 0; j < strs[i].length(); j++){
                count *= arr[strs[i].charAt(j) - 'a'];
            }
            if(map.containsKey(count)){
                map.get(count).add(strs[i]);
            }else{
                List<String> tmp = new ArrayList<String>();
                tmp.add(strs[i]);
                map.put(count,tmp);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        for(int i = 0; i < strs.length; i++){
//            char[] a = strs[i].toCharArray();
//            Arrays.sort(a);
//            String key  = String.valueOf(a);
//            if(map.containsKey(key)){
//                map.get(key).add(strs[i]);
//            }else{
//                List<String> tmp = new ArrayList<String>();
//                tmp.add(strs[i]);
//                map.put(key,tmp);
//            }
//        }
//        return new ArrayList<List<String>>(map.values());
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
