package Week2_0106;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();

        for (int i = 0; i < strs.length; i++) {
            String str1 = strs[i];

            char[] ch1 = str1.toCharArray();
            Arrays.sort(ch1);
            String s1 = String.valueOf(ch1);

            if (!map.containsKey(s1)) {
                List<String> ls = new ArrayList<String>();
                ls.add(str1);
                map.put(s1, ls);
            } else {
                List<String> ls = map.get(s1);
                ls.add(str1);
                map.put(s1, ls);
            }

        }

        return new ArrayList(map.values());
    }
}
