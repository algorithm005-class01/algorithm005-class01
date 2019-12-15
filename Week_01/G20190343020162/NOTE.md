## 本周学习内容

### 学到的数据结构
本周学习了以下数据结构:

1. Array,就是数组,往头尾插入元素， 查找元素的时间复杂度为O(1)，插入和删除的时间复杂度为O(n)
2. List,链表,就是元素之间有链相连,除了查找元素是O(n)，往首尾添加元素，插入和删除的时间复杂度都为O(1)
3. Stack,栈，就是先进后出，添加，删除为O(1)，查询为O(n)
4. Queue,队列，就是先进后出, 添加， 删除为O(1)，查询为O(n)
5. Deque,双端队列,简单理解为两端可以进出的Queue， 插入和删除都是O(1)
6. Priority Queue,优先队列，就是队列里的元素加了优先级，插入操作: O(1), 取出操作: O(logN)按照元素优先级取出
### 思维
1. 一般的优化思想，是思维或者空间换时间
2. 
![image](https://user-images.githubusercontent.com/12718716/70857417-af64e780-1f28-11ea-9abb-f961fc35ac92.png)
I,j对这个数组的遍历，同时保证i,j不会重复，也不会反复，是最简化的两层遍历
3.  夹逼的思维,左右边界i,j，向中间收敛
4.  基础的优化思维，升维和空间换时间
5.  如果一个问题有最近相关性的话，就用栈来解决
6.  滑动窗口的题目，用队列或双端队列

## 所留作业：
因为我是使用javascript的前端程序员，对java不是特别熟悉。所以我想选做第二道题。
* Queue javascript的实现：
```
// 创建队列
function createQueue() {
    const queue = []

    return {
        // 进入队列，unshift表示在数组头插入元素
        enqueue(x) {
            queue.unshift(x)
        },
       // 出队列，pop表示在数组尾部取出元素
        dequeue() {
            if (queue.length === 0) {
                return undefined
            }
            return queue.pop()
        },
       // 查看队列，就是取出数组的最后一个元素
        peek() {
            if (queue.length === 0) {
                return undefined
            }
            return queue[queue.length - 1]
        },
       // 获得队列的长度
        get length() {
            return queue.length
        },
       // 判断队列是否为空
        isEmpty() {
            return queue.length === 0
        }
    }
}
```
Priority javascript的实现:
```
// 首先需要引用刚才写的队列的方法
const { createQueue } = require('../queues/index')

function createPriorityQueue() {
 // 需要创建两个队列
  const highPriorityQueue = createQueue()
  const lowPriorityQueue = createQueue()

  return {
   // 入队列，用第二个入参表示是否为高级队列
    enqueue(item, isHighPriority = false) {
      const queue = isHighPriority ? highPriorityQueue : lowPriorityQueue
      queue.enqueue(item)
    },
   // 出队列，如果高级不为空，返回高级，否则返回低级
    dequeue() {
      if (!highPriorityQueue.isEmpty()) {
        return highPriorityQueue.dequeue()
      }

      return lowPriorityQueue.dequeue()
    },
   // 查看队列,如果高级不为空，返回高级，否则返回低级
    peek() {
      if (!highPriorityQueue.isEmpty()) {
        return highPriorityQueue.peek()
      }

      return lowPriorityQueue.peek()
    },
  // 获得队列的长度，就是高级和低级加起来
    get length() {
      return highPriorityQueue.length + lowPriorityQueue.length
    },
    // 高级和低级都为空则返回空
    isEmpty() {
      return highPriorityQueue.isEmpty() && lowPriorityQueue.isEmpty()
    }
  }
}

```
## 学习经验总结
1.  这周开始没看到是选两道题做，把第三节课的所有题目都做了，而且有的费了好长时间，而且这时候第四节课还没开始，搞到最后很慌张，下次一定看清楚群里发的作业
2. 先看问题再看课程，或者看了一部分课程就可以看题目，带着问题看课程
3. 不要死想问题，没有思路的话可以看题解，关键是背下来并内化，并且要注意复习做过的题，开始是比较吃力，希望之后可以好起来

## 最后
希望可以找同样使用js完成作业的同学,可以互相评审作业