class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode * fast_ptr = nullptr;
        ListNode * slow_ptr = nullptr;
        fast_ptr = slow_ptr = head;
        while(fast_ptr != nullptr && fast_ptr->next != nullptr ) {
            fast_ptr = fast_ptr->next->next;
            slow_ptr = slow_ptr->next;
            if (fast_ptr == slow_ptr) {
                fast_ptr = head;
                while(fast_ptr !=  slow_ptr) {
                    fast_ptr = fast_ptr->next;
                    slow_ptr = slow_ptr->next;
                }
                return fast_ptr;
            }

        }
        return nullptr;
    }
};