本周学习了 Trie、并查集、减枝、双向BFS、启发式搜索、红黑树、AVL树

Trie 字典树
* 将字符串以字符进行树形结构存储，减少相同前缀的字符串集合的存储空间，查找性能 O(n)
* 底层数据结构是多叉树
* 核心思想是用空间换时间
* 优点是，很效率的找出字符串集合的公共前缀，按词典序枚举字符串的数据集

并查集
* 它的发明是为了解决高效查询两个个体是否在同一集合、配对(同一 Group)
* 这个数据结构用于解决上述的特定问题，解决问题时直接套并查集实现的代码模版即可
* 注意在 find function 中实现路径压缩，否则极端情况并查集的效率会退化为一根棍子 O(n)
* 一些视频参考资料
    * UnionFind  https://www.youtube.com/watch?v=0jNmHPfA_yE
    * UnionFInd Path Compress  https://www.youtube.com/watch?v=VHRhJWacxis
    * UnionFind Code https://www.youtube.com/watch?v=KbFlZYCpONw

减枝
* 在实现算法时，提前设置好递归的过滤条件，避免无用的执行

平衡树
* 二叉搜索树在极端情况下，会退化为链表，性能 O(n)，所以产生了 AVL 等平衡树的概念
* 保证性能的关键是:
    * 1.保证二维维度 -> 左右子树平衡(recursively)
    * 2.Balanced
    * 3.https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
* 在每一步插入删除时判断树是否平衡，然后更新维护成平衡状态

4种旋转操作:
*   左旋
* 右旋
* 左右旋
* 右左旋
子树形态:
右右子树 -> 左旋

子树形态:
左左子树 -> 右旋

AVL不足: 结点需要存储额外信息，且调整次数频繁
