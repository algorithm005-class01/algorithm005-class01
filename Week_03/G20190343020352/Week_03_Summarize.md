递归模板
```python
    def recursion(self, level, param1, param2...):
        if level > MAX_LEVEL:
            process_result()
            return
        
        # process logic in current level
        process(level, data...)

        # drill down
        self.recursion(level + 1, param1, param2)

        # reverse the current level status if needed 
```

分治模板
```python
    def divide_conquer(problem, param1, param2, ...): 
        # recursion terminator 
        if problem is None: 
            print_result 
            return 

        # prepare data 
        data = prepare_data(problem) 
        subproblems = split_problem(problem, data) 

        # conquer subproblems 
        subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
        subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
        subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
        …

        # process and generate the final result 
        result = process_result(subresult1, subresult2, subresult3, …)
            
        # revert the current level states
```



DFS depth first search 
recursion 递归 (二叉树)
```python
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
recursion 递归 (多叉树)
```python
    visited = set()
    def dfs(node, visited):
        if node in visited:
            return 
        visited.add(node)
        ...
        for next_node in node.children():
            if not next_node in visited:
                dfs(next_node, visited)
```

stack traversal 手动维护栈遍历 (not recursion) 
```python
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
```

BFS breadth first search
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

二分查找的前提条件
1. 目标函数单调性(单调递增或者单调递减)
2. 存在上下界(bounded)
3. 能够通过索引访问(index accessible)

二分查找模板
```python
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


使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
```python
    def search(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return None
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                return mid + 1
            if nums[mid - 1] > nums[mid]:
                return mid
            if nums[mid] > nums[0]:
                left = mid + 1
            else:
                right = mid - 1
```

贪心: 当下局部最优判断
动态规划: 最优判断 + 回溯