public class LeetCode_387_0120 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        for(int i =0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
