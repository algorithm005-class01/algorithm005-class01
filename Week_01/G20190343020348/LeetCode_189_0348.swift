class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {


        let k = k % nums.count
        
        if(k == 0){
            return
        }


       change(nums: &nums, 0,nums.count - 1)
       change(nums: &nums, 0, k - 1)
       change(nums: &nums, k, nums.count - 1)

    }

    func change( nums: inout [Int], _ begin: Int, _ end:Int) {
        var begin = begin
        var end = end
        while begin < end {
            let temp = nums[begin]
            nums[begin] = nums[end]
            nums[end] = temp
            begin += 1
            end -= 1
            
        }
        
     
    }
}