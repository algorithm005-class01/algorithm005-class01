

 public class TreeNode {
     public var val: Int
     public var left: TreeNode?
     public var right: TreeNode?
     public init(_ val: Int) {
         self.val = val
         self.left = nil
         self.right = nil
     }
 }

class Solution {
    
    // 递归
//    func inorderTraversal(_ root: TreeNode?) -> [Int] {
//        if(root == nil){
//            return []
//        }
//        var ans = [Int]()
//
//        if(root!.left != nil){
//            ans.append(contentsOf: inorderTraversal(root?.left!))
//        }
//
//        ans.append(root!.val)
//
//        if(root!.right != nil){
//            ans.append(contentsOf: inorderTraversal(root?.right!))
//        }
//
//        return ans
//
   // }
    // 借助栈的迭代方法
    func inorderTraversal(_ root: TreeNode?) -> [Int] {
 
        var stack = [TreeNode]()
        var ans = [Int]()
        
        var current = root
        while  current != nil || stack.count > 0 {
            while current != nil {
                stack.append(current!)
                current = current?.left
            }
            
           current =  stack.popLast()
           ans.append(current!.val)
           current = current!.right
        }
        
       return ans
    }
}


/*
 *递归
 借助栈的迭代方法
 莫里斯遍历
 
 看题解还有颜色标记法 想法真突出
 
 class Solution:
     def inorderTraversal(self, root: TreeNode) -> List[int]:
         WHITE, GRAY = 0, 1
         res = []
         stack = [(WHITE, root)]
         while stack:
             color, node = stack.pop()
             if node is None: continue
             if color == WHITE:
                 stack.append((WHITE, node.right))
                 stack.append((GRAY, node))
                 stack.append((WHITE, node.left))
             else:
                 res.append(node.val)
         return res
 如要实现前序、后序遍历，只需要调整左右子节点的入栈顺序即可。


 */


