public class LeetCode_91_0192 {
    /*
    参考
    https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
    https://leetcode-cn.com/problems/decode-ways/solution/dong-tai-gui-hua-tu-jie-by-nfgc/

    解法
    计算公式：解码方法的总数[当前位置] = 解码方法的总数[当前位置 - 1] + 解码方法的总数[当前位置]
    char[当前位置] == 0：该位置不计数
    char[当前位置 - 1]char[当前位置] 在 [1, 26]范围内：使用计算公式
    char[当前位置 - 1]char[当前位置] 不在 [1, 26]范围内：非法组合，不计数
     */
    public int numDecodings(String s) {
        int len = s.length();
        int first = 1;
        int second = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < len;i++) {
            int temp = second;
            if (s.charAt(i) == '0')
                second = 0;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))
                second += first;
            first = temp;
        }
        return second;
    }
}
