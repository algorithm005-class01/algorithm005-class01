/// 太暴力了 通过不了 提交

/*
 class Solution {
 
 
 
 var map = ["1":"A",
 "2":"B",
 "3":"C",
 "4":"d",
 "5":"e",
 "6":"f",
 "7":"g",
 "8":"h",
 "9":"i",
 "10":"g",
 "11":"k",
 "12":"l",
 "13":"m",
 "14":"n",
 "15":"o",
 "16":"p",
 "17":"q",
 "18":"r",
 "19":"s",
 "20":"t",
 "21":"u",
 "22":"v",
 "23":"w",
 "24":"x",
 "25":"y",
 "26":"z"
 ];
 func numDecodings(_ s: String) -> Int {
 if s.isEmpty {
 return 0
 }
 
 
 let carray  = [Character].init(s)
 
 var res :[String] = []
 
 
 var s = String()
 findOne(carray, 0, &s, &res)
 
 return res.count
 
 
 }
 
 func findOne(_ carray:[Character],_ begin:Int, _ one:inout String,_ res:inout [String])  {
 if(begin >= carray.count){
 
 res.append(one)
 return
 }
 
 
 let f =  map[String(carray[begin])]
 
 var sec = one
 
 if(f != nil){
 one.append(f!)
 findOne(carray, begin + 1, &one, &res)
 }else{
 return
 }
 if(begin + 1 < carray.count){
 var t =  String(carray[begin])
 t.append(carray[begin + 1])
 
 if(map[t] != nil){
 
 sec.append(map[t]!)
 findOne(carray, begin + 2, &sec, &res)
 }else{
 return
 }
 }
 }
 }
 */

/*  还是 超出时间限制 递归没有戏了*/

/*
 class Solution {
 func numDecodings(_ s: String) -> Int {
 if(s.isEmpty){
 return 0
 }
 
 return decodeOne(s, 0)
 
 
 }
 
 func decodeOne(_ s: String,_ start:Int) -> Int {
 
 if(start == s.count){
 return 1
 }
 
 let sarray:[Character] = [Character].init(s)
 
 if(sarray[start] == "0"){
 return 0
 }
 
 let  an1 = decodeOne(s,start + 1)
 
 var  an2 = 0
 if(start + 1 < s.count){
 
 
 let ten =  (sarray[start].asciiValue! -  Character("0").asciiValue!) * 10
 
 let one =  sarray[start + 1].asciiValue! - Character("0").asciiValue!
 if(ten + one <= 26){
 an2 = decodeOne(s, start + 2)
 }
 }
 
 
 return an1 + an2
 
 }
 }
 */

/*
class Solution {
    func numDecodings(_ s: String) -> Int {
        if( s.count == 0){
            return 0
        }
        
        var dp :[Int] = Array.init(repeating: 0, count: s.count + 1)
        
        dp[s.count] = 1
        
        let sarray:[Character] = [Character].init(s)
        
        if(sarray[s.count - 1] == "0"){
            dp[s.count - 1] = 0
        }else{
            dp[s.count - 1] = 1
        }
        
        
        var i = s.count - 2
        
        while i >= 0 {
            if(sarray[i] == "0"){
                dp[i] = 0
 
            }else{
                
                
                let ten =  (sarray[i].asciiValue! -  Character("0").asciiValue!) * 10
                
                let one =  sarray[i + 1].asciiValue! - Character("0").asciiValue!
                
                if(ten + one <= 26){
                    dp[i] = dp[i+1] + dp[i+2]
                }else{
                    dp[i] = dp[i+1]
                }
            }
            
            
            i -= 1
        }

        return dp[0]
        
    }
}
 */


class Solution {
    func numDecodings(_ s: String) -> Int {
        if( s.count == 0){
            return 0
        }
        
        var dp2 = 1
        var dp1 = 1
 
        let sarray:[Character] = [Character].init(s)
        
        if(sarray[s.count - 1] == "0"){
            dp1 = 0
        }else{
            dp1 = 1
        }
        
        
        var i = s.count - 2
        
        while i >= 0 {
            if(sarray[i] == "0"){
                dp1 = 0
                dp2 = dp1
            }else{
                let ten =  (sarray[i].asciiValue! -  Character("0").asciiValue!) * 10
                
                let one =  sarray[i + 1].asciiValue! - Character("0").asciiValue!
                var temp = 0
                if(ten + one <= 26){
                
                    temp = dp1 + dp2
                }else{
                    temp = dp1

                }
                
                dp2 = dp1
                dp1 = temp
            }
            
            
            i -= 1
        }

        return dp1
        
    }
}