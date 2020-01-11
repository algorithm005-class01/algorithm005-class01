/**
一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意:

起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
所有的目标基因序列必须是合法的。
假定起始基因序列与目标基因序列是不一样的。
示例 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

返回值: 1
示例 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

返回值: 2
示例 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

返回值: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/
#include <iostream>
#include <vector>
#include <map>
#include <queue>

using namespace std;

/**
 * 类似单词变形  完全不关系 哪些是可变的基因, 只需要处理基因库就可以了
 * 不同的是 level 的含义不同
 * 
*/
class Solution
{
public:
    int minMutation(string start, string end, vector<string> &bank)
    {
        // 预处理
        map<string, vector<string>> common_dict;
        map<string, bool> visit;
        for (string gene : bank)
        {
            // 通用状态
            visit[gene] = false;
            for (size_t i = 0; i < gene.size(); i++)
            {
                string common = gene;
                common[i] = '*';
                common_dict[common].push_back(gene);
            }
        }
        queue<pair<string, int>> q;
        q.push(make_pair(start, 0));
        visit[start] = true;
        int size = start.size();

        while (!q.empty())
        {
            pair<string, int> node = q.front();
            q.pop();
            string g = node.first;
            int level = node.second;
            for (size_t i = 0; i < size; i++)
            {
                string key = g;
                key[i] = '*';
                for (auto gene : common_dict[key])
                {
                    if (gene == end)
                    {
                        return level + 1;
                    }
                    else if (visit[gene] == false)
                    {
                        visit[gene] = true;
                        q.push(make_pair(gene, level + 1));
                    }
                }
            }
        }

        // 访问记录
        // 队列 BFS
        // 取元素
        // 找通用状态, 找所有 change 1次的单词
        // 是否相等, 剪枝, 更新记录
        return -1;
    }
};