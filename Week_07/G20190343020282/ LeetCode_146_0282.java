package com.demo.test.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * TODO
 *
 * @author houyujia
 * @since 2020/2/9
 */
public class LRUCache {
    public Map<Integer,Integer> map = new LinkedHashMap<>();
    LinkedList<Integer> list=new LinkedList<Integer>();
    private int size;
    public  LRUCache(int capacity) {
        size=capacity;
        map=new HashMap<>(capacity);
    }

    public int get(int key) {

        if (map.containsKey(key)){
            int aa =map.get(key);
            list.remove(Integer.valueOf(key));
            list.addLast(key);
            return map.get(key);
        }
        return  -1;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            list.remove(Integer.valueOf(key));
        }else if (map.size()==size){
            int a=list.removeFirst();
            map.remove(a);
        }
        list.addLast(key);
        map.put(key,value);
    }
}
