package com.log8;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if(null==s||null==t){
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        int[] tt=new int[26];
        for(int i=0;i<s.length();i++){
            tt[s.charAt(i)-'a']++;
            tt[t.charAt(i)-'a']--;
        }

        for(int j=0;j<tt.length;j++){
            if(tt[j]!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 2019-12-19
     * @param a
     * @param b
     * @return
     */
    public boolean isAnagram2(String a,String b){
        if(null==a||null==b||(a.length()!=b.length())){
            return false;
        }
        int[] map = new int[26];
        for(int i=0;i<a.length();i++){
            //此处代码应该改成 -'a' 可以不用记忆a的ascii码值
//            map[(a.charAt(i)-97)]++;
//            map[(b.charAt(i)-97)]--;
            map[a.charAt(i)-'a']++;
            map[b.charAt(i)-'a']--;
        }
        for(int j=0;j<map.length;j++) {
            if(map[j]!=0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s="zabc";
        String t="bacz";
        Solution242 s242 = new Solution242();
//        System.out.println(s242.isAnagram(s, t));
        System.out.println(s242.isAnagram2(s, t));
    }
}
