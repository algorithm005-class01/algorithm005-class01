/*
 * @lc app=leetcode.cn id=49 lang=csharp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        IList<IList<string>> result = new List<IList<string>>();
            if (strs.Length == 0) return result;
            Dictionary<string, List<string>> dic = new Dictionary<string, List<string>>();
            foreach (string s in strs)
            {
                char[] chas_s = s.ToCharArray();
                Array.Sort(chas_s);
                string key = new string(chas_s);
                if (!dic.ContainsKey(key))
                {
                    List<string> curstr = new List<string>();
                    curstr.Add(s);
                    dic.Add(key, curstr);
                }
                else
                {
                    dic[key].Add(s);
                }
            }

            var e = dic.GetEnumerator();
            while (e.MoveNext())
            {
                result.Add(e.Current.Value);
            }

            e.Dispose();
            return result;
    }
}
// @lc code=end

