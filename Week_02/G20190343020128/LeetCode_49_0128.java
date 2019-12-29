import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // return sortedHash(strs);
        return alphabetHash(strs);
    }


    /**
     * 方法二:字母表hash法(基本同242题)
     *      不同的异位词在字母表上出现的次数是一定的,所以使用字母表的出现此处充当key值,但是需要加连接符号(防止进位)
     * 复杂度分析: N代表strs的长度,K代表strs中最长值得长度
     *      时间: O(NK)
     *      空间: O(NK)
     * @param strs
     * @return
     */
    public List<List<String>> alphabetHash(String[] strs){
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String,List> map = new HashMap<>();
        for (String str : strs) {
            int[] alphabet = new int[26];
            char[] words = str.toCharArray();
            for (int i = 0; i < words.length; i++) {
                alphabet[words[i] - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < alphabet.length; i++) {
                sb.append(alphabet[i]);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());

    }


    /**
     * 方法一:排序hash法
     *      如果两个词互为异位词,那么排序后一定相等,可以利用这点将其排序后的值定位map的key,value就是异位词数组,判断
     *      map如果没有就新创建个数组然后添加原词进去,有则在数组上添加
     * 复杂度分析:(其中N代表strs的长度,K代表strs中最大字符串的长度)
     *      时间: O(NKlogK)
     *      空间: O(NK)    
     * @param strs
     * @return
     */
    public List<List<String>> sortedHash(String[] strs){
        if (strs == null || strs.length <1) {
            return new ArrayList();
        }
        Map<String,List> map = new HashMap<>();
        for (String str : strs) {
            char[] needSort = str.toCharArray();
            Arrays.sort(needSort);
            String key = String.valueOf(needSort);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());

    }
}
// @lc code=end

