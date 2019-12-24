### 学习笔记

#### 总结
- 迭代时寻找循环子问题
- 不要忽略思考多种解法以及边界条件，以及要多花点时间看题解
- 题不能只刷一遍，题不能只刷两遍，题不能只刷三遍，真的很容易忘
- 每天都要过一下之前看的内容，不要积攒到周末

####HashMap源码阅读

 - 概述
> 它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。 HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。
 - 存储
> 存储数据使用Node[] table，即哈希桶数组，Node是Map.Entry的实现类，即键值对。
>
> Node[] table的初始化长度length(默认值是16)，Load factor为负载因子(默认值是0.75)，threshold是HashMap所能容纳的最大数据量的Node(键值对)个数。threshold = length * Load factor。
- 计算索引位置
> 计算：通过hashCode()的高16位异或低16位实现的：(h = k.hashCode()) ^ (h >>> 16)，主要是从速度、功效、质量来考虑的，这么做可以在数组table的length比较小的时候，也能保证考虑到高低Bit都参与到Hash的计算中，同时不会有太大的开销。
>
> 取模：通过h & (table.length -1)来得到该对象的保存位，而HashMap底层数组的长度总是2的n次方，这是HashMap在速度上的优化。当length总是2的n次方时，h& (length-1)运算等价于对length取模，也就是h%length，但是&比%具有更高的效率。
- 碰撞
> 先拉链，拉链超过8，优化为红黑树
- 扩容
> 数组扩容为原来的两倍，重新计算hash位置，可以只关注hash值新增bit位，如果为0，则保持原位置，如果为1，则在原位置基础上增加一个原数组的大小。
- <https://tech.meituan.com/2016/06/24/java-hashmap.html>