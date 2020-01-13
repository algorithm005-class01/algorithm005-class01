// 解法一：暴力法 超时
// 时间复杂度：O(n^2)
// 空间复杂度：O(n)

var longestValidParentheses = function (s) {
    var max = 0;
    function isValid (str) {
        var stack = [];
        for(var i = 0; i < str.length; i++){
            if (str[i] == '(') {
                stack.push('(');
            } else {
                if (stack.length == 0) {
                    return false;
                }
                var topEle = stack.pop();
                if (topEle != '(') {
                    return false;
                }
            }
        }
        return stack.length == 0;
    }
    for (var i = 0; i < s.length; i++){
        for (var j = i + 2; j <= s.length; j+=2) {
            if (isValid(s.slice(i,j))) {
                max = Math.max(max,j-i);
            }
        }
    }
    return max;
};