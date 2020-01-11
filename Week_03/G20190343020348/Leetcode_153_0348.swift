
class Solution {
    func findMin(_ nums: [Int]) -> Int {
        
    
        var left = 0
        var right = nums.count - 1
        
        if(nums[left] <= nums[right]){
            return nums[0]
        }
        
        while left <= right {
            
            let middle = left + (right - left) / 2
            if(middle + 1 <= (nums.count - 1) && nums[middle] > nums[middle + 1]){
                return nums[middle + 1]
            }
                
            if ( middle > 1 && nums[middle - 1] > nums[middle]) {
                     return nums[middle];
            }
                
            if(nums[middle] < nums[right]){
                right = middle - 1
            }else {
                left = middle + 1
            }
        }
        
        return -1
        
    }
}
