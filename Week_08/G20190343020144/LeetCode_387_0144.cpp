/**
387. 字符串中的第一个唯一字符

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 

注意事项：您可以假定该字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int firstUniqChar(string s)
    {
        if (s.length() == 0)
            return -1;
        int size = 'z' - 'a';
        vector<int> v(size + 1, 0);
        for (int i = 0; i < s.length(); i++)
        {
            v[s[i] - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++)
        {
            if (v[s[i] - 'a'] == 1)
            {
                return i;
            }
        }

        return -1;
    }
};