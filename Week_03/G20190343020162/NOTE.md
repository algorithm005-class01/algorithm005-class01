## 本周学到什么？

### 分治法
分治就是一种特殊的递归，与递归的不同就是最后的分治是需要把子结果组合

分治代码的模板:
```
def divide_conquer(problem, param1, param2, ...):
    # recurtion terminator      
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
    ...
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)
```

### 回溯
回溯也是一种特殊的递归，其实回溯的思想就是在解决问题的过程中如果发现现有的分步答案不能得到有效正确的解答的时候，将取消上一步甚至是上几步的运算，然后再重新尝试寻找问题的答案

回溯会出现的两种情况:
* 找到一个可能存在的正确答案
* 在尝试了所有可能的分步方法后宣告该问题没有答案

## 深度优先与广度优先遍历
### 二叉树的数据结构
```
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
```

### 遍历的定义:
* 每个节点都要访问一次
* 每个节点仅仅要访问一次
* 对于节点的访问顺序不限
- 深度优先: depth first search
- 广度优先: breadth first search

循环的方式如图:
![image](https://user-images.githubusercontent.com/12718716/71552142-b06e3c80-2a31-11ea-95c1-59d129c56380.png)
### 深度优先示例代码（递归写法）
```
visited = set()
def dfs(node, visited):
    if node in visited: # terminator
        # already visited   
        return
    visited.add(node)
    # process current node herre
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```
### 广度优先示例代码
```
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    
    # other processing work
```

##  贪心算法

### 定义
就是每一步选择中都采取在当前状态下最好或最优的选择，从而导致结果是全局最好或最优的算法。贪心算法与动态规划的区别就是动态规划有回退的功能。

### 适用贪心算法的场景
问题可以分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优解子结构。

## 二分查找
找边界，划分去查找

### 二分查找的前提
1. 目标函数单调性 (单调递增或者递减)
2. 存在上下界 (bouned)
3. 能够通过索引访问 (index accessible)

### 代码模板

left， right= 0， len(array)-1
while left <= right:
 mid = (left + right)/2
 if array[mid] == target:
    # find the target!!
    break or return result 
 elif array[mid] < target:
    left = mid + 1
 else： 
    right= mid - 1 

## 心得体会
说实话从这周开始，感觉讲的东西有点难度了已经，一些地方已经看不懂了，下一周是考试周，需要一些时间看一下别的材料去理解这些知识

