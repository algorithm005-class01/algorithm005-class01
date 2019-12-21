#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x)
	: val(x)
	, next(NULL)
    {
    }
};

ListNode* mergeTwoLists(ListNode* l1, ListNode* l2)
{
    ListNode* heard = new ListNode(-1);
    ListNode* p = heard;
    while (l1 != NULL && l2 != NULL) {
	if (l1->val <= l2->val) {
	    p->next = l1;
	    l1 = l1->next;
	} else {
	    p->next = l2;
	    l2 = l2->next;
	}
	p = p->next;
    }
    p->next = l1 == NULL ? l2 : l1;
    return heard->next;
}
