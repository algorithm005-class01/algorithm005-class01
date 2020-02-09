package week07;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Description: LRU缓存机制.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_146_0314 {
  
  class LRUCache {
    private byte[] lock = new byte[0];
    
    private LinkedHashMap<Integer, Integer> linkedHashMap;
    
    private  int capacity;
    
    private int count;
    
    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.linkedHashMap = new LinkedHashMap(capacity);
    }
    
    public int get(int key) {
      Integer temp = linkedHashMap.get(key);
      if(temp==null ){
        temp=-1;
      }else {
        synchronized(lock) {
          linkedHashMap.remove(key);
          linkedHashMap.put(key, temp);
        }
      }
      return temp;
    }
    
    public  void put(int key, int value) {
      
      if(linkedHashMap.get(key)!=null) {
        synchronized(lock) {
          linkedHashMap.remove(key);
          linkedHashMap.put(key, value);
        }
        
      } else {
        if(count>=capacity) {
          Set<Integer> keySet = linkedHashMap.keySet();
          Iterator<Integer> it = keySet.iterator();
          synchronized(lock) {
            linkedHashMap.remove(it.next());
            linkedHashMap.put(key, value);
          }
          
        } else {
          synchronized(lock) {
            linkedHashMap.put(key, value);
          }
          count++;
        }
      }
    }
  }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
