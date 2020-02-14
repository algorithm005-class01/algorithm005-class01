// 解法二：位操作技巧
var hammingWeight = function(n) {
    let sum = 0
    while(n != 0){
        sum++
        n &= (n-1)
    }
    return sum
};