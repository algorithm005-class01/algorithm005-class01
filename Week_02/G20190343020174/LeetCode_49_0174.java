public class Solution{
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String newS = new String(array);
            if (map.containsKey(newS)) {
                map.get(newS).add(s);
            } else {
                List<String> nyList = new ArrayList<>();
                nyList.add(s);
                list.add(nyList);
                map.put(newS, nyList);
            }
        }
        return list;
    }
}
}