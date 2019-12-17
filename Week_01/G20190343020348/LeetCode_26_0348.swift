class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
     
              
        if(nums.count < 2){
            return nums.count
        }
        
        var resultNum = 0
        for i in 1 ..< nums.count {
            if(nums[i] != nums[resultNum]){
                resultNum += 1
                nums[resultNum] = nums[i]
            }
            
        }
        
        return resultNum + 1
    }
}