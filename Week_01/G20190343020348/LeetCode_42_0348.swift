

class Solution {
    func trap(_ height: [Int]) -> Int {
        
        if(height.count < 3){
            return 0
        }
        
        var leftMaxArray = [Int].init(repeating: 0, count: height.count)
        var rightMaxArray = [Int].init(repeating: 0, count: height.count)
    
        for i in 0 ..< (height.count - 1) {
            if(i == 0) {
                 leftMaxArray[i] = height[0]
            }else{
               leftMaxArray[i] = max(leftMaxArray[i-1], height[i-1])
            }
        }
        
        var j = height.count - 1
        rightMaxArray[j] = height[j]
        j = j - 1
        while j > 0 {
            rightMaxArray[j] = max(height[j+1], rightMaxArray[j+1])
            j = j - 1
        }
        
        var sum = 0
        for k in 1..<height.count - 1  {
             let minheight =   min( leftMaxArray[k] , rightMaxArray[k])
             
            if(minheight > height[k]){
                sum = sum + (minheight - height[k])
            }
        }
        
        
        return sum
    }
}
