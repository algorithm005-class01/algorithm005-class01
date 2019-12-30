class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        
        if(nums.count <= 0){
            return -1
        }
        
        var left = 0
        var right = nums.count - 1
        
        let start = 0
        let end = right
        
        while left <= right {
     
            let  middle = left + (right - left) / 2
    
            if(nums[middle] == target){
                return middle
            }
            //
            if( nums[start] <= nums[middle] ){
                
                if(target < nums[middle] && target >= nums[start]){
                    
                    right = middle - 1
                }else{
                    
                    left = middle + 1
                }
            }else{
                if(target > nums[middle] && target <= nums[end]) {
                    left = middle + 1
                }else{
                    
                    right = middle - 1
                }
        
            }
            
          
         }
        
        return -1
    }
}