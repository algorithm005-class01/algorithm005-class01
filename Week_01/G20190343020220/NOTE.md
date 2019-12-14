学习笔记

## leetcode刷题解题总结

### https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ 去除重复元素

双指针解法:  慢指针i标识不重复元素的位置. j指针依次遍历. 

当i和j元素不相等时. i前进1. 并且将i和j的元素交互位置. 

时间复杂度: O(N)
空间复杂度: O(1)

### https://leetcode-cn.com/problems/rotate-array/ 反转数组

选择数组: 先将整个数组反转. 然后选择0到k-1的前半部分. 在旋转k到nums.length-1的后半部.

这样就得到了选择k个元素的目的.

时间复杂度: o(n) 因为最慢的0到nums.length-1次反转. 是O(n)
空间负责度: o(1)

### https://leetcode-cn.com/problems/merge-two-sorted-lists/ 合并两个有序链表

dump头结点解法: 设置一个dump节点. 动态的改变dump.next指针. 直到l1和l2遍历完成.


时间负责度: o(n+m) 因为每次迭代中都有一个node添加到dump链表中. while循环遍历完成l1和l2的总长度. 改变指针的操作是常数级别的. 所以是线性的
空间负责度: o(1) 是恒定不变的.

### https://leetcode-cn.com/problems/merge-sorted-array/ 合并两个有序数组

解题思路: 双指针方法

p1 数组1中非零的最后一个位置  p2 数组2中非零的最后一个位置. 因为num1[]数组的有足够的空间容纳nums2  p代表最后的位置

比较p1位置和p2位置元素的大小. 将大的元素放在p的位置上. 然后p--. 如果如果p2的大. p2-- 反之 p1--

当p1和p2都<0的时候. num1 就是有序的数组了. 

当两个数组都只有1个元素的时候. 那么nums1[]{0}. nums2[]{2} ,这种情况. 我们只需要将. nums2直接复制到num1里就可以了.

时间复杂度: O(n+m) n和m代表两个的长度. 
空间复杂度: O(1) 

### https://leetcode-cn.com/problems/two-sum/  两数相加

解题思路: 散列表

借助散列表保存. key为数组元素. value为元素的下标. 
循环遍历. 通过target-当期元素 = 差值. 差值就是我们要找的目标元素. 
当发现差值已经在散列表中时. 我们就拿到到了 当期数组的下标i和目标元素的下标 j. 而 nums[i]+nums[j] 是等于 target
差值不再散列表中. 将nums[i]添加到散列表中. 

时间复杂度: 散列表的插入在最坏的情况下 时间复杂度是红黑树的插入 0(logn). 要遍历整个数组n. so 整体的时间复杂度为0(n)
空间复杂度: 0(n)

### https://leetcode-cn.com/problems/move-zeroes/ 移动0

解题思路: 双指针

指针j表示元素为0的位置. 指针i从1开始向后遍历. 当遇到j != 0 的情况.  j++ 继续下次循环  当遇到i!=0的情况. 将i位置的元素赋值给j位置. i位置赋值为0 . j++

当循环结束. 完成

时间复杂度: O(n) 一次循环解决问题
空间复杂度: O(1) 

### https://leetcode-cn.com/problems/plus-one/ 加1

解题思路: 

考虑9+1的问题就可以了. 

从数组最后一位向前遍历. 当遇到<9的情况直接++ 返回即可. >=9的情况. i位置赋值为0

对于119的情况. 第一次循环110. 第二层循环 120 return. 

对于999这种情况. dis数组会变成000. 并不符合要求.  只需要新创建一个长度+1的数组. 0位置赋值为1. 其他位置都是0即可. 



### https://leetcode-cn.com/problems/design-circular-deque/ 设计双端队列

解题思路: 环形数组实现双端队列

保证数组的大小是按照2的次幂扩容的. 这样length-1可以充当掩码使用. 例如 -1 & 7 = 7; 0 & 7 = 0 ; 8 & 7 = 0;

一次能够保证tail和head指针能够循环.

addLast  是往数组头的位置添加元素 tail指针+1. 
addFirst 是往数组末尾添加一个元素, head指针前移. 

deleteFirst. 删除数组head的元素即可.  更新head指针, 可以理解为head指针+1
deleteLast. 删除tail指针位置的元素即可 更新tail指针, 可以理解为tail-1;

tail指针是last数组的末尾  head指针是first数组的

addF和delateF 或者 addL和deleteL 是栈模式. 

addF和deleteL 或者 addL和deleteF 是队列模式

在任何时候 head和tail指针相遇的时候, 说明数组满了. 我们需要扩容. 扩容为原数组的2被. 

### https://leetcode-cn.com/problems/trapping-rain-water/ 接雨水

解题思路: 左右指针往中间遍历. 找左最大柱子和右最大柱子. 


当left<right高度时 当左指针遇到小于左最大柱子的. 盛水的res加上当期的的雨水容量 = leftMax- height[left]; 反之left++; 

反之是一样的. 

## 用addFirst和addLast改写

```java
Deque<String> deque = new LinkedList<String>();
deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);
String str = deque.peek();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
 System.out.println(deque.pop());
}
System.out.println(deque);
```

改写代码
```java
    System.out.println("--------------------------------------------");

        Deque<String> deque1 = new ArrayDeque<>();
        deque1.addFirst("a");
        deque1.addFirst("b");
        deque1.addFirst("c");
        System.out.println(deque1);
        String s = deque1.peekFirst();
        System.out.println(s);
        System.out.println(deque1);
        while (deque1.size() > 0) {
            System.out.println(deque1.removeFirst());
        }
        System.out.println(deque1);


        System.out.println("--------------------------------------------");

        Deque<String> deque2 = new ArrayDeque<>();
        deque2.addLast("a");
        deque2.addLast("b");
        deque2.addLast("c");
        /*这里打印的顺序是出入的 但是出队和入队的元素是符合队列规范的 主要和实现方式有关.*/
        System.out.println(deque2);
        String s1 = deque2.peekLast();
        System.out.println(s1);
        /*这里打印的顺序是出入的 但是出队和入队的元素是符合队列规范的*/
        System.out.println(deque2);
        while (deque2.size() > 0) {
            System.out.println(deque2.removeLast());
        }
        System.out.println(deque2);
    }
```


## queue和priorityQueue的源码分析

### queue的源码分析

Queue 在java的源码中是个接口. 定义了队列的实现的行为规范. 

实现类中非两类. 
1. 数组实现的  基本上都是基于环形数组的实现的. 
比如ArrayBlockingQueue, 维护两个指针, putIndex和takeIndex. 每次添加元素putIndex++. 当putIndex=数组长度是归零.takeIndex也是同样的道理.
每次出队操作从数组头部开始取数据.然后++. 当takeIndex大小等于数组长度时. 归零. 应为是阻塞队列. 所以不需要扩容操作.  时间复杂度都是o1
2. 链表实现的   LinkedBlockingQueue 基于单链表实现的 入队. 添加到数组尾部. 维护tail的next指针, 更新tail即可. 时间复杂度o1. 出队. 切断head的next指针. 使得head.next成为新的head.

时间复杂度也是o1

### priorityQueue源码分析

优先级队列, 队列中的循序不是基于元素大小的. 而是基于给定的比较函数. 内部实现为堆. 

在java的实现中呢, 原语义呢是按照小顶堆来实现的优先队列, 至于这个小用户怎么去定义. 完全通过实现接口去实现. 比如你想实现一个大顶堆. 那么你只需要将 2 < 1 认为是ture. 那么根上的元素就是最大的.

所以这里的大小是相对. 优先级的定义也是用户自己定义的. Comparable<T>实现这个接口即可. 

堆是一个被完全填满的二叉树,有可能的例外是底层.底层的元素从左到右填入,这样的树称为完全二叉树.

因为完全二叉树这么有规律.所以它可以用一个数组表示而不需要使用链.

对于数组中任一位置i上的元素.其左儿子在位置2i上,右儿子在左儿子后的单元2i+1中.它的父亲则在位置i/2上.

因此优先级最高的元素呢 即在根上, 

入队是将元素添加到数组最后一个位置, 然后上浮. 上浮的意思是依次和父节点比较优先级. 如果新添加的元素.compareTo(parent) >=0 为false. 即交互父子位置. 直到为true.
出队是删除根元素. 然后取数组尾部元素填充到根上, 执行下潜操作. 下潜是 依次和左儿子比较大小 在和右儿子比较大小. 如直到找到合适位置. 

入队和出队时间复杂度是O(logn)的.

