package com.log8.week02;

import com.sun.tools.hat.internal.util.ArraySorter;

import java.util.*;

public class Solution49 {

    //2019-12-19

    /**
     * hashmap存储 key即排序后的数组字符串 key相同插入'
     * 时间复杂度 NKlogN
     * 空间复杂度 NK ?此处不是特别理解
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return null;
        }
        //看官方题解后 result对象可以不用声明 最后用map.values方法即可
        List<List<String>> result = new ArrayList<>();
        Map<String, LinkedList<String>> map = new HashMap<>();
        for(String stri:strs){
            //klogn
            char[] tt = stri.toCharArray();
            Arrays.sort(tt);
            String key = Arrays.toString(tt);
            if(!map.containsKey(key)){
                LinkedList<String> t = new LinkedList<>();
                result.add(t);
                t.addLast(stri);
                map.put(key,t);
            }else{
                map.get(key).addLast(stri);
            }
        }
        return result;
    }

    /**
     *2019-12-19
     * 官方题解1
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsOffice(String[] strs) {
        if(strs == null){
            return null;
        }
        Map<String,ArrayList<String>> map = new HashMap<>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            char[] tt = strs[i].toCharArray();
            Arrays.sort(tt);
            String key = String.valueOf(tt);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }



    public static void main(String[] args) {
        String[] strs = new String[]{
            "eat", "tea", "tan", "ate", "nat", "bat"
        };
        Solution49  s49 = new Solution49();

//        List<List<String>> result =  s49.groupAnagrams(strs);
        List<List<String>> result =  s49.groupAnagramsOffice(strs);
        for(List<String> list : result ){
            System.out.println(list.toString());
        }
    }
}
