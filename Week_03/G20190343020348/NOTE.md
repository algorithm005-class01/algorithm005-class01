学习笔记

使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
说明：同学们可以将自己的思路、代码写在第3周的学习总结中


和153 题类似





class Solution {
    func findMin(_ nums: [Int]) -> [Int] {
        
    
        var left = 0
        var right = nums.count - 1
        
        if(nums[left] <= nums[right]){
            // 有序
            return []
        }
        
        
        while left <= right {
            
            let middle = left + (right - left) / 2
            if(middle + 1 <= (nums.count - 1) && nums[middle] > nums[middle + 1]){
                return [middle,middle + 1]
            }
                
            if ( middle > 1 && nums[middle - 1] > nums[middle]) {
                     return [middle - 1,middle];
            }
                
            if(nums[middle] < nums[right]){
                right = middle - 1
            }else {
                left = middle + 1
            }
        }
        
        
        
        return []
        
    }
}
