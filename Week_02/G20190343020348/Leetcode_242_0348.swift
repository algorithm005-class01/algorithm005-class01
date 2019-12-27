class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        let sarray =  [Character](s)
        let tarray = [Character](t)
        
        if(sarray.count != tarray.count){
            return false
        }
        var hash = [Character:Int]()
        
        for i in 0 ..< sarray.count {
            if((hash[sarray[i]]) != nil){
                hash[sarray[i]]! += 1
            }else{
                hash[sarray[i]] = 1
            }
        }
        
        for j in 0 ..< tarray.count{
            if(hash[tarray[j]] == nil) {
                return false
            }else{
                hash[tarray[j]]! -= 1
            }
        }
        
        
        for (_, value) in hash {
            if(value < 0){
               return false
            }
        }
        
        return true
        
    }
}