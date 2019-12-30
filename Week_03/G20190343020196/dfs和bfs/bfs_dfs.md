```python
def BFS(graph, start, end):
    visited = set()
    #队列存每层
    queue = []
    queue.append([start])
    
    while queue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
       
    #other process work
```



```python
#dfs递归写法
visited = set()

def dfs(node, visited):
    if node in visited: #terminator
     	#already visited
      	return
    
    visited.add(node)
    
    #process current node here
    
    for next_node in node.children():
        if next_node not in visited:
            dfs(next_node, visited)
```



```python
#非递归写法
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
```

