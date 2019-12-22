// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

// 示例：

// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
#include <iostream>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
    {
        ListNode *head = new ListNode(0);
        ListNode *current = head;
        while (l1 != NULL && l2 != NULL)
        {
            if (l1->val > l2->val)
            {
                current->next = l2;
                l2 = l2->next;
            }
            else
            {
                current->next = l1;
                l1 = l1->next;
            }
            current = current->next;
        }

        if (l1 == NULL && l2 != NULL)
        {
            current->next = l2;
        }
        else if (l2 == NULL && l1 != NULL)
        {
            current->next = l1;
        }

        return head->next;
    }
};

/**
 * 类似与归并排序, 这里有个亮点是使用一个 哨兵 head 来处理返回的链表
*/