/*
 思路: 每组异位词计算一个相同的feature值, 
 feature值采用将26个字母Hash表的值拼字符串的方式
 不足之处：不能适应非ASCII码字符
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            String feature = computeFeature(s);
            if (!map.containsKey(feature)) {
                map.put(feature, new ArrayList(Arrays.asList(s)));
            } else {
                map.get(feature).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String computeFeature(String ps) {
        int[] codeMap = new int[26];

        for (char c: ps.toCharArray()) {
            codeMap[c - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i: codeMap) {
            sb.append("#");
            sb.append(i);
        }
        sb.append("#");
        return sb.toString();
    }
}