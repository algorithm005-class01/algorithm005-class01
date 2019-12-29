class Solution {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        
        var result : ListNode? = nil
        var resultHead : ListNode? = nil
        
        var l1 = l1
        var l2 = l2
        
        while (l1 != nil) && (l2 != nil) {
            
            if( l1!.val <= l2!.val ){
                
                if(result == nil){
                    result = l1
                    resultHead = result
                }else{
                    result!.next = l1
                    result = result!.next
                }
                l1 = l1!.next
            
            }else{
                
                if(result == nil){
                    result = l2
                    resultHead = result
                }else{
                    result!.next = l2
                     result = result!.next
                }
                l2 = l2!.next
            }
            
        }
        
        if (l1 != nil){
            if(result == nil){
                result = l1
                resultHead = result
            }else{
                result!.next = l1
            }
        }
        
        if (l2 != nil){
            if(result == nil){
                result = l2
                resultHead = result
            }else{
                result!.next = l2
            }
        }

        return resultHead
    }
}



// 更简单方法

class Solution {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        
        let dummyNode = ListNode(0)
       
        var currentNode = dummyNode
        var l1 = l1
        var l2 = l2
        
        while (l1 != nil) || (l2 != nil) {
            
            if( l1?.val ?? Int.max) < (l2?.val ?? Int.max){
                currentNode.next = l1
                currentNode = l1!

                l1 = l1!.next
            }else{
               currentNode.next = l2
                currentNode = l2!

                l2 = l2!.next

            }
        }

        return dummyNode.next
    }
}
