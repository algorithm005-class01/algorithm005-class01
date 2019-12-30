/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    if (!g || !s) {
        return 0;
    }
    
    // Need to provider compare function
    g.sort((a, b) => a - b);
    s.sort((a, b) => a - b);
    let count = 0;
    let i = 0;
    let j = 0;
    
    while (i < g.length && j < s.length) {
        if (g[i] <= s[j]) {
            i++;
            j++;
            count++;
        } else {
            j++;
        }
    }
    
    return count;
};