# 作业

hashmap分析

**Homework: 把java源码中的hashmap实现看明白，它的node分hashNode和treeNode两种，重点看put(), get(). (putVal(), getNode()看明白). 写个学习总结。**

 

hash函数

hash=(h = key.hashCode()) ^ (h >>> 16); 取高位是为了避免hash冲突

table_i=(n - 1) & hash

 

put

根据key找到对应的数组位置 判断是否为空 为空则写入

否则判断list类型

链表 写入最后链表最后一个 判断链表个数是否为8个 8个则转换成红黑树

树节点 则根据红黑树插入红黑树

其中如何hashcode值存在 则返回hashcode值对应oldvalue 存入新数据

 

get()

外层if table为空或者当前位置的数据为空 return null;

不为空的情况：

hash值相等并且 key值相等或者equal的话，则return first;

如果是TreeNode，则通过getTreeNode去找；

最后就是do while循环去遍历查找； 

```
 

 /**

​     * Returns the value to which the specified key is mapped,

​     * or {@code null} if this map contains no mapping for the key.

​     *

​     * <p>More formally, if this map contains a mapping from a key

​     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :

​     * key.equals(k))}, then this method returns {@code v}; otherwise

​     * it returns {@code null}.  (There can be at most one such mapping.)

​     *

​     * <p>A return value of {@code null} does not necessarily

​     * indicate that the map contains no mapping for the key; it's also

​     * possible that the map explicitly maps the key to {@code null}.

​     * The {@link #containsKey containsKey} operation may be used to

​     * distinguish these two cases.

​     *

​     * @see #put(Object, Object)

​     */

​    public V get(Object key) {

​        Node<K,V> e;

​        return (e = getNode(hash(key), key)) == null ? null : e.value;

​    }

 

 /**

​     * Implements Map.get and related methods

​     *

​     * @param hash hash for key

​     * @param key the key

​     * @return the node, or null if none

​     */

​    final Node<K,V> getNode(int hash, Object key) {

​        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;

​        if ((tab = table) != null && (n = tab.length) > 0 &&

​            (first = tab[(n - 1) & hash]) != null) {

​            if (first.hash == hash && // always check first node

​                ((k = first.key) == key || (key != null && key.equals(k))))

​                return first;

​            if ((e = first.next) != null) {

​                if (first instanceof TreeNode)

​                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);

​                do {

​                    if (e.hash == hash &&

​                        ((k = e.key) == key || (key != null && key.equals(k))))

​                        return e;

​                } while ((e = e.next) != null);

​            }

​        }

​        return null;

​    }

​    /**

​     * Returns true if this map contains a mapping for the

​     * specified key.

​     *

​     * @param   key   The key whose presence in this map is to be tested

​     * @return true if this map contains a mapping for the specified

​     * key.

​     */

​    public boolean containsKey(Object key) {

​        return getNode(hash(key), key) != null;

​    }

​    /**

​     * Associates the specified value with the specified key in this map.

​     * If the map previously contained a mapping for the key, the old

​     * value is replaced.

​     *

​     * @param key key with which the specified value is to be associated

​     * @param value value to be associated with the specified key

​     * @return the previous value associated with key, or

​     *         null if there was no mapping for key.

​     *         (A null return can also indicate that the map

​     *         previously associated null with key.)

​     */

​    public V put(K key, V value) {

​        return putVal(hash(key), key, value, false, true);

​    }

​    /**

​     * Implements Map.put and related methods

​     *

​     * @param hash hash for key

​     * @param key the key

​     * @param value the value to put

​     * @param onlyIfAbsent if true, don't change existing value

​     * @param evict if false, the table is in creation mode.

​     * @return previous value, or null if none

​     */

​    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,

​                   boolean evict) {

​        Node<K,V>[] tab; Node<K,V> p; int n, i;

​        if ((tab = table) == null || (n = tab.length) == 0)

​            n = (tab = resize()).length;

​        if ((p = tab[i = (n - 1) & hash]) == null)

​            tab[i] = newNode(hash, key, value, null);

​        else {

​            Node<K,V> e; K k;

​            if (p.hash == hash &&

​                ((k = p.key) == key || (key != null && key.equals(k))))

​                e = p;

​            else if (p instanceof TreeNode)

​                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);

​            else {

​                for (int binCount = 0; ; ++binCount) {

​                    if ((e = p.next) == null) {

​                        p.next = newNode(hash, key, value, null);

​                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st

​                            treeifyBin(tab, hash);

​                        break;

​                    }

​                    if (e.hash == hash &&

​                        ((k = e.key) == key || (key != null && key.equals(k))))

​                        break;

​                    p = e;

​                }

​            }

​            if (e != null) { // existing mapping for key

​                V oldValue = e.value;

​                if (!onlyIfAbsent || oldValue == null)

​                    e.value = value;

​                afterNodeAccess(e);

​                return oldValue;

​            }

​        }

​        ++modCount;

​        if (++size > threshold)

​            resize();

​        afterNodeInsertion(evict);

​        return null;

​    }
```

#  学习总结

## 哈希函数的设计：

关于散列函数的设计，我们要尽可能让散列后的值随机且均匀分布，这样会尽可能地减少散列冲突，即便冲突之后，分配到每个槽内的数据也比较均匀。

除此之外，散列函数的设计也不能太复杂，太复杂就会太耗时间，也会影响散列表的性能。

 

## 哈希冲突的解决方法：

关于散列冲突解决方法的选择，我对比了开放寻址法和链表法两种方法的优劣和适应的场景。

大部分情况下，链表法更加普适。而且，我们还可以通过将链表法中的链表改造成其他动态查找数据结构，比如红黑树，来避免散列表时间复杂度退化成 O(n)，抵御散列碰撞攻击。但是，对于小规模数据、装载因子不高的散列表，比较适合用开放寻址法。

对于动态散列表来说，不管我们如何设计散列函数，选择什么样的散列冲突解决方法。随着数据的不断增加，散列表总会出现装载因子过高的情况。这个时候，我们就需要启动动态扩容。

 

### 一致性哈希算法详解：[http://www.zsythink.net/archives/1182/](http://www.zsythink.net/archives/1182/)



哈希表的时间复杂度：查询、添加、删除 都是O(1)  

最坏的情况，就是哈希函数选的不好，或者哈希表的size太小，导致经常发生冲突 哈希碰撞。这样会使哈希表退化成链表。退化成链表后，复杂度就退化成O(n).



## 拿到题目后，做题目的四件套：

1. **clarification** **和面试官****sync****一下对题目意思的理解**
2. **possible solutions -> optimal****找出最优的（****time&space****）**
3. **code**
4. **test      cases.**



# BST

中序遍历一个BST, 得到升序遍历。

BST的查询和其他操作都是O(logN)，之前单链表插入很快，但是查询都是O(N)的。

虽然O(logN)比O(1)慢一点，但是比O(N)不知道快了多少。



# 递归代码技巧：

一旦开始写递归代码，四个部分马上写下来。

 

1. terminator
2. process
3. drill down
4. reverse states