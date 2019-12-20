/**
 * 设计实现双端队列。
    你的实现需要支持以下操作：

    MyCircularDeque(k)：构造函数,双端队列的大小为k。
    insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
    insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
    deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
    deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
    getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
    getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
    isEmpty()：检查双端队列是否为空。
    isFull()：检查双端队列是否满了。
    示例：

    MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
    circularDeque.insertLast(1);			        // 返回 true
    circularDeque.insertLast(2);			        // 返回 true
    circularDeque.insertFront(3);			        // 返回 true
    circularDeque.insertFront(4);			        // 已经满了，返回 false
    circularDeque.getRear();  				// 返回 2
    circularDeque.isFull();				        // 返回 true
    circularDeque.deleteLast();			        // 返回 true
    circularDeque.insertFront(4);			        // 返回 true
    circularDeque.getFront();				// 返回 4
     
     

    提示：

    所有值的范围为 [1, 1000]
    操作次数的范围为 [1, 1000]
    请不要使用内置的双端队列库。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/design-circular-deque
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <vector>
#include <iostream>
using namespace std;

/**
 * 简单的数组实现
 * 注意是循环队列的实现,
 * 需要维护 head tail的索引位置
 * 
 * 从要求上来看 设置 容量k是3时, insertFront(3) 是 true, 所以数组实现的话,没有空间浪费 (有的时候是使用 tail 和 head 来进行判断是否队列满了, 为了区别空与满的状态, 在满的时候空余一个空间, 表示与空的区别!!!!, 否则 tail == head 会存在两种情况)
 * 
 * 所以我们不采用 tail == head 的方式来表示已经满了
 * 而是 采用 单独 计数 size 记录已经存在的元素个数, 与容量相比来确认是否已满
 * 
*/
class MyCircularDeque
{
private:
    vector<int> vtr;
    int capacity;
    int size;
    int head;
    int tail;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k)
    {
        // 一定不能忘记这个构造方法!!!!!!
        vtr = vector<int>(k);
        capacity = k;
        size = 0;
        head = -1;
        tail = -1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value)
    {
        if (isFull())
        {
            return false;
        }
        // 防止 head - 1 会为负数, 因为是循环队列, 所以  (head - 1) + capacity 取余处理,
        head = (head - 1 + capacity) % capacity;
        /**
         * 往前插入一个值, 则head变小, 如果 < 0 ,则相当于从数组后面插入一个值
         * 上面的计算方式等效与 下面的方法
         * head = head - 1;
         * if (head < 0) {head = head + capacity}
         * 
        */

        vtr[head] = value;
        size++;
        if (size == 1)
        {
            tail = head;
        }

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value)
    {
        if (isFull())
        {
            return false;
        }
        tail = (tail + 1) % capacity;
        vtr[tail] = value;
        size++;
        if (size == 1)
        {
            tail = head;
        }
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront()
    {
        if (isEmpty())
        {
            return false;
        }
        // 不清空数据, 仅仅是移动 head
        head = (head + 1) % capacity;
        size--;
        if (size == 1)
        {
            tail = head;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast()
    {
        if (isEmpty())
        {
            return false;
        }
        // 不清空数据, 仅仅是移动 tail
        tail = (tail - 1 + capacity) % capacity;
        size--;
        if (size == 1)
        {
            tail = head;
        }
        return true;
    }

    /** Get the front item from the deque. */
    int getFront()
    {
        if (isEmpty())
        {
            return -1;
        }
        return vtr[head];
    }

    /** Get the last item from the deque. */
    int getRear()
    {
        if (isEmpty())
        {
            return -1;
        }
        return vtr[tail];
    }

    /** Checks whether the circular deque is empty or not. */
    bool isEmpty()
    {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    bool isFull()
    {
        return size == capacity;
    }
};

int main(int argc, char **argv)
{
    MyCircularDeque circularDeque(3);                          // 设置容量大小为3
    cout << "true: " << circularDeque.insertLast(1) << endl;   // 返回 true
    cout << "true: " << circularDeque.insertLast(2) << endl;   // 返回 true
    cout << "true: " << circularDeque.insertFront(3) << endl;  // 返回 true
    cout << "false: " << circularDeque.insertFront(4) << endl; // 已经满了，返回 false
    // 如果在 增加首个元素的时候不同时处理以下 head和tail 会发现有元素覆盖问题,
    cout << "2: " << circularDeque.getRear() << endl;         // 返回 2
    cout << "true: " << circularDeque.isFull() << endl;       // 返回 true
    cout << "true: " << circularDeque.deleteLast() << endl;   // 返回 true
    cout << "true: " << circularDeque.insertFront(4) << endl; // 返回 true
    cout << "4: " << circularDeque.getFront() << endl;        // 返回 4
    return -1;
}