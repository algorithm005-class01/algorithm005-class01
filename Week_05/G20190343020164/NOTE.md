学习笔记

动态规划这部分内容感觉听完还是稀里糊涂的,听着道理很简单,自己一写就懵逼,
先把课程老师讲的记下来,看看啥时候能顿悟

# 知识回顾
分治+回溯+递归+动态规划

~~~
//递归模板
public function recur($level,$param) {
    //终止条件
    if ($level > $max_level) {
        return ;
    }
    //处理当前逻辑
    proccess($level,$param);
    //进入下一层
    recur($level+1,$param);
    //清理当前层
}


//分治代码模板
public function divide_conquer($problem,$param1,$param2,...) {
    //递归终止条件
    if ($problem == null) {
        print_result;
        return ;
    }
    
    //拆分子问题
    $data = prepare_data(problem);
    $subproblems = split_problem(problem,data);
    
    //调子问题的递归函数
    $subresult1 = divide_comquer($subproblems[0],$p1,...);
    $subresult2 = divide_comquer($subproblems[1],$p1,...);
    $subresult3 = divide_comquer($subproblems[2],$p1,...);
    
    //合并结果
    $result = process_result($subresult1,$subresult2,$result3,...);
    
    //恢复当前层的状态
    
}
~~~


# 感触
1、人肉递归比较低效、很累---------深有感触
2、找到最近最简单方法,将其拆解成可重复解决的问题
3、数学归纳法(抵制人肉递归的诱惑)

本质:寻找重复性

# 动态规划 Dynamic Programming

### 关键点:
动态规划 和 递归 或者 分治  没有本质上的区别(关键看有无最优的子结构) 
共性:找到重复子问题
差异性:最优子结构、中途可以淘汰次优解


# 方法

记忆化搜索(自顶向下) : 加一个缓存,例如:斐波拉切数列:指数值的时间复杂度,变成了线性的时间复杂度O(n)
~~~
//记忆化搜索,自顶向下
public function fib($n,$memo) {
    if ($n <= 1) {
        return $n;
    }
    if ($memo[$n] == 0) {
        $memo[$n] = fib($n - 1) + fib($n - 2);  
    }
    return $memo[$n];
}


//自底向上的方法
public function bottomUp() {
    $a[0] = 0;
    $a[1] = 1;
    for ($i=2;$i<=$n;$i++) {
        $a[$i] = $a[$i - 1] + $a[$i - 2];
    }
    return $a[$n];
}
~~~

# 状态转移方程 (DP方程)
~~~
opt[i,j] = opt[i+1,j] + opt[i,j+1]
完整逻辑:
if a[i,j] = '空地' :
    opt[i,j] = opt[i+1,j] + opt[i,j+1]
else :
    opt[i,j] = 0
~~~

# 动态规划关键点
1、最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
2、储存中间状态 opt[i]
3、递推公式(美其名曰:状态转移方程或者DP方程)
Fib: opt[i] = opt[n-1] + opt[n-2]
二维路径: opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地)



# 动态规划小结
1、打破自己的思维惯性,形成机器思维
2、理解复杂逻辑的关键
3、也是职业进阶的要点要领
