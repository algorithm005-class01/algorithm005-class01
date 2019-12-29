/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    
    const count = {};
    for (let i = 0; i < s.length; i++) {
        count[s[i]] = count[s[i]] ? count[s[i]] + 1 : 1;
        count[t[i]] = count[t[i]] ? count[t[i]] - 1 : -1;
    }
    
    for (let key of Object.keys(count)) {
        if (count[key] !== 0) {
            return false;
        }
    }
    
    return true;
};