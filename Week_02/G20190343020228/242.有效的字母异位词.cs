/*
 * @lc app=leetcode.cn id=242 lang=csharp
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
public class Solution {
    public bool IsAnagram(string s, string t) {
        if(s.Length!=t.Length) return false;
        int[] alp = new int[26];
        char[] chars = s.ToCharArray();
        char[] chart = t.ToCharArray();
        for (int i = 0; i < s.Length; i++)
        {
            alp[chars[i]-'a']++;
            alp[chart[i]-'a']--;
        }
        for (int i = 0; i < alp.Length; i++)
        {
            if(alp[i]!=0)
            {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

