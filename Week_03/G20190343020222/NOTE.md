学习笔记
1. Backtrack
(1) Choice
What choice do we make at each call of the function?
- Recursion expresses decision
(2) Constrains
Where do we stop following a certain path?
(3) Goal
What are we trying to find?
2. 二分查找
(1) 单调 ascending or descending
(2）bounded
(3) index accessible
left = 0;
right = array.length - 1
// condition could be left < right in some cases
while (left <= right) {
    mid = (left + right) / 2
    if (array[mid] === target) {
        break or return result
    } else if (array[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
3. DFS
(1) Recursive
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
(2) stack
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
4. BFS
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
