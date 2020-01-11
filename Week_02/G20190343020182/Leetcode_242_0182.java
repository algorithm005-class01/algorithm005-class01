package week002;

import java.util.HashMap;
import java.util.Map;

import week001.Leetcode_66_0182;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leetcode_242_0182 {
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
	
    /*
	public static void main(String args[]) {

		//System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("sdfs", "dsfw"));
		
		//System.out.println(isAnagram("anagram", "nagaram"));
		//System.out.println(isAnagram("rat", "car"));

	}
	*/
}
