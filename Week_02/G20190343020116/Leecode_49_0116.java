import java.util.*;

class Leecode_49_0116 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){ return new ArrayList<>(); }
        Map<String,List<String>> map = new HashMap<>();
        for( int i =0 ; i < strs.length ; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String value = String.valueOf(chars);
            if(!map.containsKey(value)){
                map.put(value,new ArrayList<>());
            }
            map.get(value).add(strs[i]);

        }
        return new ArrayList<>(map.values());


    }

    }
}