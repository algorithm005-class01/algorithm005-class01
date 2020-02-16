package com.log8.week08;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s==null||p==null||(s.trim()).equals("")||(p.trim()).equals("")) return res;
        //滑动窗口map
        int[] winMap = new int[26];
        int[] pmap = new int[26];
        for(int i=0;i<p.length();i++){
            pmap[p.charAt(i)-'a']= pmap[p.charAt(i)-'a']+1;
        }
        int len = p.length();
        //滑动窗口大小 用count检测窗口中是否已经涵盖了p中的字符
        int count=0;
        //滑动窗口左右边界
        int left=0,right=0;
        //模板
        while(right<s.length()){
            //放入窗口中
            int key = s.charAt(right) - 'a';
            winMap[key]= winMap[key]+1;
            //right++;
            right++;
            //对比pmap 条件合适则合规元素个数大小 也可以是窗口大小加1
            if((pmap[key]>0) && (winMap[key]<=pmap[key])){
                count++;
            }
            //如果合规元素个数大小 也可以是窗口大小 等于len 则符合字母异位词
            if(count==len) {
                res.add(left);
            }
            //if(valid)
            //    从窗口中删除
            //    left++
            if(right-left>=len){
                int leftKey = s.charAt(left)-'a';
                //对比pmap 条件合适则合规元素个数大小 也可以是窗口大小加1
                if((pmap[leftKey]>0) && (winMap[leftKey]<=pmap[leftKey])){
                    count--;
                }
                winMap[leftKey] = winMap[leftKey]-1;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbbaebabacd";
        String p = "abc";
        Solution438 sol = new Solution438();
        List<Integer> res = sol.findAnagrams(s,p);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
