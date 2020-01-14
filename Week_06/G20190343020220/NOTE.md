学习笔记

## 学习总结

### Trie总结

insert时间复杂度分析  put方法是数组指定下标i赋值操作O(1)的. 所以时间复杂度和字符串长度m相关. 也就是O(m)  空间复杂度 O(m)
search时间复杂度分析  get方法依旧是O(1)的, 所以时间复杂度依旧和字符串长度m相关. O(m) 空间复杂度O(1)


## leetcode刷题记录

### https://leetcode-cn.com/problems/implement-trie-prefix-tree/ 208. 实现 Trie (前缀树)

实现思路: trie树是一棵多叉树. 二叉树使用left和right表示 左右左子树. 多叉树使用Node[] 数组表示多个子树. 用于题目规定是小写字母. 那么每个节点最多有26个子树.

实现Node节点. 持有一个Node[]数组, 个数为26个. put(char c, Node node)方法, node[c-'a'] = node get(char c)方法 node[c-'a'];

Trie树
1. insert. 遍历word字符串. 取得char 依次判断是否存在在trie树中. 不存在时. 调用put方法 设置数组下表. 然后返回新node. 也就是进入了下一层子树 直到word遍历完成. 设置node节点为end
2. searchPrefix方法 遍历prefix. 取得char c. 当c存在当期node中. 调用node.get(c). 不存在返回null; 
3. search() 通过searchPrefix()方法返回node. 当node!=null && node.isEnd()时. 说明存在. 否则不存在.