class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (str.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : str) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return ArrayList(ans.values());
    }
}