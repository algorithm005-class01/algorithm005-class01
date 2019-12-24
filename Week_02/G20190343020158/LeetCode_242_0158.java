class Solution {
    public boolean isAnagram(String s, String t) {
        /**
         * 由于题意可假设都为小写字母，所以可用Ascii统计出字母出现的次数
         * 从而判断两个字符串是否为异位词
         * 执行用时 8 ms
         * 内存消耗 37.5 MB
         */
        if (s.length() != t.length()) {
            return false;
        }
        int[] count1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count1[s.charAt(i) - 'a'] ++;
            count1[t.charAt(i) - 'a'] --;
        }

        for(int i = 0; i < count1.length; i++) {
            if (count1[i] != 0) {
                return false;
            }
        }

        return true;


        /**
         * 可以直接排序后进行比较
         * 执行用时 6 ms
         * 内存消耗 37 MB
         */
         if (s.length() != t.length()) {
             return false;
         }
         char[] c1 = s.toCharArray();
         char[] c2 = t.toCharArray();
         Arrays.sort(c1);
         Arrays.sort(c2);
         return Arrays.equals(c1, c2);

    }
}