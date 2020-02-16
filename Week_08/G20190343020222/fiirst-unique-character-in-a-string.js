/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    for (var i = 0; i < s.length; i++) {
        if (s.indexOf(s.charAt(i)) === s.lastIndexOf(s.charAt(i))) {
            return i;
        }
    }
    return -1;
};