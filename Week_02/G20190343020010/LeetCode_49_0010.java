package com.android.browser.newhome.news.login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_49_0010 {


    //利用排序后char数组字符顺序相同，则字符串相同的道理，作为map的key，map的key唯一，进而放到相同的List里面去
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);

            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            List<String> list = map.get(key);
            list.add(s);
        }

        return new ArrayList(map.values());

    }


}
