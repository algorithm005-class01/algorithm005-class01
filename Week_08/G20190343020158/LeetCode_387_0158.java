class Solution {
    /**
     * 思路：用map存储每个字符出现的次数，然后再遍历字符串得到第一个出现个数为1的字符所在的索引
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chs.length; i++) {
            if (map.get(chs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}