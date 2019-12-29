package week02;


import java.util.*;

//输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//    ["ate","eat","tea"],
//    ["nat","tan"],
//    ["bat"]
//]
public class Leetcode_49_0230 {

    // 方法1
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) return new ArrayList();
//        Map<String, List> ans = new HashMap<String, List>();
//        for (String s : strs) {
//            // System.out.println(s);
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            // System.out.println(ca);
//            String key = String.valueOf(ca);
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"are", "bat", "ear", "code", "tab", "era"};
        Leetcode_49_0230 solution = new Leetcode_49_0230();
        System.out.print(solution.groupAnagrams(strs));
    }
}
