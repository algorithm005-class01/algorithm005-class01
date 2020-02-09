package week007;

import org.junit.Test;

/*
编写�?个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 �?1�? 的个数（也被称为汉明重量�?
 * */
public class Leetcode_146_182 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int tmp = n;
        while (tmp != 0) {
        	tmp = tmp & (tmp - 1);
        	count++;
        }
        return count;
    }
    
    
    @Test
    public void test()
    {
    	System.out.println(hammingWeight(5));    
    	System.out.println(hammingWeight(Integer.MAX_VALUE)); 
    }
}
