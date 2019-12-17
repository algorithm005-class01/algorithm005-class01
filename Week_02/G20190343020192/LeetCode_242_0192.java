public class LeetCode_242_0192 {

    // 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/description/

    /*
    解题思路
    1. 一次循环（失败）
      每次循环s +；t -；
      最后判断map是否为空。但是遇到类"xaaddy","xbbccy"这样的数据没发处理。

    2. 两次循环（成功，效率低）
      使用HashMap，每次循环s +；t -；
      遍历HashMap，如果有非0的数据，说明不是

      速度慢的原因分析：
        因为HashMap不支持基本数据类型，拆箱装箱耗时
        HashMap容量可能远远大于实际字符串的长度，遍历时增加时间

     3. 三次循环（成功，效率高）
       因为都是小写字母，所以可以确定hash的key值取值范围 [a对应的int值，z对应的int值]
       c - 'a' 将hash的key值取值范围转换为 [0, 25]
       第一次循环 s +
       第二次循环 t -
       第三次循环 判断是否存在非0的数据

       速度快的原因分析：
         数据的内存空间是连续的，可以充分利用缓存，对CPU加速友好
         数组只有26位，hash分布很紧凑，遍历时效率高

     */
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }

        for (int i : charCount) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
