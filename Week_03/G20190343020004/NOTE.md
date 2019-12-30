##### 学习笔记
##### 分治
1. 不断将问题拆解为更小的问题进行求解，再对结果进行合并的过程
2. 分治和递归一样，关键是找到递推公式，然后能够判断出终结条件，当然，相对于递归，分治还需要考虑合并问题
3. 分治代码模板
```
    public void divideConquer(int level, int param) {
        //1、recursion terminator
        if (level > MAX_LEVEL) {
            return;
        }
        //2、prepare data
        data = prepareData(level);
        subProblems = splitProblem(problem, data);
        //3、conquer subproblems
        subResult1 = divideConquer(subProblems[0], param);
        subResult2 = divideConquer(subProblems[1], param);
        subResult3 = divideConquer(subProblems[2], param);
        ...
        //4、process and generate the final result
        result = processResult(subResult1, subResult2, subResult3, ...);
        //5、revert the current level states
    }
```
##### 回溯
1. 回溯不大理解，感觉就是逐层尝试，失败则判断当前分支失败，退出进行下一个分支尝试，直到尝试成功或者全部失败无解。
##### 深度优先搜索 DFS
1. 当前是基于二叉树的结构上理解，深度优先搜索是一条道走到黑，直到尽头才退回上个分叉口，在走到黑，以此走完所有路径
##### 广度优先搜索 BFS
1. 广度优先搜索，逐层遍历，遍历完一层才深入下一层搜索
##### 贪心算法
1. 每一步都以当下最优选择执行，希望得到全局较好结果的算法
##### 二分查找
1. 二分查找的前提
    * 数据具备单调性
    * 数据存在上下边界
    * 数据可以通过索引访问
2. 二分查找代码模板
```
    int left = 0;
    int right = arr.length -1;
    int mid;
    while ( left <= right) {
        mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if(arr[mid] < target) {
            left = mid - 1;
        } else {
            right = mid + 1;
        }
    }
```