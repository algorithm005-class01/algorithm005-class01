package week008;

import org.junit.Test;

public class Leecode541	 {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }


    @Test 
    public void test() {
    	System.out.println(reverseStr("", 2));
    	System.out.println(reverseStr("a", 2));
    	System.out.println(reverseStr("ab", 2));
    	System.out.println(reverseStr("abcdefg", 2));
    	System.out.println(reverseStr("abcd", 2));
    	System.out.println(reverseStr("abcde", 2));
    	System.out.println(reverseStr("abcdefgh", 2));
    	System.out.println(reverseStr("abcdefghi", 2));
    }
}
