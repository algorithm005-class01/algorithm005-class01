class Solution {
    
   
    func combine(_ n: Int, _ k: Int) -> [[Int]] {
        
        if( n < 1 || k < 1 || n < k){
            return []
        }
        var ans = [[Int]]()
        var one = [Int]()
        combineT(n, 1, k, &one,&ans)
        
        return ans
        
        
    }
    
    func combineT(_ n:Int,_ begin:Int,_ k:Int ,_ oneAns:inout [Int], _ ans:inout [[Int]] )  {
        if(oneAns.count == k){
            ans.append(oneAns)
            return
        }
    
        for i in begin ..< (n + 1) {
            oneAns.append(i)
            combineT(n, i + 1, k, &oneAns,&ans)
            oneAns.popLast()
            // 树形 全部回溯的经典套路
        }
    }
}