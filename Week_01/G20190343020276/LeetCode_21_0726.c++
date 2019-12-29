/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2)
    {
        //创建新链表
        ListNode newLinkHead = ListNode(-1);
        //创建移动指针
        ListNode* prev = &newLinkHead;

        while(l1 != NULL && l2 != NULL)
        {
            if(l1->val <= l2->val)
            {
                prev->next = l1;
                l1 = l1->next;
            }
            else
            {
                prev->next = l2;
                l2 = l2->next;
            }

            prev = prev->next;

        }
        if(l1 == NULL)
        {
            prev->next = l2;
        }
        else
        {
            prev->next = l1;
        }
        
        return newLinkHead.next; 
    }
};