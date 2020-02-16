// 解法三：模拟十转二进制、取模
var hammingWeight = function(n) {
    let count = 0;
    while(n){
        // n % 2 == 1
        if(n & 1 == 1){
            count++;
        }
        n >>>= 1;
    }
    return count;
};