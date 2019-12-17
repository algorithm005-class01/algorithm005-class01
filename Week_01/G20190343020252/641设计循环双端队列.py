class MyCircularDeque:

    def __init__(self, k: int):
        self.k, self.q = k, []

    def insertFront(self, value: int) -> bool:
        if len(self.q) < self.k:
            self.q.insert(0, value)  # python 列表有insert的方法
            return True
        return False

    def insertLast(self, value: int) -> bool:
        if len(self.q) < self.k:
            self.q += [value]  # 在队尾插入的话，直接append就行了
            return True
        return False

    def deleteFront(self) -> bool:
        return self.q.pop(0) <= float('inf') if self.q else False  # pop 方法删除，位置i 的元素

    def deleteLast(self) -> bool:
        return self.q.pop() <= float('inf') if self.q else False  # 默认删除 列表中最后一个元素

    def getFront(self) -> int:
        return self.q[0] if self.q else -1

    def getRear(self) -> int:
        return self.q[-1] if self.q else -1

    def isEmpty(self) -> bool:
        return len(self.q) == 0

    def isFull(self) -> bool:
        return len(self.q) == self.k

if __name__ =='__main__':
    que = MyCircularDeque(3)
    print(que.insertFront(2))
    print(que.isEmpty())
