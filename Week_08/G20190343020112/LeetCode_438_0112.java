class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (char c : p.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int match = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (target.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(target.get(ch))) {
                    match++;
                }
            }
            right++;
            while (match == target.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                ch = s.charAt(left);
                if (target.containsKey(ch)) {
                    window.put(ch, window.get(ch) - 1);
                    if (window.get(ch) < target.get(ch)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}