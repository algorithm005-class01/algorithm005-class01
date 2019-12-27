class Solution {

    //1.哈希表
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> result = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            Integer sCount = result.getOrDefault(sChar, 0) + 1;
            if (sCount != 0) {
                result.put(sChar, sCount);
            } else {
                result.remove(sChar);
            }
            Integer tCount = result.getOrDefault(tChar, 0) - 1;
            if (tCount != 0) {
                result.put(tChar, tCount);
            } else {
                result.remove(tChar);
            }
        }
        return result.isEmpty();
    }

}

class Solution2 {

    //2.排序后比较
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        String sortS = String.valueOf(sChars);
        String sortT = String.valueOf(tChars);
        return sortS.equals(sortT);
    }

}