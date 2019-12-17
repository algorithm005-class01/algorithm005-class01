class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode * head = new ListNode(-1);
        ListNode * ptr = head;
        while(l1 != nullptr && l2 != nullptr) {
            if (l1-> val <= l2->val) {
                head->next = l1;
                l1 = l1->next;
            }
            else {
                head->next = l2;
                l2 = l2->next;
            }
            head = head->next;
        }
        head->next = l1 != nullptr ? l1:l2;
        return ptr->next;
    }
};