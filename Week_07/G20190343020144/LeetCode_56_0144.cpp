/**
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        if (intervals.size() <= 1)
            return intervals;
        // 这里还要考虑的是没有按照顺序排序的问题
        auto compare = [](vector<int> &v1, vector<int> &v2) {
            return v1[0] < v2[0];
        };
        sort(intervals.begin(), intervals.end(), compare); // 按区间的start排序
        vector<vector<int>> ans;
        vector<int> pre = intervals[0];
        vector<int> cur;
        for (int i = 1; i < intervals.size(); i++)
        {
            cur = intervals[i];
            if (pre[1] >= cur[0])
            {
                if (pre[1] < cur[1])
                {
                    pre[1] = cur[1];
                }
            }
            else
            {
                ans.push_back(pre);
                pre = cur;
            }
        }
        //最后一个
        ans.push_back(pre);
        return ans;
    }
};