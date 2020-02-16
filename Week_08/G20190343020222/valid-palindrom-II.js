/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    var head = 0;
    var tail = s.length - 1;
    
    while (head < tail) {
        if (s.charAt(head) !== s.charAt(tail)) {
            return isPalindrome(s, head + 1, tail)
            || isPalindrome(s, head, tail - 1);
        }
        head++;
        tail--;
    }
    return true;
};

var isPalindrome = function(s, start, end) {
    while (start < end) {
        if (s.charAt(start) !== s.charAt(end)) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}