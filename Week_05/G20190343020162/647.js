var countSubstrings = function(s) {
    let count = 0;
    function find(s, i, j) {
        while (i >= 0 && j <s.length && s[i] == s[j]) {
            count++;
            i--;
            j++;
        }
    }
    for (let i = 0; i < s.length; i++) {
        find(s, i, i);
        find(s, i, i+1);
    }
    return count;
};