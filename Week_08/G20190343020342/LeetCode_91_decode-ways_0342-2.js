// 解法二：递归
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if(s[0] == 0){
        return 0;
    }
    let n = s.length;
    let helper = (start) => {
        if(start == n){
            return 1;
        }
        if(s[start] == 0){
            return 0;
        }
        let odd = helper(start+1);
        let even = 0;
        if(start < n - 1){
            let ten = s[start];
            let one = s[start+1];
            if((ten+''+one) < 27){
                even = helper(start+2);
            }
        }
        return odd + even;
    }
    return helper(0);
};