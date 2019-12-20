/**
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1:

    输入: [1,2,3]
    输出: [1,2,4]
    解释: 输入数组表示数字 123。
    示例 2:

    输入: [4,3,2,1]
    输出: [4,3,2,2]
    解释: 输入数组表示数字 4321。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/plus-one
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
using namespace std;

/**
 * 
 * 这里考虑了过多的请求, 导致时间复杂度增大了不少
 * 
*/
class Solution
{
public:
    vector<int> plusOne(vector<int> &digits)
    {
        int next = 0, sum = 0;
        bool plusOne = false;
        for (int i = digits.size() - 1; i >= 0; i--)
        {
            plusOne = i == (digits.size() - 1);
            sum = digits[i] + next + (plusOne ? 1 : 0);
            if (sum >= 10)
            {
                digits[i] = sum % 10;
                next = 1;
            }
            else
            {
                digits[i] = sum;
                next = 0;
                break;
            }
        }
        if (next == 1)
        {
            digits.insert(digits.begin(), 1);
        }

        return digits;
    }
};

class Solution2
{
public:
    vector<int> plusOne(vector<int> &digits)
    {
        for (int i = (int)digits.size() - 1; i >= 0; i--)
        {
            if (digits[i] == 9)
            {
                digits[i] = 0;
            }
            else
            {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0)
        {
            digits.push_back(0);
            digits[0] = 1;
        }
        return digits;
    }
};

void printArr(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << ",";
    }
    cout << endl;
}

int main()
{
    vector<vector<int>> arrs;
    arrs.push_back({1, 1, 1});
    arrs.push_back({9, 9, 9});
    arrs.push_back({9, 6, 9});
    arrs.push_back({9, 6, 1});
    arrs.push_back({0});

    for (auto arr : arrs)
    {
        vector<int> v = Solution2().plusOne(arr);
        printArr(v);
    }
    return -1;
}