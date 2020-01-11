package com.demo.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * 电话号码组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


 * @author houyujia
 * @since 2019/12/29
 */
public class comb_of_phoneNum_17 {
    public static void main(String[] args) {

        Map<Character, String> phone = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res=new ArrayList<String>();

        method2("",0,phone, "239",res);

    }


    /**
     * 分治回溯
     * @param subs
     * @param level
     * @param phone
     * @param digits
     * @param res
     */
    public static void method2(String subs,int level,Map phone,String digits,List<String> res) {

        //终止条件
        if (level==digits.length()){
            res.add(subs);
            System.out.println(res);
            return;
        }

        //子结果处理
        String letter=(String)phone.get(digits.charAt(level));


        //递归调用
        for (int i = 0; i < letter.length(); i++) {
            String[] lett =letter.split("");
            method2(subs+lett[i],level+1,phone,digits,res);
        }



    }
}
