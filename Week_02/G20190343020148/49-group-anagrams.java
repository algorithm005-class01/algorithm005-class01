class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }
        Map<String,List> map = new HashMap();
        int[] arr=new int[26];
        for(String s : strs){
            Arrays.fill(arr,0);
            for(char c:s.toCharArray()) arr[c-'a']++;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append("/");
                sb.append(arr[i]);
            }
            String k=sb.toString();
            if(!map.containsKey(k)){
                map.put(k,new ArrayList());
            }
            map.get(k).add(s);
        }
        return new ArrayList(map.values());

    }
}