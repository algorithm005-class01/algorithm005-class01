/**
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

LRUCache cache = new LRUCache

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

#include <iostream>
#include <vector>
#include <map>
#include <unordered_map>
#include <list>
using namespace std;
class LRUCache
{
public:
    LRUCache(int capacity)
    {
        this->p_capacity = capacity;
    }

    int get(int key)
    {
        auto it = map.find(key);
        if (it == map.end())
        {
            return -1;
        }
        /// 更新节点到最前面
        // 将节点的值提前保存
        pair<int, int> kv = *map[key];
        // 删除
        cache.erase(map[key]);
        // update list
        cache.push_front(kv);
        // update map
        map[key] = cache.begin();
        return kv.second;
    }

    void put(int key, int value)
    {
        auto it = map.find(key);
        if (it == map.end())
        {
            if (cache.size() == p_capacity)
            {
                // 移除最后的 , end 与back不用
                auto back = cache.back();
                map.erase(back.first);
                // 使用 erase(back) 崩溃
                cache.pop_back();
            }

            cache.push_front(make_pair(key, value));
            map[key] = cache.begin();
            return;
        }
        // remove cache
        cache.erase(map[key]);
        // add cache
        cache.push_front(make_pair(key, value));
        // update map
        map[key] = cache.begin();
    }

private:
    int p_capacity;
    list<pair<int, int>> cache;
    // 放引用, c++中是iterator
    unordered_map<int, list<pair<int, int>>::iterator> map;
};

// 字典 - 双向链表 -
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */