

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

    class Solution {
        //        func preorderTraversal(_ root: TreeNode?) -> [Int] {
        //                    if(root == nil){
        //                        return []
        //                    }
        //                    var ans = [Int]()
        //
        //                    ans.append(root!.val)
        //
        //                    if(root!.left != nil){
        //                        ans.append(contentsOf: preorderTraversal(root!.left!))
        //                    }
        //
        //                    if(root!.right != nil){
        //                        ans.append(contentsOf: preorderTraversal(root!.right!))
        //                    }
        //
        //                    return ans
        //        }
        
        // 迭代
        func preorderTraversal(_ root: TreeNode?) -> [Int] {
            
            var stack = [TreeNode]()
            var ans = [Int]()
            
            var current = root
            while  current != nil || stack.count > 0 {
                
                if(current != nil){
                    ans.append(current!.val)
                    if(current!.right != nil){
                        stack.append(current!.right!)
                    }
                    
                    current = current!.left
                }else{
                    current = stack.popLast()
                }
                
            }
            
            return ans
        }
    }
}
// 同样还有莫里斯遍历




