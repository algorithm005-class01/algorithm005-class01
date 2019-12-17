//
//  LeetCode_21_0198.c
//  LeetCode-week-01
//
//  Created by cf on 2019/12/15.
//  Copyright © 2019 cf. All rights reserved.
//

#include "LeetCode_21_0198.h"

struct ListNode {
     int val;
     struct ListNode *next;
};

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    // 空判断
    if(l1 == NULL) return l2;
    if(l2 == NULL) return l1;
    if(l1 == NULL && l2 == NULL) return NULL;
    // 新建链表
    struct ListNode *head;
    // 获取头结点
    if(l1->val > l2->val)
    {
        head = l2;
        l2 = l2->next;
    }
    else
    {
        head = l1;
        l1 = l1->next;
    }
    // 新建操作交换顺序的链表
    struct ListNode *cur = head;
    while(l1 != NULL && l2 != NULL){
        // 比较两链表对应节点的值大小
        if(l1->val > l2->val)
        {
            cur->next = l2;
            l2 = l2->next;
        }
        else
        {
            cur->next = l1;
            l1 = l1->next;
        }
        // 更改当前链表的尾节点
        cur = cur->next;
    }
    // 处理两链表长度不一,如果一样,此时 l1 或者 l2也是NULL
    cur->next = l1 != NULL ? l1 : l2;

    return head;
}
