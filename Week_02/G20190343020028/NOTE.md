## 一次失败的习惯养成复盘

**`预警：与算法训练营学习无关，比较琐碎，review 的同学可以略过此段。`**

作为一个在极客时间购买了 56 门课的人，在看到 21 天打卡计划，理所当然的参加了。然后第一天就没有进行打卡……

宣传页里有一句，我忘了是官方文案还是同学们的回复： ***『火箭在发射的最初 30 秒，需要消耗掉 80% 的燃料。好的开始，对我们来说至关重要。』*** 。这句话很鼓舞我，像『前面有一片梅林』一样，让失去前进动力的我又找到一个近在眼前的目标。

12-19 星期四，晚上加班了。这是一个我可以自我安慰的借口，也是一个我认为上班族都可能存在的现实问题。没有时间、精力甚至心情，在每一天工作之余，再学习且进行高质量的输出。

为了让上帝能够每天开心，我进行了一点思考。想起一句话『行百里者半九十』，这句话怎么感觉和上面说的有些相悖？捋了一下逻辑，上面火箭的例子，说的是付出的努力；『行百里者半九十』，讲得是目标的完成度。

这两个理论，好像让我推导出一个结论：付出 99%（瞎扯的，没有任何计算） 的努力，也可能一无所获。

嗯！就是这个，这就是我失落、沮丧且自责的点！对自己有了一个简单的规划，进行了一些半吊子的努力，然后在预期时间没有达到某个目标，觉得（认清）自己是个废物，颓败、怅然若失然后放弃。

上面就是我 21 天打卡计划，第一天就失败的心里路程。虽然失败了，但是从中找到了几个点，我觉得仍是收获：

- 一个近在眼前的目标，会让人更有动力去完成
- 付出并不一定有收获
- 人们都认可 21 天就能培养良好习惯的理论（也是瞎扯的，没有数据支撑，主观臆断）

针对这几个点，再简单归纳一下：

- `人们都认可 21 天就能培养良好习惯的理论`：我觉得这个忽略的个体的差异性，每个人的能力、习惯、生活状态都是不一样的，对我而言，周末利用整块的时间（且没有太多干扰）进行学习，更符合生活习惯、更有效（更让自己觉得满意）
- `付出并不一定有收获`：我自己混淆了两个概念，『目标』、『收获』，付出不一定能达成预期目标，但是中间过程仍会有很多收获。
- `一个近在眼前的目标，会让人更有动力去完成`：学会拆解任务（哇，这不就是 DP 的思想吗）

由此给自己制定了又一个规划：每天学习、总结我达不到，那就拉长周期，每周进行学习；对于一个目标，学会拆解子任务，积跬步以至千里。

唠唠叨叨了半天，都是自己的碎碎念，没有什么逻辑性。如果有不同意见或建议，希望咱们可以进行讨论（撕逼）。如果上面有一两个点能帮助到你，是我的荣幸，与君共勉。

## HaspMap 源码分析

### 插入元素

``` Java
public V put(K key, V value) {
    return this.putVal(hash(key), key, value, false, true);
}
final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
    HashMap.Node[] tab;
    int n;
    // 当前节点数组如果为空，或者容量为 0，进行容量重算操作
    if ((tab = this.table) == null || (n = tab.length) == 0) {
        n = (tab = this.resize()).length;
    }
    Object p;
    int i;
    // 如果插入位置为空，则直接插入（未碰撞情况）
    if ((p = tab[i = n - 1 & hash]) == null) {
        tab[i] = this.newNode(hash, key, value, (HashMap.Node)null);
    } else { // 碰撞之后的处理
        Object e;
        Object k;
        // 如果 key 值相同，则进行覆盖处理
        if (((HashMap.Node)p).hash == hash && ((k = ((HashMap.Node)p).key) == key || key != null && key.equals(k))) {
            // [1]
            e = p;
        }
        // 如果 key 不同，且当前数组后继节点已由 TreeNode（红黑树）实现，则直接在树上进行新增节点操作
        else if (p instanceof HashMap.TreeNode) {
            // [2]
            e = ((HashMap.TreeNode)p).putTreeVal(this, tab, hash, key, value);
        }
        // 如果仍是链表实现，需要进一步判断
        else {
            // 链长度计数
            int binCount = 0;
            while(true) {
                // 链表后继节点为空的情况
                // [3]
                if ((e = ((HashMap.Node)p).next) == null) {
                    // 创建后继节点
                    ((HashMap.Node)p).next = this.newNode(hash, key, value, (HashMap.Node)null);
                    // 如果当前链已经含有 8 个元素，则将链表转化为红黑树实现
                    if (binCount >= 7) {
                        this.treeifyBin(tab, hash);
                    }
                    break;
                }
                // 如果循环查到后继节点 key 值与插入 key 值相同，则跳出，在后续部分处理
                if (((HashMap.Node)e).hash == hash && ((k = ((HashMap.Node)e).key) == key || key != null && key.equals(k))) {
                    break;
                }
                // 指针前进
                p = e;
                ++binCount;
            }
        }
        // [1][2][3] 三处赋值，如果存在有效节点，即需要更新 value
        if (e != null) {
            V oldValue = ((HashMap.Node)e).value;
            if (!onlyIfAbsent || oldValue == null) {
                ((HashMap.Node)e).value = value;
            }
            // LinkedHashMap 实现了对应的方法，主要是更新尾指针指向内容
            this.afterNodeAccess((HashMap.Node)e);
            return oldValue;
        }
    }
    // 增加操作次数
    ++this.modCount;
    // 如果当前容量到达临界值，则进行扩容操作（临界值默认为当前总容量的 0.75）
    if (++this.size > this.threshold) {
        this.resize();
    }
    // 是否驱逐老的元素，这段暂时不是很懂
    // LinkedHashMap 实现了一个删除头结点的方法，但是要判断 removeEldestEntry()，
    // 该方法默认返回 false，应该是在某种场景下允许重写该方法，达到删除头结点的目的
    // 暂时没想通这部分到底要做什么，希望老师或者 review 的同学知道的话，帮忙解答一下
    this.afterNodeInsertion(evict);
    return null;
}
```

### 查找元素

``` Java
public V get(Object key) {
    HashMap.Node e;
    return (e = this.getNode(hash(key), key)) == null ? null : e.value;
}
final HashMap.Node<K, V> getNode(int hash, Object key) {
    HashMap.Node[] tab;
    HashMap.Node first;
    int n;
    // 当前哈希表不为空，且头结点不为空，进行后续查询操作
    if ((tab = this.table) != null && (n = tab.length) > 0 && (first = tab[n - 1 & hash]) != null) {
        Object k;
        // 头结点 key 值即所查，则直接返回头结点
        if (first.hash == hash && ((k = first.key) == key || key != null && key.equals(k))) {
            return first;
        }
        HashMap.Node e;
        // 后继节点不为空，进行后续查询
        if ((e = first.next) != null) {
            // 如果头结点是红黑树实现，则直接调用红黑树取值方法
            if (first instanceof HashMap.TreeNode) {
                return ((HashMap.TreeNode)first).getTreeNode(hash, key);
            }
            // 如果是链表实现，则进行链式查询
            do {
                // 查找到则返回
                if (e.hash == hash && ((k = e.key) == key || key != null && key.equals(k))) {
                    return e;
                }
            } while((e = e.next) != null);
        }
    }
    // 至此仍未查找到，则返回空
    return null;
}
```

### 删除元素

``` Java
public V remove(Object key) {
    HashMap.Node e;
    return (e = this.removeNode(hash(key), key, (Object)null, false, true)) == null ? null : e.value;
}
// 删除操作 = 查找 + 移除找到的元素
final HashMap.Node<K, V> removeNode(int hash, Object key, Object value, boolean matchValue, boolean movable) {
    HashMap.Node[] tab;
    HashMap.Node p;
    int n;
    int index;
    if ((tab = this.table) != null && (n = tab.length) > 0 && (p = tab[index = n - 1 & hash]) != null) {
        HashMap.Node<K, V> node = null;
        Object k;
        // 查找基本同 get()，不再赘述
        if (p.hash == hash && ((k = p.key) == key || key != null && key.equals(k))) {
            node = p;
        } else {
            HashMap.Node e;
            if ((e = p.next) != null) {
                if (p instanceof HashMap.TreeNode) {
                    node = ((HashMap.TreeNode)p).getTreeNode(hash, key);
                } else {
                    label88: {
                        while(e.hash != hash || (k = e.key) != key && (key == null || !key.equals(k))) {
                            p = e;
                            if ((e = e.next) == null) {
                                break label88;
                            }
                        }
                        node = e;
                    }
                }
            }
        }
        Object v;
        // 移除操作
        // 要移除的节点不为空，如果指定了 value，也要判断 value 是否相等
        if (node != null && (!matchValue || (v = ((HashMap.Node)node).value) == value || value != null && value.equals(v))) {
            // 节点是由红黑树实现的，则直接调用红黑树的移除操作
            if (node instanceof HashMap.TreeNode) {
                ((HashMap.TreeNode)node).removeTreeNode(this, tab, movable);
            }
            // 链表实现
            // 如果是数组元素，直接移除，将数组元素记为后继节点
            else if (node == p) {
                tab[index] = ((HashMap.Node)node).next;
            }
            // 如果是链表中的元素，将节点的后继节点记为移除节点的后继
            else {
                p.next = ((HashMap.Node)node).next;
            }
            // 增加操作次数
            ++this.modCount;
            // 显小容量计数
            --this.size;
            // LinkedHashMap 实现了对应的方法，更新尾指针指向内容
            this.afterNodeRemoval((HashMap.Node)node);
            return (HashMap.Node)node;
        }
    }
    return null;
}
```

### resize() & treeifyBin()

这两个方法应该是我们平常使用 `HashMap` 极为便捷的原因，但是代码有点复杂，我只梳理下我了解到的：

- resize()：动态的扩容，默认以 0.75 作为临界值，如果达到当前总容量的 0.75，就会将容量翻倍。只看到扩容的内容了，没有找到缩容的逻辑。可能存在一个插入了很多值又删除大部分的场景，仍会占用大块内存的情况。不过常用的方式，一般是方法变量，执行完方法即 GC 回收。如果纯粹探索的话，可以考虑在 remove() 方法中添加达到一定下限临界值的时候进行缩容处理。
- treeifyBin()：应该有两个触发条件，在外层如果链表实现的长度达到 8，就会进入这个方法，但是这里仍判断了总容量。总容量如果低于 64 的话，还是进行的 resize() 操作。只有某一个链表长度达到 8 以上，且总容量达到 64，才会真正的将链表转换为红黑树实现。
