

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
    func buildTree(_ preorder: [Int], _ inorder: [Int]) -> TreeNode? {
    
        return buildTreeT(preorder, 0, preorder.count, inorder, 0, inorder.count);
            
    }
    
    func buildTreeT(_ preorder: [Int],_ pstart:Int,_ pend:Int ,_ inorder: [Int],_ istart:Int,_ iend:Int) -> TreeNode? {
        
        if(pstart == pend){
            return nil
        }
        
        let rootTree = TreeNode(preorder[pstart])
        
        var rootIndex = 0
        for i in istart ..< iend {
            
            if(inorder[i] == preorder[pstart]){
                rootIndex = i
                break
            }
        }
        
        let leftnum = rootIndex - istart
        
        rootTree.left = buildTreeT(preorder, pstart + 1, pstart + leftnum + 1, inorder, istart, rootIndex)
        rootTree.right = buildTreeT(preorder, pstart + leftnum + 1, pend, inorder, rootIndex + 1, iend)
        
        return rootTree
        
    }
}


//let s = Solution()
//
//s.buildTree([3,9,20,15,7], [9,3,15,20,7])
