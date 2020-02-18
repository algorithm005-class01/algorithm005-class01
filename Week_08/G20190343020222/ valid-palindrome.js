/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let array = s.replace(/\W/g, '').toLowerCase().split('');
    
    // Note: array === array.reverse() will always be true
    // since array.reverse() will do a in-place reversing
    // and return the reference of the original array
    return array.join('') === array.reverse('').join('');
};