
/*
class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        var i = 0
        while  i < nums.count {
            if(nums[i] == 0){
                var j = i + 1
                while j < nums.count {
                    if(nums[j] != 0){
                       let temp =   nums[j]
                        nums[j] = nums[i]
                        nums[i] = temp
                        break
                    }
                    j += 1
                }
                if(j == nums.count){
                   break
                }
            }
            i += 1
    
        }
    }
}
*/



// n  方法

class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        var nextIndex  = 0
        for i in 0 ..< nums.count {
            if(nums[i] != 0){
              nums[nextIndex] = nums[i]
              nextIndex += 1
            }
        }
        
        while nextIndex < nums.count {
            nums[nextIndex] = 0
            nextIndex += 1
        }
    }
}
