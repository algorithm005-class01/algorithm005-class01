




class Solution387 {
    public int firstUniqChar(String s) {
        int[] lets = new int[26];
        for (char c:s.toCharArray()){
            lets[c-'a']++;
        }
        for (int i = 0; i <s.length() ; i++) {
            if(lets[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}