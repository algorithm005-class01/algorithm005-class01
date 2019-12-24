// 思路 整体循环一遍  dic<key array>
// 从str to key 转换

class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
       
        
        var dicAns = [String:[String]]()
        for str in strs{
            let key = strToKey(str)
            
            if(dicAns[key] == nil){
                dicAns[key] = [str]
            }else{

               var array = dicAns[key]
                array?.append(str)
                dicAns[key] = array
            }
        }
        
        
        return  [[String]](dicAns.values)
    }
    
    
    func strToKey(_ str:String) -> String {
         //  通用方法
        //print(str)
        // sorted 方法执行比下面的还快……
       // return String(str.sorted())
        
        var strIntArray = [Int].init(repeating: 0, count: 26)
        for char in str {
           let index = Int(char.asciiValue! - Character("a").asciiValue!)
            strIntArray[index] += 1
        }

        var ans = ""
        for i in strIntArray{
            ans.append(String(i))
        }

        return ans
    }
    

}


//let s = Solution()
//
//let r = s.groupAnagrams(["eat","tea","tan","ate","nat","bat"])
//print(r)

