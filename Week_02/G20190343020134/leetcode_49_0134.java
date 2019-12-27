package sort.day1;
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

/**
 * 解题思路：
 * 哈希表法：
 * 首先对数组中的每个元素按照字符进行排序，把排序后的结果做为key，原来的字符串作为
 * value存储到哈希表中。哈希表的格式为Map<排序后的字符串，List<数组中的字符串>>
 * 时间复杂度：首先外层循环遍历一遍数组为O(n),然后在数组里面对于每个元素进行排序的复杂度为O(nlogn),
 * 所以整体的复杂度为O(n^2logn)
 *
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[]  strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> r : result) {
            System.out.println(r);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String,List<String>> sortKey2Strs = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortKey = new String(strArr);
            if (sortKey2Strs.containsKey(sortKey)) {
                sortKey2Strs.get(sortKey).add(str);
            }else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                sortKey2Strs.put(sortKey,strList);
            }
        }
        return new ArrayList<>(sortKey2Strs.values());

    }
}
