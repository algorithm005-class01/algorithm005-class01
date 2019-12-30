**HashMap**

1. Java 1.8开始，hashmap内部数据结构做了优化，由`数组+链表+红黑树`实现

2. **put操作原理**：对key进行hashCode()运算，获取你的key的hash值，用这个hash值对数组的长度进行取模，根据取模的结果，将key-value对放在数组中的对应位置上

3. **hash冲突**： hash值一样，不同的hash值对一个数组的length取模得到的index一样 

4. **hash冲突处理：**当发生hash冲突时，jdk1.8之前会在对应的index位置上挂成一个链表，但是如果冲突元素过多，事必会造成查询效率低下，时间复杂度为O(n)，jdk1.8以后，如果链表长度超过了8，就会转换成红黑树，时间复杂度降成O(logn)

5.  **hashmap数组扩容+rehash算法** ：

    2倍扩容 + rehash，每个key-value对，都会基于key的hash值重新寻址找到新数组的新的位置 

   JDK 1.8，扩容一定是2的倍数，就可以保证说，每次扩容之后，你的每个hash值要么是停留在原来的那个index的地方，要么是变成了原来的index（5） + oldCap（16） = 21

   扩容机制：数组2倍扩容，重新寻址（rehash），hash & n - 1，判断二进制结果中是否多出一个bit的1，如果没多，那么就是原来的index，如果多了出来，那么就是index + oldCap，通过这个方式，就避免了rehash的时候，用每个hash对新数组.length取模，取模性能不高，位运算的性能比较高

6. **hash算法优化：**

   static final int hash(Object key) {
       int h;

   ​    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
   }

    *h = key.hashCode()*：这个就是直接获取了key的hash值，通过的是hashCode()方法；

   *h >>> 16*，这个是位运算的操作，这个是把32位的二进制的数字，所有的bit往右侧右移了16位，将他的高16位和低16位进行异或运算；在hash值的低16位里面，可以同时保留他的高16位和低16位的特征

   他的hash值的高16位和低16位的特征都参与到了运算定位到那个数组的index，可以保证降低hash冲突的概率

    位运算，性能很高，&与操作，来实现取模的效果 

    数组的大小就是2的n次方， 最后再通过获得的hash值跟n-1进行与运算可以获取跟取模一样的效果，而且性能比

    *i = (n - 1) & hash*，i就是最后寻址算法获取到的那个hash值对应的数组的index 

   