### 分治算法

模版
不断将问题拆解为更小的问题进行求解，再对结果进行合并的过程
分治和递归一样，关键是找到递推公式，然后能够判断出终结条件，当然，相对于递归，分治还需要考虑合并问题

```
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  //结束边界
  if problem is None: 
	print_result 
	return 

  //处理当前逻辑
  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
 //问题下探
  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
 //聚合数据
  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
  
  //返回当前状态
  # revert the current level states
```

没有理解分治、回溯的本质。
求开方的题目没有练习，需要补充。

### 深度优先和广度优先

#### 深度优先搜索 DFS
当前是基于二叉树的结构上理解，深度优先搜索是一条道走到黑，直到尽头才退回上个分叉口，在走到黑，以此走完所有路径
#### 广度优先搜索 BFS
广度优先搜索，逐层遍历，遍历完一层才深入下一层搜索


```
递归写法
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

```
非递归写法
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
这部分的题缺少练习，岛屿数量的题目后续需要补充


### 贪心算法

贪心算法的常用思路，正面贪心、反向贪心。


### 二分法

```
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```