字典树, 即Trie树, 又称单词查找树或者键树, 是一种树形结构. 典型应用是用于统计和排序大量字符串(但又不仅限于字符串), 
所以经常被搜索引擎用于文本词频统计.
它的优点是: 最大限度的减少无谓的字符串比较, 查询效率比哈希表高.

1. 结点本身不存储完整单词
2. 从根结点到某一结点, 路径上经过的字符连接起来, 为该结点对应的字符串.
3. 每个结点的所有子结点路径所代表的字符都不相同.

Trie树的核心思想是: 以空间换时间.
利用字符串的公共前缀可以降低查询时间的开销以达到提供效率的目的.

并查集
解决 组团和配对问题 Group or not
makeSet(s): 建立一个新的并查集, 其中包含s个单元素集合
unionSet(x, y): 把元素x和y所在的集合合并, 要求x和所在的集合不相交, 如果相交则不合并.
find(x): 找到元素x所在的集合的代表, 该操作也可以用于判断两个元素是否位于同一个集合, 只要将它们各自的代表比较一下就可以了. 
```python
class DisjointSet(object):

    def init(p):
        # for i = 0 .. n: p[i] = i;
        p = [i for i in range(n)]


    def union(self, p, i, j):
        p1 = self.parent(p, i)
        p2 = self.parent(p, j)
        p[p1] = p2


    def parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:  # 路径压缩 ?
            x = i
            i = p[i]
            p[x] = root
        return root
```

DFS
```python 递归
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```
```python 非递归
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

BFS
```python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

初级搜索
1. 朴素搜索
2. 优化方式: 不重复(Fibonacci), 剪枝(生成括号问题)
3. 搜索方向:
DFS: 深度优先搜索
BFS: 广度优先搜索
4. 双向搜索, 启发式搜索

Two-Ended BFS


A* search
```python
def AstarSearch(graph, start, end):
    pq = collections.priority_queue()
    pq.append([start])
    visited.add(start)

    while pq:
        node = pq.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        unvisited = [node for node in nodes if node not in visited]
        pq.push(unvisited)
```

估价函数
启发式函数: h(n), 它用来评价哪些结点最优希望是我们要找的结点, h(n)会返回一个非负整数, 也可以认为是从结点n的目标结点路径的估计成本.
启发式函数是一种告知搜索方向的方法. 它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标.


```python
# preorder
def preorder(self, root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)

# inorder
def inorder(self, root):
    if root:
        self.inorder(self.left)
        self.tranverse_path.append(root.val)
        self.inorder(self.right)

# postorder
def postorder(self, root):
    if root:
        self.postorder(self.left)
        self.postorder(self.right)
        self.tranverse_path(root.val)
```

#### 二叉搜索树
二叉搜索树 又称有序二叉树, 排序二叉树. 是指一棵空树或者具有下列性质的二叉树:
1. 左子树上所有结点的值均小于它的根结点的值
2. 右子树上所有结点的值均大于它的根结点的值
3. 以此类推, 左右子树也分别为二叉搜索树(这里有重复性)

二叉搜索树的中序遍历: 升序排列

保证性能的关键
1. 保证二维维度! 左右子树结点平衡
2. Balanced self-balancing binary search tree 即 平衡二叉树(二三树, AVL树, 红黑树, B树)

如何平衡一颗二叉树?

AVL树
1. Balance Factor (平衡因子)
是它的左子树高度减去它的右子树高度(有时相反). balance factor = {-1, 0, 1}
2. 平衡二叉搜索树
3. 每个结点存 balance factor = {-1, 0, 1}
4. 四种旋转操作.
5. 不足: 结点需要存储额外的信息, 且调整次数频繁.

近似平衡二叉树 调整次数不那么频繁

红黑树
- 红黑树是一种近似平衡二叉树, 它能够保证任何一个结点的左右子树的高度差小于两倍. 具体来说, 红黑树是满足如下条件的二叉搜索树:
1. 每个结点要么是红色, 要么是黑色.
2. 根结点是黑色
3. 每个叶子结点(NIL结点, 空结点)是黑色的
4. 不能有相邻的两个红色结点.
5. 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点

    从根结点到叶子结点的最长的可能路径不多于最短的可能路径的两倍长
