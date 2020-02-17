class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                map.put(character, -1);
            } else {
                map.put(character, i);
            }
        }
        return map.values().stream().filter(index -> index >= 0).sorted().findFirst().orElse(-1);
    }
}