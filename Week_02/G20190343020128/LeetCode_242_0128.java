import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        return hashMapMethod(s, t);
    }

    /**
     * 方法二：排序法
     *      如果两个字符串仅仅是顺序不同，那么将其打成char[]后排序一定是全等的
     * 复杂度分析:
     *      时间: O(nlogn)
     *      空间: O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean sortMethod(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    /**
     * 方法一: Hash法
     *      将其中一个String打成char[] 存入map中去，key代表字母，value代表次数,再迭代循环另一个打成char[]的string
     *      如果字符不在map中,直接返回false,否则value--;最后还需要遍历一次map查看是否所有value都是0
     * 优化:
     *      由于在java中char字符其实是int字符,a-z都可以转化为连续的int数字,所以我们只需要申请一个大小为26的int数组
     *      即可,假设a字符的下标为0,b的下标就是b-a,这样用位置上的值记录字符出现的次数就可以减少一次迭代
     * 复杂度分析:
     *      时间: O(n)
     *      空间: O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean hashMapMethod(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphbet = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            alphbet[charS[i] - 'a']++;
            alphbet[charT[i] - 'a']--;
        }
        for (int c : alphbet) {
            if (c != 0 ) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

