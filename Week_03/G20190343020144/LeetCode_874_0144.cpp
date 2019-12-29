/**
 * 
 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

-2：向左转 90 度
-1：向右转 90 度
1 <= x <= 9：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物。

第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])

如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。

返回从原点到机器人的最大欧式距离的平方。

 

示例 1：

输入: commands = [4,-1,3], obstacles = []
输出: 25
解释: 机器人将会到达 (3, 4)
示例 2：

输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
输出: 65
解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 

提示：

0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
答案保证小于 2 ^ 31

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/walking-robot-simulation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

#include <iostream>
#include <vector>
using namespace std;

/// 实在是没有看懂题 , 障碍物的位置有疑惑
class Solution
{
public:
    int turn(int d, int cmd)
    {
        int ret = d;

        switch (d)
        {
        case 0:
            if (cmd == -1)
                ret = 1;
            else
                ret = 3;
            break;
        case 1:
            if (cmd == -1)
                ret = 2;
            else
                ret = 0;
            break;
        case 2:
            if (cmd == -1)
                ret = 3;
            else
                ret = 1;
            break;
        case 3:
            if (cmd == -1)
                ret = 0;
            else
                ret = 2;
            break;
        default:
            break;
        }

        return ret;
    }

    bool judge(int x, int y, int **o, int os)
    {
        int i;
        int r = x + y * 30000;
        int left = 0, mid = os / 2, right = os;

        if (!os || r > o[os - 1][0] || r < o[0][0])
            return true;

        if (r == o[mid][0])
            return false;

        while (left + 1 < right)
        {
            if (r > o[mid][0])
            {
                left = mid;
                mid = (left + right) / 2;
            }
            else if (r < o[mid][0])
            {
                right = mid;
                mid = (left + right) / 2;
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    int cmp(void *a, void *b)
    {
        return (*(int **)a)[0] - (*(int **)b)[0];
    }

    int robotSim(int *commands, int commandsSize, int **obstacles, int obstaclesSize, int *obstaclesColSize)
    {
        int x = 0, y = 0;
        int d = 0;
        int ret = 0;

        char b[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i;

        for (i = 0; i < obstaclesSize; i++)
        {
            obstacles[i][0] = obstacles[i][0] + obstacles[i][1] * 30000;
        }

        qsort(obstacles, obstaclesSize, sizeof(int *), cmp);

        for (i = 0; i < commandsSize; i++)
        {
            switch (commands[i])
            {
            case -1:
            case -2:

                d = turn(d, commands[i]);
                break;
            default:
                while (commands[i]--)
                {
                    if (judge(x + b[d][0], y + b[d][1], obstacles, obstaclesSize))
                    {
                        x += b[d][0];
                        y += b[d][1];
                    }
                    else
                        break;
                }
                break;
            }

            ret = ret < x * x + y * y ? x * x + y * y : ret;
        }

        return ret;
    }
};

#include <set>

class Solution
{
public:
    int robotSim(vector<int> &commands, vector<vector<int>> &obstacles)
    {
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        //每个方向前进时的坐标增量
        int x = 0, y = 0; //机器人的坐标
        int di = 0;       //方向 北0 东1 南2 西3

        set<pair<int, int>> obstacleSet; //存放障碍物的集合
        for (vector<int> obstacle : obstacles)
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));

        int ans = 0; //最大欧式距离
        for (int cmd : commands)
        {
            if (cmd == -2)
                di = (di + 3) % 4;
            else if (cmd == -1)
                di = (di + 1) % 4;
            else
            {
                for (int k = 0; k < cmd; ++k)
                {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if (obstacleSet.find(make_pair(nx, ny)) == obstacleSet.end())
                    {
                        x = nx;
                        y = ny;
                        ans = max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
};