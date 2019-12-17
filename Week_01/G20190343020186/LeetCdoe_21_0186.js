var mergeTwoLists = function(l1, l2) {
    let node1 = l1
    let node2 = l2
    let node = {next: null}
    let head = node
    while(node1 !== null && node2 !== null) {
       if (node1.val < node2.val) {       
         node.next = node1
         node1 = node1.next
         node = node.next
       } else {
         node.next = node2
         node2 = node2.next
         node = node.next
       }
    }
    
    while(node1 !== null) {
     node.next = node1
     node1 = node1.next
     node = node.next
    }

     while(node2 !== null) {
        node.next = node2
        node2 = node2.next
        node = node.next
    }
     
    return head.next
  };