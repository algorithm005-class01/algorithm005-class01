package G20190343020064;

import java.util.*;

/**
 * <p>
 * 字母异位词分组
 * </p>
 *
 * @author mingke.yan  2019-12-18 8:12 下午
 */
public class LeetCode_49_0064 {


    /**
     * 时间复杂度 O(NKlogK) N为数组长度 K为每个字符串的长度
     * 空间复杂度 O(NK)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //===============================================================================
        //  将每个 字符串 排序，然后从 map 查询是否存在List，若没有则新建List 添加到map ，若存在则 将该值添加到List中
        //===============================================================================
        Map<String,List<String>> anagramsMap = new HashMap(16);
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            List<String> anagrams = anagramsMap.get(str);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                anagramsMap.put(str,anagrams);
            } else {
                anagrams.add(strs[i]);
            }
        }
        return new ArrayList(anagramsMap.values());
    }

}
