/**
 * 
 *  反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/


#include <iostream>
using namespace std;

/**
 * Definition for singly-linked list.
 */

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

/**
 * 双指针反转一直想不通 😓
 * 不过明白 ① 当将当前的指针 next 指向前一个元素时, 当前元素的后一个节点 需要保存的, 否则下次就找不到了
 *        ② while 循环做的时 将 pre 与 cur 双指针 都同时向前走一步的操作
 * 扫描一遍, O(n)
 * 申请空间消耗 常数 O(1)
*/
class Solution
{
public:
    ListNode *reverseList(ListNode *head)
    {
        // pre <- cur
        // pre 为后面的节点
        ListNode *prev = NULL;
        // cur 为前面的节点
        ListNode *cur = head;
        // 输入: 1->2->3->4->5->NULL
        // 输出: 5->4->3->2->1->NULL
        ListNode *temp = NULL;
        while (cur)
        {
            // 保留后面的节点
            temp = cur->next;
            // 更新 当做节点的 next 方向
            cur->next = prev;
            // prev 与 cur 都前进一位
            prev = cur;
            cur = temp;
        }
        // cur 没有值了 最新值也就是 head 其实是 prev
        return prev;
    }
};

/**
 * 递归
 * 将 子链表先反转了, 然后再将自身添加到反转链表的最后一个节点上, 
 * 
*/
class Solution2
{
public:
    ListNode *reverseList(ListNode *head)
    {
        // 先判断小于两个节点的情况
        if (!head || !head->next) return head;
        ListNode *ans = reverseList(head -> next);
        // ans 是新链表的头节点, 所以直接返回
        // 补偿当前节点 head 到 新链表的最后一个节点, 也就是原来自链表的首节点 head -> next
        head -> next -> next = head;
        // 最后的节点 置为空
        head -> next = NULL;
        return ans;
    }
};

/**
 * 尾递归, 自己调用自己 直接返回调用结果
 * 
*/
class Solution3
{
public:
    ListNode *reverseList(ListNode *head)
    {
        // 先判断小于两个节点的情况
        if (!head) return head;
        return reverseList(NULL,head);
    }

    ListNode *reverseList(ListNode *pre,ListNode *cur)
    {
        // cur 可能为空, 在最后一个元素的时候, 这里每一步都非常重要
        if (!cur) return pre;
        // 先保存下一个, 因为后面要替换
        ListNode *temp = cur -> next;
        // 最重要的一个地方, 反转
        cur -> next  = pre;
        // 更新 pre cur 前进一步
        return reverseList(cur,temp);
    }
};

int main(int argc, char **argv)
{
    return -1;
}