class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        String[] orderStrs = new String[strs.length];
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            orderStrs[i] = String.valueOf(cs);
        }
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(orderStrs[i])) {
                map.get(orderStrs[i]).add(strs[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(orderStrs[i], list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}