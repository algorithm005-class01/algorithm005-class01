/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    const resultDict = {};
    
    for (let str of strs) {
        const sortedStr = [...str].sort().join('');
        if (!resultDict[sortedStr]) {
            resultDict[sortedStr] = [str];
        } else {
            resultDict[sortedStr].push(str);
        }
    }
    
    return Object.values(resultDict);
};