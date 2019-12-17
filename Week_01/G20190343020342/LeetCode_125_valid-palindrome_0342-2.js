//去掉非数字字母的字符串，并转成小写
//设置左、右双指针，向中间判断，如果不相等返回false
/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {

    if(!s) return true;
    s = s.replace(/[^0-9a-zA-Z]/g,'').toLowerCase();
    let left = 0;
    let right = s.length - 1;
    while(left < right){
        if(s[left] != s[right]){
            return false;
        }
        left++;
        right--;
    }
    return true;

};