学习笔记

# 分治、回溯
分治(Divide & Conquer)和回溯(Backtracking)本质上就是一种 特殊的或者复杂的 递归

回溯法采用试错的思想,不断地在每一层去试(典型:八皇后)

遇到一个问题就找重复性,重复性包括 最近的重复性和最优重复性(动态规划)

```
//Python 代码模板  泛型递归
def recursion(level,param1,param2,..):
    #recursion terminator
    if level>MAAX_LEVEL:
    process_result
    return
    
    #process logic incurrent level
    process(level,data...)
    
    #drill down
    self:recursion(level+1,p1,...)
    
    
    
    
    
//分治代码模板(得到子结果,最终把结果在组和在一起)
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






# 深度优先搜索、广度优先搜索

## 搜索 - 遍历
~~~
·每个节点都要访问一次
·每个节点仅仅要访问一次
·对于节点的访问顺序不限
 -深度优先:depth first search
 -广度优先:breadth first search
~~~

## 深度优先
不会等一个循环走完,就会马上扩到新的一层
~~~
//-------------DFS 代码模板----------------
//递归写法

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
			
			
//非递归写法
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
~~~

## 广度优先
广度优先就不再是用递归,也不再用栈,而是用队列

~~~
//BFS 代码模板

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
	
~~~



# 贪心算法 Greedy
## 概念:
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有利)的选择,从而希望导致结果是全局最好或最优的算法。

## 贪心与动态规划的不同点:
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择,不能回退。
动态规划则会保存以前的运算结果,并根据以前的结果对当前进行选择,有回退功能。

~~~
贪心:当下做局部最优判断
回溯:能够回退
动态规划:最优判断 + 回退
~~~

## 贪心算法的特性
贪心算法可以解决一些最优化问题,如:求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题,贪心法一般不能得到我们所要求的答案。

一旦一个问题可以通过贪心法来解决,那么贪心法一般是解决这个问题的最后办法。
由于贪心算法的高效性以及其所求得答案比较接近最优结果,贪心算法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。


## 适用贪心算法的场景
简单的说,问题能够分解成子问题来解决,子问题的最优解能递推到最终问题的的最优解。这种子问题最优解称为最优子结构。


## 思考
贪心算法难点在于怎么证明可以用贪心得到最优解



# 0311 二分查找
## 二分查找前提条件

1、目标函数单调性(单调递增或递减,即为有序的)
2、存在上下界(bounded)
3、能够通过索引访问(index accessible)


~~~
//二分查找代码模板
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

~~~

# LeetCode-55-0164 跳跃游戏 (贪心算法)
看了老师的视频讲解的,贪心算法首先要证明是不是最优解
有时候问题需要转化一下,有时候从前往后、有时候从后往前

刚好碰到这道题,想到了从后往前的思路,问题可以得到解决
~~~
class Solution {

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums) {
        //贪心算法，从后往前的方式
        $last_pos = count($nums) - 1;
        for ($i=count($nums) - 1;$i >= 0;$i--) {
            if ($nums[$i] + $i >= $last_pos) {
                $last_pos = $i;
            }
        }
        //return $last_pos == 0 ? true : false;
        return $last_pos == 0;//看到题解中的这种方式用时更少
    }
}
~~~

# LeetCode-33-0164 搜索旋转排序数组 (二分查找)
二分查找理解起来好像很简单,但是实际写的时候却一时不知道如何下手
想要写一个没有bug的二分查找果然很难
~~~
1. 循环退出条件
    注意是 low<=high，而不是 low
2.mid 的取值
    mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。改进的方法是将 mid 的计算方式写成 low+(high-low)/2。
    如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多。
3.low 和 high 的更新
    low=mid+1，high=mid-1。注意这里的 +1 和 -1，如果直接写成 low=mid 或者 high=mid，就可能会发生死循环
~~~
递归方式和非递归方式都可实现二分查找
~~~
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        if (count($nums) == 0) return -1;
        if (count($nums) == 1) return $nums[0] == $target ? 0 : -1;
        //递归
        return $this->searchRecursion($nums, 0, count($nums) - 1, $target);
        //非递归方式实现
        $low = 0;
        $high = count($nums) - 1;
        while ($low <= $high) {
            $mid = floor($low +  (($high - $low)>>1));//防止两数相加超过限制,除以2使用位运算更快
            if ($nums[$mid] == $target) return $mid;
            if ($nums[$low] <= $nums[$mid]) {
                //前半段有序
                if ($target < $nums[$mid] && $target >= $nums[$low]) {
                    $high = $mid - 1;
                } else {
                    $low = $mid + 1;
                }
            } else {
                if ($target > $nums[$mid]  && $target <= $nums[$high]) {
                    $low = $mid + 1;
                } else {
                    $high = $mid - 1;
                }
            }
        }
        return -1;
    }
    
    /**
     * 递归
     */
    function searchRecursion($nums, $low,$high , $target) {
        //终止条件
        if ($low > $high) return -1; 
        
        $mid = $low + (($high - $low) >> 1);
        if ($nums[$mid] == $target) return $mid;
        if ($nums[$low] <= $nums[$mid]) {
            //前半段有序
            if ($target < $nums[$mid] && $target >= $nums[$low]) {
                return $this->searchRecursion($nums, $low, $mid - 1, $target);
            } else {
                return $this->searchRecursion($nums, $mid + 1, $high, $target);
            }
        } else {
            if ($target > $nums[$mid]  && $target <= $nums[$high]) {
                return $this->searchRecursion($nums, $mid+1, $high, $target); 
            } else {
                return $this->searchRecursion($nums, $low, $mid-1, $target); 
            }
        }
    }
}
~~~

# 本周心得体会
这周信息量挺大,有一些没有理解透彻,总感觉听着很简单,一到自己写了就懵了,还有就是看题解的时候,跟用到的算法思想联系不上,比如他这个解法,是用到了分治、回溯、广度优先、深度优先等等,
每次一眼看去都是循环、递归,看来这些算法思想还是需要时间消化体会,马上也要期中考试了,需要回过头来过一遍知识点

