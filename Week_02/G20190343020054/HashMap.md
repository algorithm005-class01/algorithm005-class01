![HashMap 完全解析](https://upload-images.jianshu.io/upload_images/3303429-ed146cf6826ca5d9.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


## 1. 基本特点

HashMap 是 java 中用于映射(键值对)处理的数据类型。基于哈希表的 Map 接口的实现。最多只允许一条记录的键为 null，允许多条记录的值为 null。

HashMap 不保证映射的顺序。特别是，**它不能保证顺序会随着时间的推移保持恒定**。

HashMap 根据键的 hashCode 值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度 O(1)。

## 2. 存储结构

从结构实现来讲，HashMap 是数组+链表+红黑树（JDK1.8增加了红黑树部分）实现的。

[图片上传失败...(image-7d8358-1576498907545)]

### 2.1 HashMap 数据底层具体存储的是什么？

通过查看 HashMap 的源码，它其中有一个非常重要的字段 `Node<K,V>[] table`，即哈希桶数组，是一个Node的数组。

```java
static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;// 用来定位数组索引位置
        final K key;
        V value;
        Node<K,V> next;// 链表的下一个元素

        Node(int hash, K key, V value, Node<K,V> next) {...}

        public final K getKey()        {...}
        public final V getValue()      {...}
        public final String toString() {...}
        public final int hashCode() {...}
        public final V setValue(V newValue) {...}
        public final boolean equals(Object o) {...}
}
```

Node 是 HashMap 中的一个内部类，实现了 Map.Entry 接口，本质是就是一个映射(键值对)。

我们在 HashMap 中存储的每一个值，都是一个 Node。

### 2.2 为什么要用单链表的方式？

哈希表为了解决冲突，一般有两种方式来解决，开放寻址法和链表法。

开放寻址法：如果出现了散列冲突，就重新探测一个空闲位置，将其插入。

链表法：就是数组加链表的结合。在每个数组元素上都一个链表结构，当数据被 Hash 后，得到数组下标，把数据放在对应下标元素的链表上。

[图片上传失败...(image-30a42a-1576498907545)]

即使负载因子和 Hash 算法设计的再合理，也免不了会出现拉链过长的情况，一旦出现拉链过长，则会严重影响 HashMap 的性能。

于是，在 JDK1.8 版本中，HashMap 做了进一步的优化，引入了红黑树。当链表长度太长（默认超过8）时，链表就转换为红黑树，利用红黑树快速增删改查的特点提高HashMap的性能。

## 3. HashMap 的成员变量

HashMap 中的成员变量，除了一些常量外，主要有以下几个。

```java
int size;
int modCount;
final float loadFactor;
int threshold;
```

size 比较简单，就是 HashMap 中包含的映射的总数。

modCount 主要用来记录 HashMap 内部结构发生变化的次数，主要用于迭代的快速失败。强调一点，内部结构发生变化指的是结构发生变化，例如 put 新键值对，但是某个 key 对应的 value 值被覆盖不属于结构变化。

loadFactor 负载因子，默认值是0.75，负载因子越大，说明 map 中的元素越多，空闲位置越少，散列冲突的概率就越大。

threshold 阈值，是 HashMap 所能容纳的最大数据量的 Node (键值对)个数。

算法公式为：`threshold = length * loadFactor`。其中 length 是 Node[] table 的长度(默认 16)。

threshold 就是在此 loadFactor 和 length 对应下允许的最大元素数目，超过这个数目就重新 resize (扩容)，扩容后的 HashMap 容量是之前容量的两倍。

## 4. 确定数组索引位置的 hash 算法

不管是添加、删除还是查找，第一步首先是要确定当前元素在 HashMap 中的位置。

HashMap 中的 hash 采用的是**取 key 的 hashCode 值，然后进行高位运算，再进行取模运算。**

```java
static final int hash(Object key) {
      int h;
      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }
```

### 4.1 为什么要采用这种算法呢？

我们知道，在 HashMap 中采用 hash 为 key，因此我们要尽量避免 hash 碰撞。

上面的代码中，`key.hashCode()`函数调用的是 key 键值类型自带的哈希函数，返回 int 型散列值。

int 值的取值范围在 `-2^31 ~ 2^31 - 1` 之间，大约有 40 亿的空间，如果直接拿散列表的值做数组的所含，虽然很难出现碰撞，但是 40 亿的长度实在是太大了，不太现实。

因此需要对得到的散列值进行进一步的操作处理。

java 8 采用 key.hashCode() 与 hash 值的高 16 位进行异或运算。

> 异或：如果a、b两个值不相同，则异或结果为1。 如果a、b两个值相同，异或结果为0。

为什么这里需要将高位数据移位到低位进行异或运算呢？

这是因为有些数据计算出的哈希值差异**主要在高位**，利用高半区和低半区做异或，就是为了**混合原始哈希码的高位和低位，以此来加大低位的随机性**。混合后的低位掺杂了高位的部分特征，这样高位的信息也被变相保留下来，可以有效避免类似情况下的哈希碰撞。

![image](https://upload-images.jianshu.io/upload_images/3303429-3deceee79eb2805a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 5. 存储数据的 put 方法

HashMap 的 put 方法主要分为以下几步：

①. 判断键值对数组 table[i] 是否为空或为 null，否则执行 resize() 进行扩容；

②. 根据键值 key 计算 hash 值得到插入的数组索引 i，如果 table[i]==null，直接新建节点添加，转向 ⑥，如果 table[i] 不为空，转向③；

③. 判断 table[i] 的首个元素是否和 key 一样，如果相同直接覆盖 value，否则转向④，这里的相同指的是 hashCode 以及 equals；

④. 判断 table[i] 是否为 TreeNode，即 table[i] 是否是红黑树，如果是红黑树，则直接在树中插入键值对，否则转向⑤；

⑤. 遍历 table[i]，判断链表长度是否大于 8，大于 8 的话把链表转换为红黑树，在红黑树中执行插入操作，否则进行链表的插入操作；遍历过程中若发现 key 已经存在直接覆盖 value 即可；

⑥. 插入成功后，判断实际存在的键值对数量 size 是否超多了最大容量 threshold，如果超过，进行扩容。

JDK1.8HashMap的put方法源码如下:

```java
public V put(K key, V value) {
    // 对key的hashCode()做hash
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                boolean evict) {
    Node<K, V>[] tab;
    Node<K, V> p;
    int n, i;
    // 步骤①：tab为空则创建
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // 步骤②：计算index，并对null做处理 
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K, V> e;
        K k;
        // 步骤③：节点key存在，直接覆盖value
        if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
            // 步骤④：判断该链为红黑树
        else if (p instanceof TreeNode)
            e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
            // 步骤⑤：该链为链表
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    链表长度大于8转换为红黑树进行处理
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st  
                        treeifyBin(tab, hash);
                    break;
                }
                key已经存在直接覆盖value
                if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }

        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }

    ++modCount;
    // 步骤⑥：超过最大容量 就扩容
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

在 put 时，会通过 `(n-1) & hash` 来计算当前元素的坐标索引。

---

#### 番外： 为什么用 & 操作呢？

主要是用来取模。

位运算(&)效率要比取模运算(%)高很多，主要原因是位运算直接对内存数据进行操作，不需要转成十进制，因此处理速度非常快。

#### 为什么可以使用位运算(&)来实现取模运算(%)呢

原理如下：

> X % 2^n = X & (2^n – 1)
>
> 2^n 表示 2 的 n 次方，也就是说，一个数对 2^n 取模 == 一个数和 (2^n – 1) 做按位与运算 。
>
> 假设 n 为3，则 2^3 = 8，表示成 2 进制就是 1000。2^3 -1 = 7 ，即 0111。
>
> 此时 X & (2^3 – 1) 就相当于取 X 的 2 进制的最后三位数。
>
> 从 2 进制角度来看，X / 8相当于 X >> 3，即把 X 右移 3 位，此时得到了 X / 8 的商，而被移掉的部分(后三位)，则是X % 8，也就是余数。

简单来讲就是：

```
6 % 8 = 6 ，6 & 7 = 6；
10 & 8 = 2 ，10 & 7 = 2
```

记住会用就行。

---

具体的 put 过程可以参照下图进行理解。

![HashMap 的 put 流程](https://upload-images.jianshu.io/upload_images/3303429-826fe880484c00c5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 6. HashMap 的扩容机制

扩容(resize)就是重新计算容量。

当我们不停的向 HashMap 中添加元素，当达到临界值，HashMap 无法添加新元素时，就需要进行扩容，以便能装入更多的元素。

```java
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table; // 新建变量扩容前的 Entry Node
    int oldCap = (oldTab == null) ? 0 : oldTab.length; //扩容前数组的长度
    int oldThr = threshold; // 扩容前能容纳最大键值对数量
    int newCap, newThr = 0;
    if (oldCap > 0) {
        // 超过最大值就不再扩充了，就只好随你碰撞去吧
        if (oldCap >= MAXIMUM_CAPACITY) { 
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        // 没超过最大值，就扩充为原来的2倍
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                  oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    // 计算新的 resize 上限
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
        // 将之前的元素都移动到新的 buckets 中
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode) // 暂时忽略红黑树部分
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // 链表优化重 hash 的代码块
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                         // 原索引
                        if ((e.hash & oldCap) == 0) {  //仅仅是判断元素是否需要换位置，不要理解为元素的新位置
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        // 原索引+oldCap
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                     // 原索引放到bucket里
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    // 原索引+oldCap放到bucket里
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```

在经过 resize 扩容后，数组的长度会扩大为原来的 2 倍，所以，**元素的位置要么是在原位置，要么是在原位置再移动 2 次幂的位置**。

结合下图理解，n 为 table 的长度，图（a）表示扩容前的 key1 和 key2 两种 key 确定索引位置的示例，图（b）表示扩容后 key1 和 key2 两种 key 确定索引位置的示例，其中 hash1 是 key1 对应的哈希与高位运算结果。

[图片上传失败...(image-7534d-1576498907545)]

元素在重新计算 hash 之后，因为 n 变为 2 倍，那么 n-1 的范围在高位多 1bit(红色)，因此新的 index 就会发生这样的变化。

![元素位置的变化](https://upload-images.jianshu.io/upload_images/3303429-fa9738199fefa1e1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

因此，扩容时，只需要看看原来的 hash 值新增的那个 bit 是 1 还是 0 就行了，是 0 的话索引没变，是 1 的话索引变成“原索引 + oldCap”，可以结合下图理解，下图是 16 -> 32 的过程。

![扩容示意图](https://upload-images.jianshu.io/upload_images/3303429-8584df480e91134d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

这个设计确实非常的巧妙，既省去了重新计算 hash 值的时间，而且同时，由于新增的 1bit 是 0 还是 1 可以认为是随机的，因此 resize 的过程，均匀的把之前的冲突的节点分散到新的 bucket 了。

HashMap 的 get 方法比较简单，在这里就不再进行分析了。

## 7. 为什么HashMap线程不安全?

1.多线程 put，导致的数据不一致。

当拥有多个线程时，每个线程都会去抢占 CPU 资源，而 CPU 根据一定的线程调度算法来切换线程，因此就可能出现线程 A 没执行完毕，线程 B 就拿到 CPU 资源去执行了，从而会导致数据错乱。

比如有两个线程 A 和 B。

A 希望插入一个 key-value 到 HashMap 中，在完成了计算索引坐标，获取链表头结点的操作后，线程 A 的时间用完了；

B 开始执行，B 计算完毕，成功将记录插入到了 HashMap 中；

此时，A 再次被执行，假设 A、B 计算出的索引是一致的，由于 A 不知道 B 已经插入到此节点了，因此 A 进行插入事，就会覆盖 B 的记录，就造成了数据不一致的行为。

2.resize 造成的无限循环

HashMap 在 resize 时，会重新计算元素的位置与 hash。

因此在多线程操作 HashMap 时，可能会出现node 的 next 指向的下一个元素之间，形成环形链表，导致无限循环。

![image](https://upload-images.jianshu.io/upload_images/3303429-900044b1de110f40.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 参考

- https://tech.meituan.com/2016/06/24/java-hashmap.html
- https://www.hollischuang.com/archives/2091