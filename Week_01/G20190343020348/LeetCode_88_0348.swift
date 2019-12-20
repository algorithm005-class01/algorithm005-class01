// 思路转换  后面对比
class Solution {
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
         //
         var resultIndex = m + n - 1
         var firstIndex = m - 1
         var secondIndex  = n - 1
         
        while firstIndex >= 0 && secondIndex >= 0 {
            
            if(nums1[firstIndex] >= nums2[secondIndex]){
                nums1[resultIndex] = nums1[firstIndex]
                firstIndex -= 1
            }else{
                nums1[resultIndex] = nums2[secondIndex]
                secondIndex -= 1
            }
            
            resultIndex -= 1
        }
        
        while secondIndex >= 0 {
            nums1[resultIndex] = nums2[secondIndex]
            resultIndex -= 1
            secondIndex -= 1
        }
    }
}
