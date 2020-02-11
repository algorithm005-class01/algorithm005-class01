package week007;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_242_182 {
	public  boolean isAnagram(String s, String t) {
    	if (s == null || t == null) {
    		return false;
    	}
    	
    	if (s.length() != t.length()) {
    		return false;
    	}
    	
    	Map<Character, Integer> m = new HashMap<Character, Integer>();
    	Map<Character, Integer> n = new HashMap<Character, Integer>();
    	for (int i = 0; i < s.length(); i++) {
    		if (m.containsKey(s.charAt(i))) {
    			Integer count = m.get(s.charAt(i));
    			m.put(s.charAt(i), ++count);
    		}
    		else {
    			m.put(s.charAt(i), 1);
    		}
    		
    		if (n.containsKey(t.charAt(i))) {
    			Integer count = n.get(t.charAt(i));
    			n.put(t.charAt(i), ++count);
    		}
    		else {
    			n.put(t.charAt(i), 1);
    		}
    	}
    	
    	for(Map.Entry<Character, Integer> entry : m.entrySet()){
    	    if (!entry.getValue().equals(n.get(entry.getKey()))) {
    	    	return false;
    	    }	
    	}
    	
    	return true;        
    }
}
