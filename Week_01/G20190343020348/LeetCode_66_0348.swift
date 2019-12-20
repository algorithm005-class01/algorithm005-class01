class Solution {
    func plusOne(_ digits: [Int]) -> [Int] {
        var digits = digits
        var i = digits.count - 1
        while i >= 0 {
            digits[i] = (digits[i] + 1) % 10
            if( digits[i]  != 0){
                return digits
            }
            i -= 1
        }
  
        digits .insert(1, at: 0)
        return digits
        
    }
}