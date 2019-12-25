package com.demo.test.leetcode;

import java.util.Arrays;

/**
 * TODO
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母重排序。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false

 * @author houyujia
 * @since 2019/12/22
 */
public class validAnagram242 {
    public static void main(String[] args) {
        String  s = "anagram", t = "nagaram";
        System.out.println(method2(s,t));

    }

    /**
     * 解法一：暴力，排序后比较字符串是否相等
     * @param s
     * @param t
     */
    public static Boolean method1(String s,String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        return Arrays.equals(ss,tt);

    }

    /**
     * 解法二：正统计s中每个字母出现的次数  负统计t中每个字母出现的次数
     * @param s
     * @param t
     * @return
     */
    public static Boolean method2(String s,String t){
        if (s.length()!=t.length()){
            return false;
        }
        int[] counter = new int[26];
        int sIndex=0,tIndex=0;
        for (int i = 0; i < s.length(); i++) {

            //计算字母的ask码减去97('a')  得到位置 例：a ：0  b：1  c：2.....z:25
            sIndex=s.charAt(i)-97;
            tIndex=t.charAt(i)-97;
            //在字母所在的位置 +1
            counter[sIndex]=counter[sIndex]+1;
            //在字母所在的位置 -1
            counter[tIndex]=counter[tIndex]-1;
        }
        //26个位置 如果出现未归0的 返回false
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;


    }

}
