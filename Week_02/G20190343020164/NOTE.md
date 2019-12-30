学习笔记

本周的学习目标:
1、哈希表、映射、集合的实现与特性
2、树、二叉树、二叉树搜索树
3、泛型递归、树的递归

# 哈希表、映射、集合
哈希表(Hash table),也叫散列表,是根据关键码值(key value)而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来访问记录,以加快查询的速度。
这个映射函数叫散列函数(Hash Function) ,存放记录的数组叫哈希表(或散列表)

正常情况下:查询、添加、删除,时间复杂度为O(1)

在实际运用中,就不再是哈希表了,而是在哈希表上抽象出来的,使用比较多的就是map和set

map:key-value ,key 不重复的
set: 不重复元素的集合


# 图 Graph

Linked List 链表是特殊化的树
Tree 是特殊化的Graph

# 树 Tree
形成了环,就不能成为树
没有环的图就是树

# 二叉树 Binary Tree

只有左子树和右子树

#### 二叉树的遍历

1、前序(Pre-order):根-左-右
2、中序(In-order):左-根-右
3、后序(Post-order):左-右-根

# 二叉搜索树 Binary Search Tree

二叉搜索树,也称二叉搜索树、有序二叉树(Ordered Binary Tree)、排序二叉树(Sorted Binary Tree),
是指一颗空树或者具有下列性质的二叉树:
1、左子树上 所有结点 的值均小于它的根节点的值;
2、右子树上 所有结点 的值均大于它的根节点的值;
3、以此类推:左、右子树也分别为二叉查找树。(这就是重复性!)

中序遍历:升序排列

常见操作:   查询和操作的话都是logn的
1、查询
2、插入新结点(创建)
3、删除


树的面试题解法一般都是递归
1、节点的定义
2、重复性(自相似性)


# 泛型递归、树的递归
### 特点
循环,通过函数体调用自己进行的循环

### 思维要点
1、不要人肉进行递归(最大的误区)
2、找到最近最简方法,将其拆解成可重复的问题(重复子问题)
3、数学归纳法

### 递归总结四部分

1、Recursion Terminator递归终止条件,否则会变成死递归
2、current level logic处理当前层逻辑
3、drill down进入到下一层
4、reverse如果递归完了,清理当前层(比如全局变量等)

#### 注意:

1、要有level(主角)和其他参数(团队)
//terminator
//process
//drill down
//reverse states




# 做题四件套
1、clarification--跟面试官把题过一遍明确清楚
2、possible solutions --> optimal (time & space) --从中找到最优的,时间和空间的复杂度是最好的
3、code -- 写代码
4、test cases -- 测试样例的阐述


# 作业案例

## 有效的字母异位词  LeetCode-242-0164
根据解题四件套:现弄明白题意,异位词就是两个字符串,组成是一样的,顺序不一样
1、显示思考的暴力解法
分隔字符为数组,数组排序,在合并为字符,比较是否相等
```
function isAnagram($s, $t) {
    $arr_s = str_split($s);
    $arr_t = str_split($t);
    asort($arr_s);
    asort($arr_t);
    $str_s = implode('',$arr_s);
    $str_t = implode('',$arr_t);
    return $str_s == $str_t ? true : false;
}
```

后台来了其他同学的解法,优化了一下,还是函数了解的少了
```
function isAnagram($s, $t) {
    if (strlen($s) != strlen($t)) {
        return false;
    }
    return array_count_values(str_split($s)) == array_count_values(str_split($t)) ? true : false;

}
```


## 括号生成  LeetCode-22-0164 & 二叉树的中序遍历 LeetCode-94-0164

```
    //根据老师视频讲解思路一步一步优化  
    public $arrayList = [];

    /**
     * @param Integer $n
     * @return String[]
     * ------------------------------------------------
     * ()    对于递归,一开始就进入了人肉递归,困扰了好几天
     * left 随便加 只要不超标
     * right 只能加到left之后 即 left>right
     * ------------------------------------------------
     */
    function generateParenthesis($n) {
        //共2n个地方,优化后,左右控制分开,所以共$n即可
        $this->helper(0,0,$n,"");
        return $this->arrayList;

    }
    function helper($left,$right,$n,$s) {
        if ($left == $n && $right == $n) {
            $this->arrayList[] = $s;
            return ;
        }
        if ($left < $n) $this->helper($left +1,$right,$n,$s . "(");
        if ($left > $right) $this->helper($left,$right +1,$n,$s . ")");
    }
```
# 本周收获
一开始就进入了人肉递归,钻了牛角尖,一直困扰了好几天,没有想清楚具体怎么执行的,
突然一觉醒来曼曼的莫名其妙的隐隐约约有点理解了
所以感觉不管什么知识,可以先知其然,在慢慢知其所以然
还有一点就是,之前的题目做过了,还是要经常回过头看看,不然还是会忘,五毒神掌用起来






