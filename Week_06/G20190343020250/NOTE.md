这周主要是对DP，DFS,BFS一系列基本思想的延申
比如Trie树我认为就是树结合上结构存储的一种应用
对于这颗树的遍历方式同样是不断地递归到下一层进行处理，只是将树的信息用一系列对应a-z字符的数组作为节点，通过访问数组里的字符对应的数组的状态来判断是否存在这个字符
通过一次创建使其可以查找，进而形成字典树。

另外的高级搜索中涉及到的操作
比如剪枝，我觉得与记忆型递归有一点联系，同时也是对每一个节点的状态进行判断分析后加速的搜索思想。

本周是对前几周的一次拓展和综合，从课程上设计来说切实的让我感觉到算法训练营的课程设计十分合理，让我对继续跟着老师好好走下去充满信心和期待
在这里的代码总结就把之前的模板再抄一边吧！

def dfs(node, visited):
    if node in visited :
    return

    visited.add(node) #将访问过了的节点放入访问后的set备查

    #process current node here.
    #做处理，每一层的动作。
    for next_node in node.children(); #遍历接下去的子节点
        if next_node not in visited:
        dfs(next_node,visited)  #对所有没有访问的子节点继续访问处理


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
    有点像二叉树的层次遍历?以前貌似见过..
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