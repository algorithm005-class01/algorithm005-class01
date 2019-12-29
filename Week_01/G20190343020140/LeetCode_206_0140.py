#迭代法
class Solution(object):  
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        "

        pre = None            #初始前值是none
        while head:            #head 不为空继续
            temp = head.next   #先存head.next,如果不先操作，指针的反转会丢失这一信息
            head.next = pre    # 逆转指针的方向
            
            pre = head         # 移一位操作
            head = temp        # 移一位操作
        return pre              #pre 变成了从原先第0个结点变成了最后一个结点

#递归法1
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        

        
       if head == None or head.next = None:  #从左到右遍历，第一个返回值是数组的最后一个元素，然后继续return
           return head
        pre = reverseList(head.next)
        head.next.next = head
        head.next = None

#递归法2
class Solution(object):
    def reverseList(self, head,pre = None):  #设置默认的pre为 none
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return pre                    #head 为none 就返回none
        next1 = head.next                 #把head 的下一个结点存在next1
        head.next = pre                   #head 指针反转
        return self.reverseList(next1,head)  #直到head 指针检索到最后一个元素为止
