var hammingWeight = function(n) {
    let count = 0;
    
    // in js don't use n > 0
    // 11111111111111111111111111111101
    // n = n & (n - 1); will be -4
    while (n) {
        n = n & (n - 1);
        count++;
        console.log(n);
    }
    
    return count;
};
