// 审题，和面试官多沟通
// 1.把数字和字母提取出来（用正则将非aA-zZ0-9的字符置成空字符串)
// 2.反转字符串比较
/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {

    let filteredS = _filterNonNumberAndChar(s);
    let reversedS = _reveseString(filteredS);

    return reversedS === filteredS;
};

function _reveseString(s) {
    return s.split('').reverse().join('');
}

function _filterNonNumberAndChar(s) {
    return s.replace(/[^A-Za-z0-9]/g,'').toLowerCase();
}