class Solution {
    /*
      解题思路: 遍历哈希表
      但是效率并不高, 只击败20%的人, 
    */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c: t.toCharArray()) {
            if (map.getOrDefault(c, 0) - 1 < 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        for (int v: map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}