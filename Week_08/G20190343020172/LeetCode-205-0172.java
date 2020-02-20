private boolean isIsomorphicHelper(String s, String t) {
    int n = s.length();
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
        char c1 = s.charAt(i);
        char c2 = s.charAt(i);
        if (map.containsKey(c1)) {
            if (map.get(c1) != c2) {
                return false;
            }
        } else {
            map.put(c1, c2);
        }
    }
    return true;
}