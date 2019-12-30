/**
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/
#include <iostream>
#include <vector>
using namespace std;

/**
 * 看官方题解
 * 1. 预处理词典的所有单词中间状态
 * 2. BFS 从开始的单词 层级遍历, 每向下一层即改变了一个单词
 * 
 * 注意: 其实这是一个无权无向图, 所以有环的存在, 而不是简单的多叉树
*/
#include <map>
#include <queue>

/*
层级遍历, 查询, 效率太低了

执行用时 :2172 ms, 在所有 cpp 提交中击败了5.03%的用户
内存消耗 :43.9 MB, 在所有 cpp 提交中击败了5.09%的用户
注意 1. 记录的方式
2. 预处理的最终单词是否在词典里 的边界判断
3. 

*/
class Solution
{
public:
     int ladderLength(string beginWord, string endWord, vector<string> &wordList)
     {
          if (beginWord == endWord)
               return 1;
          bool flag = true;
          map<string, vector<pair<string, bool>>> p_words;
          for (auto word : wordList)
          {
               // 字典里面包含结束单词
               if (word == endWord)
               {
                    flag = false;
               }
               for (size_t i = 0; i < word.size(); i++)
               {
                    string c_word = word;
                    c_word[i] = '*';
                    p_words[c_word].push_back(make_pair(word, false));
               }
          }
          // 不包含在字典的边界
          if (flag)
               return 0;

          queue<pair<string, bool>> q;
          pair<string, bool> word_visit = make_pair(beginWord, false);
          q.push(word_visit);
          int size = 0;
          int level = 0;
          vector<pair<string, bool>> list;
          while (!q.empty())
          {
               size = q.size();
               for (size_t i = 0; i < size; i++)
               {
                    word_visit = q.front();
                    q.pop();
                    // 单个单词
                    if (word_visit.second)
                         continue;
                    string key = word_visit.first;
                    if (key == endWord)
                    {
                         return level;
                    }
                    else
                    {
                         // 通用单词
                         for (size_t j = 0; i < key.size(); i++)
                         {
                              string comon_word = key;
                              comon_word[j] = '*';
                              list = p_words[comon_word];
                              for (auto word_pair : list)
                              {
                                   q.push(word_pair);
                              }
                         }
                    }
               }
               level++;
          }
          return level;
     }
};

/**
 * 
 * 单向 BFS 
 * 层级遍历
 * while 循环 是
 * 每次取出来一个词, 然后查找 所有该词的 通用状态, 以此找到 单词的change 1 次的 单词总计
 * 然后 取出来 再次按照上面的查询, 只不过 按照是否已经访问来进行剪枝
 * 
*/
class SolutionBFS
{
public:
     int ladderLength(string beginWord, string endWord, vector<string> &wordList)
     {
          if (beginWord == endWord)
               return 1;
          bool flag = true;
          map<string, vector<string>> p_words;
          map<string, bool> records;
          for (auto word : wordList)
          {
               records[word] = false;
               // 字典里面包含结束单词
               if (word == endWord)
               {
                    flag = false;
               }
               for (size_t i = 0; i < word.size(); i++)
               {
                    string c_word = word;
                    c_word[i] = '*';
                    p_words[c_word].push_back(word);
               }
          }
          // 不包含在字典的边界
          if (flag)
               return 0;

          queue<pair<string, int>> q;
          q.push(make_pair(beginWord, 1));
          records[beginWord] = true;
          size_t size = beginWord.size();
          int level = 0;
          pair<string, int> word_visit;
          while (!q.empty())
          {
               word_visit = q.front();
               q.pop();
               string key = word_visit.first;
               level = word_visit.second;
               for (size_t i = 0; i < size; i++)
               {
                    string comon_word = key;
                    comon_word[i] = '*';
                    for (auto word_pair : p_words[comon_word])
                    {
                         if (word_pair == endWord)
                         {
                              return level + 1;
                         }
                         else if (records[word_pair] == false)
                         {
                              records[word_pair] = true;
                              q.push(make_pair(word_pair, level + 1));
                         }
                    }
               }
          }
          return 0;
     }
};

int main(int argc, char **argv)
{

     return -1;
}