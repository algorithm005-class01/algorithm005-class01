/**
 * 
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

/*
* 哈希算法
时间复杂度 O(n*klogk) 数组数量 * 每个字符串的排序复杂度
*/
class SolutionHash
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        if (strs.size() == 0)
            return {};
        if (strs.size() == 1)
            return {strs};
        // 处理 排序后的字符串为key, 原字符串添加到数组中
        unordered_map<string, vector<string>> hash;
        for (auto s : strs)
        {
            string key = s;
            sort(key.begin(), key.end());

            // 这里有个疑问 , 可以直接写成这样, 而不需要判断是否key是否存在
            hash[key].push_back(s);
            /**
             * 疑问解答看文档 http://www.cplusplus.com/reference/unordered_map/unordered_map/operator[]/
             * 
             If k matches the key of an element in the container, the function returns a reference to its mapped value.

// 下面说明 如果不存在, 则创建一个value的默认构造器返回的元素
If k does not match the key of any element in the container, the function inserts a new element with that key and returns a reference to its mapped value. Notice that this always increases the container size by one, even if no mapped value is assigned to the element (the element is constructed using its default constructor).
            */

            // if (hash.find(key) == hash.end()) {
            //     vector<string> array;
            //     array.push_back(s);
            //     hash[key] = array;
            // } else {
            //     hash[key].push_back(s);
            // }
        }

        vector<vector<string>> ans;
        for (auto item : hash)
        {
            ans.push_back(item.second);
        }
        return ans;
    }
};

/*
看题解发现有 记数法, 主要是根据题目要求是 只有小写字母
所以将 abcd 对应 [#0#1#2#3#4#5#6#7#8#9#......#24#25],  之所以用 # 分割 是因为有的计数可能超过10 , 便于判断

不过这种有 局限性 , 所以不用了解即可
**/
class SolutionCounter
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        if (strs.empty())
            return {{}};
        unordered_map<string, vector<string>> umap;
        vector<int> hash(26, 0);
        for (string str : strs)
        {
            fill(hash.begin(), hash.end(), 0);
            for (char c : str)
            {
                ++hash[c - 'a'];
            }
            string tmp;
            for (int i = 0; i < hash.size(); ++i)
            {
                tmp += '#';
                tmp += hash[i];
            }
            umap[tmp].push_back(str);
        }

        vector<vector<string>> ans;
        for (auto it : umap)
        {
            ans.push_back(it.second);
        }
        return ans;
    }
};

void printArr(vector<vector<string>> &arr)
{
    for (vector<string> strs : arr)
    {
        for (auto s : strs)
        {
            cout << s << "  -- ";
        }
        cout << endl;
    }
    cout << endl;
};

int main(int argc, char **argv)
{
    vector<string> arrs;
    arrs.push_back("fasdg");
    arrs.push_back("gasdf");
    arrs.push_back("aba");
    arrs.push_back("aab");
    vector<vector<string>> v = SolutionHash().groupAnagrams(arrs);
    printArr(v);
    return -1;
}
