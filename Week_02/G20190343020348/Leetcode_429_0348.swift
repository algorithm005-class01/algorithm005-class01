public class NTreeNode {
    public var val: Int
    public var children:[NTreeNode]
    public init(_ val: Int) {
        self.val = val
        self.children = [NTreeNode]()
    }
    
}

class Solution {
    func levelOrder(_ root: NTreeNode?) -> [[Int]]{
        
        var ans = [[Int]]()
        var levelArray = [NTreeNode]()
        
        if(root != nil){
            levelArray.append(root!)
        }
        
        while levelArray.count > 0 {
            var onelevel  = [Int]()
            var temp = [NTreeNode]()
            for tree in levelArray {
                onelevel.append(tree.val)
                temp.append(contentsOf: tree.children)
            }
            
            
            if(onelevel.count > 0){
               ans.append(onelevel)
            }
            
            levelArray = temp
            
        }
        
        return ans
        
        
    }
    
    
}