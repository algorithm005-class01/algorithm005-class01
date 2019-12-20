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
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* fakehead = new ListNode(0);
        fakehead->next = head;
        ListNode* pre = fakehead;
        ListNode* end = fakehead;
        while(end->next != NULL)
        {
            for (int i = 0; i < k && end != NULL; i++) end = end->next;
            if (end == NULL) break;
            ListNode* start = pre->next;
            ListNode* next = end->next;
            end->next = NULL;
            pre->next = reverseList(start); 
            start->next = next;
            pre = start;
            end = pre;
        }

        return fakehead->next;
    }
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = NULL;
        ListNode* curr = head;
        while (curr) {
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
};