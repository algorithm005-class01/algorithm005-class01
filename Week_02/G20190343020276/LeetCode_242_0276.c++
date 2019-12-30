class Solution {
public:
    bool isAnagram(string s, string t) 
    {
        //方法一：哈希表的方式统计每个字符出现的频次
        //方法二：将字符串按照字符顺序排序，比较两个字符串是否相等，时间复杂度O(NlogN)


        if(s.size() != t.size())
            return false;
        // 方法一：
        unordered_map<char,int> omap;
        for(int i=0;i<s.size();i++)
        {
            // char c = s[i];
            ++omap[s[i]];
        }
        for(int i=0;i<t.size();i++)
        {
            // char c = t[i];
            if(omap[t[i]] >0)
                --omap[t[i]];
            else
                return false;
        }
        return true;
        //方法二：
        // if(s.size() != t.size())
        //     return false;
        
        // sort(s.begin(),s.end());
        // sort(t.begin(),t.end());
        // return s==t;
    }
};