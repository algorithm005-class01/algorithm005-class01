### 学习笔记
#### 字典树和并查集
###### 字典树的数据结构
1. 基本结构：字典树，即Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计
2. 优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高
3. 结点内部使用顺序表实现，每个元素存储指向下一个结点的指针
###### 字典树的核心思想
1. Trie树的核心思想是空间换时间
2. 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的
###### 字典树的基本性质
1. 结点本身不存完整单词
2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
3. 每个结点的所有子节点路径代表的字符都不相同
##### 并查集(Disjoint Set)的基本实现、特性和实战题目解析
###### 使用场景
1. 组团、配对问题
2. Group or not?
###### 基本操作
1. makeSet(s)：建立一个新的并查集，其中包含s个单元素集合
2. unionSet(x, y)：把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
3. find(x)：找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了

#### 高级搜索
##### 剪枝的实现和特性
###### 初级搜索
1. 朴素搜索
2. 优化方式
    * 不重复（fibonacci）
    * 剪枝（生成括号问题）
3. 搜索方向
    * DFS：depth first search 深度优先搜索
    * BFS：breadth first search 广度优先搜索
    * 双向搜索、启发式搜索
4. 一旦涉及到搜索问题，要联想到状态树，采用数形结合的方式来理解
###### 剪枝
1. 所谓的剪枝，就是对状态树进行处理时，去除重复的分支，或者是比较差的、次优的分支
2. 剪枝示例：fibonacci，对重复分支可以采用缓存方式剪枝
2. 棋盘：如深蓝vs卡斯帕罗夫、三子棋、五子棋等
##### 双向BFS的实现、特性和题解
1. 从起始点和目标点双向开始BFS，当两个搜索有结点重合时，即为最短路径，左搜索和右搜索通过的结点数加在一起即为总结点路径
##### 启发式搜索(A*)  Heuristic Search 
1. 所谓启发式搜索，就是在搜索过程中，通过优先级不断的去找，先对优先级高的进行搜索
2. 估价函数
    * 启发式函数：h(n)，它用来评价哪些结点最有希望是一个我们要找的结点，h(n)会返回一个非负实数，也可以认为是从结点n的目标结点路径的估计成本
    * 启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标

#### 红黑树和AVL树
##### AVL树和红红黑树的实现和特性
###### 树的复习
1. 树Tree的结构
    * Root
    * Parent Node
    * Child Node
    * Siblings
    * Sub-tree
2. 二叉树 Binary Tree
    * 分叉只分两个
3. 二叉树遍历
    * 前序(Pre-order)：根-左-右
    * 中序(In-order)：左-根-右
    * 后序(Post-order)：左-右-根
4. 树的极端情况，如果插入时，没有平衡好，树在极端情况下，会退化为一个链表
5. 保证性能的关键
    * 保证二维维度——>左右子树结点平衡（recursively）
    * Balanced 平衡二叉树
###### 平衡二叉树
1. 平衡二叉树有很多，不仅仅是红黑树和AVL树
2. 本次课程需要掌握的平衡二叉树有：
    * 2-3 tree
    * AVL tree
    * B-tree
    * Red-black tree
    * Splay tree
    * Treap
3. 每次插入时，都会判断当时二叉树是否平衡，并维护平衡
###### AVL树
1. 发明者G.M.Adelson-Velsky和Evgenii Landis
2. Balance Factor（平衡因子）
    * 是它的左子树的高度减去它的右子树的高度（有时相反）
    * balance factor = {-1, 0, 1}
    * 通过旋转操作来进行平衡（四种）
    * 由来：树查询的时间复杂度是等于树的深度的，所以它会记录深度差
3. 旋转操作
    * 左旋
    * 右旋
    * 左右旋
    * 右左旋
4. AVL总结
    * AVL是平衡二叉树
    * 每个结点存储balance factor = {-1, 0, 1}
    * 有四种旋转操作
    * 不足：结点需要存储额外的信息、且调整次数频繁
###### 红黑树 Red-black Tree
1. 红黑树是一种**近似平衡**的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的**高度差小于两倍**。具体来说，红黑树是满足如下条件的二叉搜索树：
    * 每个结点要么是红色，要么是黑色
    * 根节点是黑色
    * 每个叶结点（NIL结点，空结点）是黑色的
    * 不能有相邻接的两个红色结点
    * 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点
2. 关键性质
    * 从根到叶子的最长的可能路劲不多于最短的可能路径的两倍长
###### AVL和红黑树的对比
1. AVL trees provide **faster lookups** than Red Black Trees because they are **more strictly balanced**.(AVL树在查询上比红黑树性能更好，因为AVL树更平衡)
2. Red Black Trees provide **faster insertion and removal** operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.(红黑树在插入删除上比AVL性能好，它不需要频繁的进行调整)
3. AVL trees store balance **factors or heights** with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.(AVL要存储的factor、height等信息更多一点，需要更多的内存存储额外信息。红黑树要存储额外信息非常少，只需要一个bit来存储0和1表示黑或者红)
4. Red Black Trees are used in most of the **language libraries like map, multimap, multisetin C++** whereas AVL trees are used in **databases** where faster retrievals are required.(如果在查询操作多，增删操作较少的情况下，使用AVL；但如果增删操作也不少，或者是查询与增删一半一半的情况，则用红黑树)
