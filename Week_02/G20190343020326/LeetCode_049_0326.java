class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            char[] r= strs[i].toCharArray();
            Arrays.sort(r);
            String k=new String(r);
            if (m.containsKey(k)){
                List<String> p=m.get(k);
                p.add(strs[i]);
                m.put(k,p);
            }else {
                List<String> p=new ArrayList<>();
                p.add(strs[i]);
                m.put(k,p);
            }
        }
        res.addAll(m.values());
        return res;
    }
}
