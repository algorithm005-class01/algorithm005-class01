import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangxiong
 * @Date 2019/12/16
 * @Description leetcode题目242 有效的字母异位词
 **/
public class LeetCode_242_0110 {
    /**
     * 解法1使用排序法
     * 通过将 s 的字母重新排列成 t 来生成变位词。因此，
     * 如果 T 是 S 的变位词，对两个字符串进行排序将产生两个相同的字符串。
     * 此外，如果 s 和 t 的长度不同，t 不能是 s 的变位词，我们可以提前返回。
     * 复杂度分析 时间复杂度：O(n \log n)，假设 n 是 s 的长度，排序成本
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }

    /**
     * 解法2 使用map
     * 创建数据结构为 Map 的 map 对象;
     * 遍历 s, 将各字母出现的次数叠加存储进 map 中;
     * 遍历 t, 在 map 中减少相应字母出现的个数, 并增加 map 中未收录的字母;
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

    /**
     * 解法3 使用哈希算法
     * 首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * s 负责在对应位置增加，t 负责在对应位置减少
     * 如果哈希表的值都为 0，则二者是字母异位词。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        int[] charsMap = new int['z'-'a'+1];
        for(char c: s.toCharArray()) {
            int pos = c - 'a';
            charsMap[pos]++;
        }
        for(char c: t.toCharArray()) {
            int pos = c - 'a';
            charsMap[pos]--;
        }
        for(int count: charsMap) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
}
