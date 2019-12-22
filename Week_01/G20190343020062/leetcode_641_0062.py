#设计实现双端队列。
#你的实现需要支持以下操作：
#
#
# MyCircularDeque(k)：构造函数,双端队列的大小为k。
# insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
# insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
# deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
# deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
# getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
# getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
# isEmpty()：检查双端队列是否为空。
# isFull()：检查双端队列是否满了。
#
#
# 示例：
#
# MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
#circularDeque.insertLast(1);			        // 返回 true
#circularDeque.insertLast(2);			        // 返回 true
#circularDeque.insertFront(3);			        // 返回 true
#circularDeque.insertFront(4);			        // 已经满了，返回 false
#circularDeque.getRear();  				// 返回 2
#circularDeque.isFull();				        // 返回 true
#circularDeque.deleteLast();			        // 返回 true
#circularDeque.insertFront(4);			        // 返回 true
#circularDeque.getFront();				// 返回 4
# 
#
#
#
# 提示：
#
#
# 所有值的范围为 [1, 1000]
# 操作次数的范围为 [1, 1000]
# 请不要使用内置的双端队列库。
#
# Related Topics 设计 队列



#leetcode submit region begin(Prohibit modification and deletion)

class MyCircularDeque:

    def __init__(self, k):
        self.k, self.q = k, []

    def insertFront(self, value: int) -> bool:
        if len(self.q) < self.k:
            self.q.insert(0, value)
            return True
        return False

    def insertLast(self, value: int) -> bool:
        if len(self.q) < self.k:
            self.q += [value]
            return True
        return False

    def deleteFront(self) -> bool:
        return self.q.pop(0) <= float('inf') if self.q else False

    def deleteLast(self) -> bool:
        return self.q.pop() <= float('inf') if self.q else False

    def getFront(self) -> int:
        return self.q[0] if self.q else -1

    def getRear(self) -> int:
        return self.q[-1] if self.q else -1

    def isEmpty(self) -> bool:
        return len(self.q) == 0

    def isFull(self) -> bool:
        return len(self.q) == self.k

#leetcode submit region end(Prohibit modification and deletion)



