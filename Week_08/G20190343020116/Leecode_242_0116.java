import java.util.HashMap;
import java.util.Map;

/**
 * 字母异位词
 *
 * 字符串排序。比较两个数组是否相同。
 */
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer>  map = new HashMap<Character,Integer>();
        for(Character c:s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{

                map.put(c,map.get(c)+1);
            }
        }
        for(int i =0 ; i< s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

    }
}
