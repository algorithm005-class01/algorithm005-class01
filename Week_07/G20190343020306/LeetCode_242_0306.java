class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { return false; }
        }
        return true;
    }
}