## 本周学习了 Hash Map 相关的概念、树的遍历方式、递归
#### Hash Map 总结
HashMap 存在的意义是增强查询数据的效率，它是通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度

它是由多个 (key, value) 键值对组成的集合，使用时通过 key 来访问 value.

它有两个关键部分 Hash Function(算出存储位置索引)、Hash Table(实际的存储结构)

Hash Table 可使用数组来实现

Hash Function 用来算出 key 的 hash 值

通过 Hash Function 计算出 key 在 Hash Table 的 index, 进而进行数据的访问

Key 的值在进行 Hash 计算时，有可能会发生与其他 Key 所算出来的值重复(此情况称为 Hash 碰撞)，这时候对于 Hash 碰撞 的数据，我们使用链表来存储

通过链表存储 Hash 碰撞 的元素们时，会导致一个问题，当查询这样的数据时，需要遍历链表，来找到指定的数据，这一部分的复杂度是 O(n), 极端情况下，如果 Hash Map 存储的大多数数据都存在 Hash 碰撞问题，此 Hash Map 将会退化为链表，查询性能会退化为 O(n)，而不是 O(1)

如何减小 Hash 碰撞的几率? 可以增强 Hash Function 的实现，并且增大 Hash Table 的存储容量

#### 树 Tree
- 一棵树从 Root Node  开始, 它可能拥有 0个 或 多个 Child Node.
- 如果一棵树有 Left Child Node 或 Right Child Node，那么这样的树叫二叉树
- 如果一棵树有多个 Child Node, 那么这样的树叫 多叉树
- 如果一棵树的 Child Node 存在环, 那么我们称这棵树为 图(Graph)
树和图的区别:
**树没有环 Child Node 有环的情况称为图**
树的意义:
**普通的没有任何状态的树，查找节点需要遍历整棵树, 一般来说我们会把树变得有序，这样才有树存在的意义，否则就跟普通链表一样了**

#### 二叉查找树 Binary Search Tree
如果一个二叉树的节点遵循以下规则，那么它就是二叉搜索树
- Root Node 可以为 null (这种情况不能再有子节点，因为是棵空树)
- Root Node 大于 Left Node 而小于 Right Node
- 以此类推, 整棵树的左右子节点都分别为二叉查找树

#### 二叉搜索树的遍历方式 Traversal
基于遍历节点的顺序，分为以下三种遍历方式
- preorder(`前`序遍历): 顺序为 `Root Node`  -> Left Node -> Right Node
- inorder(`中`序遍历): 顺序为  Left Node -> `Root Node`  -> Right Node
    - 中序遍历的结果有 **从小到大的特性**, 我们可以利用此特性实现一些需要有序遍历二叉搜索树的算法
- postorder(`后`序遍历): 顺序为 Left Node  -> Right Node -> `Root Node`
**巧记二叉树遍历方式的遍历顺序**
- 前中后序排序，前中后指的是 Root Node 的访问次序, 然后就是从左至右, 上文已标记 Root Node 颜色

#### 递归 Recursion
四部曲
- terminator
- process logic in current level
- drill down
- reverse the current level status if necessary
