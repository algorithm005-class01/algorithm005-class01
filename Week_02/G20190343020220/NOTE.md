学习笔记


## 第二周学习总结

### hashmap源码分析

经典哈希表结构. 数组+单链表. 
jdk的优化是 为了解决链表太长导致查询退化的情况. 当链表长度超过阈值的时候, 进入红黑树

#### 为什么数组桶的长度要是2的次幂
因为哈希表的性能由两个地方决定. 1. hash函数的执行效率. 2.哈希函数是否均匀(减少冲突)

1. 为了提高哈希函数的执行效率 将%运算换从了&运算. 剩下的就是解决减少碰撞的问题. 在减少碰撞的问题是. 

在java jdk不会直接使用hashcode, 而是
```java
 static final int hash(object key) {
         int h;
         return (key == null) ? 0 : (h = key.hashcode()) ^ (h >>> 16);
     }

```
加入了扰动函数. int是32位. 高16位和低16位进行异或运算(相同为0, 不同为1). 得到key在和 key & n-1运算. 这样使得key的哈希值的32位数全部参数了运算. 减少哈希冲突的可能性. 另外还增加了红黑树结构.
即便是在碰撞严重的情况, 依旧能够保证o(logn)的时间复杂度.  而且顺便还解决了一个安全问题.

dos攻击, 就是针对哈希表的链表的攻击. 如果恶意程序知道我们用的是hash算法，则在纯链表情况下，它能够发送大量请求导致哈希碰撞，然后不停访问这些key导致hashmap忙于进行线性查找，最终陷入瘫痪，即形成了拒绝服务攻击（dos）。
由于红黑树的存在. 这种问题就会好很对. 但是还是无法解决内存资源耗尽的问题. 

2. 关于n  2的次幂的二进制的规律是只有一个位置为1. 其他的位置都是0 比如2(0010) 4(0100) 8(1000), 1(0001) 3(0011) 7(0111)

&运算 是1&1=1 0&1=0 1&0=0 0&0=0; 

所以key & n-1. 低位的1就是起决定性作用的. 当n=8时 保证了算出来的桶位置index. 在0到7的范围内的.

3. 扩容. 扩容也是减少哈希碰撞的方式, jdk的默认负载因子为0.75. 当大于阈值的时. 扩容为原数组长度的2被. 比如数组长度为16, 16*0.75=12. 也就是说, 哈希表中元素个数>=12时, 就会触扩容. 将16 << 1 = 32;

扩容说白了就是对hash表中的所有元素重新key & n-1计算桶索引i. 但是这个计算是有规律的. 我们发现.每次扩容一倍在结合桶长度为2的次幂. 会出现.扩容的后元素的位置.

对于n-1来说, 就是高位增加了1位 为1. 比如从16(0001 0000)扩容到32(0010 0000). n-1的变化时从15(0000 1111)到31(0001 1111). 
![20191216135806.png](https://ten951-img.oss-cn-shanghai.aliyuncs.com/20191216135806.png)

会出现一个规律. 原索引的高位如果是0 那么扩容后的索引位置没变. 如果高位是1. 那么新索引的位置为oldi+oldCap. 

通过这种方式, 减少了哈希表扩容时的哈希计算问题. 又增加了效率.

#### putval方法



jdk1.8的put方法执行流程是: 
1. 查看桶table是否为空,  如果为空 则初始化桶.
2. 桶不为空. 通过hash & (n-1) 计算桶索引位置i.  判断i是否为null.  如果为null. 说明没有冲突. new node()直接添加.
3. 当i位置, 也就是桶的位置不为null的时候.  说明存在hash冲突. 拿到链表p. 判定p.key和新添加的e.key是否相等. 相等说明链表头的位置就是目标位置. 直接替换
4. 发现链表p的key和要添加的key不相等. 说明链表要遍历这个链表了. 先判断这个链表是不是红黑树. 如果是红黑树 .调用红黑树的put方法
5. 发现不是红黑树. 说明有两种情况. 1. 新key可能在链表中的某个位置. 2 key不存在链表中, 要新加到末尾. 这两种都需要遍历链表. 在途中判定是否和新key相同. 相同替换. 没找到在将新key包装成node添加到链表末尾. 添加完成后. 查看链表长度是否>=7.大于转成红黑树.
6. 判定数组的长度是否>阈值. 大于就会扩容. 这也是减少冲突的一种方案.

#### get方法

1. 数组不为空 && 数组长度n>0 && table[hash & (n-1)] != null. 经过这些判定. 确定key在哈希表中存在. 
2. key在表存在. 判定桶i的位置p链表 是否和当期要查找的key相同.  相同就是要找的, 直接返回
3. 不相同. 判定是否为红黑树.  是 调用红黑树的find方法
4. 不是红黑树. 遍历链表. 从头向后比遍历. 知道到key相同的. 则返回
5. 其他任何情况都返回null. 



 ## leetcode刷题
 
 ### https://leetcode-cn.com/problems/valid-anagram/submissions/ 是否为异位词
 
 解题思路: 映射表
 当字符串s和t 长度不相等时. false
 
 构建一个26个字母的int数组, 遍历其中一个字符串的.  因为都是小写字母. 所以当一个小写的char-'a' 就会得到这些字母对于的ASCII码值. 当任何一个位置!=0时, 返回false
 
 时间复杂度: O(n) 
 空间复杂度: O(1) 因为固定26个大小的数组
 
 ### https://leetcode-cn.com/problems/group-anagrams/submissions/ 49 字母异位词分组 
 
 解题思路: 哈希表
 
遍历整个异位词数组. 对异位词s,进行排序得到news, 所有的异位词排序后都相等. 借助哈希表, 当news不在哈希表中, 构建一个list. 将news和list添加到哈希表中. 当news在哈希表中. 取出list,将s添加到list中.

循环结束. 异位词分组就完成了
 
 ### https://leetcode-cn.com/problems/two-sum/
 
 解题思路: 哈希表
 
 遍历数组, 计算每个元素s和target的差. 判定差值是否在map中, 存在那么当前的下标i和map中存在的下j, 相加=target的组合,  不存在将元素s当k, v为下标 添加到哈希表中
 
 ### https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ 94 二叉树的中序遍历
 
 解题思路: 递归方式   经典的左根右. 递归向树的左走, 直到为left为null,  时间复杂度 O(n), 空间复杂度 O(logn)
 
 解题思路: 借助栈的方式 创建栈空间. 遍历栈元素和当期树. 一直向树的左子树遍历. 沿途所有的节点依次加入栈中.直到找到最左叶子节点. 
 弹出叶子节点. 打印这个叶子节点. 当期树向右前进.
 
  时间复杂度 O(n)  空间复杂度 O(n)
 
 解题思路: 莫里斯遍历法  按照中序遍历顺序构建线索树
 
 取得树的root节点curr. 
 如果curr.left == null 打印curr.val. curr = curr.right;
 curr.left != null. pre = curr.left, 找打pre中最右的节点. 为pre.right. 将 pre.right = curr;
 将curr赋值为temp. 将curr = curr.left; 
 
 直到curr == null;
 
 时间复杂度 O(n)  空间复杂度 O(n)
 
 ### https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ 二叉树的前序遍历
 
 解题思路: 递归解法. 根左右.  时间复杂度 O(n)  空间负责度 O(logn)
 解题思路: 利用栈遍历. 先将root添加到栈中. 遍历stack直到为null. 弹出栈顶元素. 如果right != null 将right压入栈. 如果left!=null 将left压入栈.  先压right后left
 时间复杂度 O(n)  空间复杂度 O(n)  栈空间
 解题思路: 莫里斯遍历.  构建线索树 
 
 ### https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/ N叉树的后序遍历
 
 解题思路: 递归法, 左右根. 注意避免使用全局变量的使用.  从左到右顺序依次递归树的孩子树, 最后打印根节点
 
  
 ### https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/ N叉树的前序遍历
 
 解题思路: 递归法. 根,孩子节点从左到右依次遍历
 
 
 ### https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ N叉树的层序遍历
 
 解题思路: 队列遍历法. 广度优先算法. 
 
 
 ### https://leetcode-cn.com/problems/symmetric-tree/submissions/ 236 二叉树的最近公共祖先
 
 解题思路: 递归法.  
 
 边界条件: root ==null, 或者找到p或者q. 也就是root分别和他们想等.
 进行式 :  分别向root.left和root.right进行 如果分别能够找到p和q. 那么说明在p和q在分别左右子树上. root就是最近公共祖先. 否则一方为null, 另一方既是.
 
 时间复杂度 O(N) 因为要遍历完整个树
 空间复杂度 O(N) 
 
 ### https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ 105. 从前序与中序遍历序列构造二叉树
 
 解题思路: 递归法  分别构建left 和 right 子树.
 
依据前序遍历, 很容易找到树的root 节点. 
root左子树的结束就是在中序中扎到了自己. 
root 右子树的结束就在于pre集合遍历完成. 

依赖pre和in两个指针, 分别标记集合的遍历.

### https://leetcode-cn.com/problems/combinations/submissions/ 77 组合

解题思路: 递归法.
例如 n=4 k=2;
1,2,3,4. 枚举 两两组合

从1开始枚举. 用列表 temp 收集枚举信息. 当temp.size() == k 的时候说明枚举完成, 


### https://leetcode-cn.com/problems/permutations/ 46 全排列

解题思路: 递归 + 回溯 + 枝剪

从数组第一个元素到最后一个元素遍历. 递归枚举不通的组合. 当收集的集合中存在当期元素时. 跳过这次循环
当没有得到解时, 删除以后一个元素. 继续递归求解. 
当收集的数量等于数组长度时. 将解添加到res中. 

### https://leetcode-cn.com/problems/permutations-ii/ 47 全排列 2

解题思路: 递归 回溯 枝剪

先对数组进行排序, 便于判定重复元素,  例如 [1,1,2]
递归枚举所有排序组合, 在递归过程中去掉 已经排列过的数字. 

 
 
 