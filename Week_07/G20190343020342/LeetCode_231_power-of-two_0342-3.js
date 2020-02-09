// 解法三：取模
var isPowerOfTwo = function(n) {
    while(n > 1){
        n /= 2;
    }
    if(n == 1){
        return true;
    }else{
        return false;
    }
};