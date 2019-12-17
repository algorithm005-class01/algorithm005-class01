class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dict = [Int: Int]()
        let enumerated = nums.enumerated()
        for (index, num) in enumerated {
            if let temp = dict[target - num] {
                return [temp, index]
            }
            dict[num] = index
        }
        return []
    }
}
