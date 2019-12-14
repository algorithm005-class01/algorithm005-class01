// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 示例:

// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出: 6

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

/**
 * 有凹陷才会有可能接雨水
 * 所以首先求 diff 差值数组
 * 
*/
class Solution
{
public:
    int trap(vector<int> &height)
    {
        int ans = 0, current = 0;
        stack<int> st;
        while (current < height.size())
        {
            // pop 栈的条件
            while (!st.empty() && height[current] > height[st.top()])
            {
                int top = st.top();
                st.pop();
                // 排除只是上升的情况
                if (st.empty())
                    break;
                int distance = current - st.top() - 1;
                cout << current << ": " << st.top() << ": " << distance << endl;

                int bounded_height = min(height[current], height[st.top()]) - height[top];
                cout << bounded_height << endl;
                // 计算的是规则图形的面积, 而不是不规则的算法
                ans += distance * bounded_height;
                cout << distance * bounded_height << "----" << endl;
            }
            st.push(current++);
        }
        return ans;
    }
};

void printArr(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << ",";
    }
    cout << endl;
};

int main(int argc, char **argv)
{
    vector<vector<int>> arrs;
    arrs.push_back({0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

    for (auto arr : arrs)
    {
        printArr(arr);
        cout << Solution().trap(arr) << endl;
    }
    return -1;
}