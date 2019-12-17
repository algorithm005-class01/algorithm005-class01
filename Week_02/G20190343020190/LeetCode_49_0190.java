import java.util.*;

public class LeetCode_49_0190 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String ca = new String(chars);
            if (!map.containsKey(ca)) map.put(ca, new ArrayList<>());
            map.get(ca).add(str);
        }
        return new ArrayList<>(new ArrayList<>(map.values()));
    }
}
