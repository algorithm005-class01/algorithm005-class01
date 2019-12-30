/**
 * @param {string} digits
 * @return {string[]}
 */
const numToLetterDict = {
    '2': 'abc',
    '3': 'def', 
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz'
};

var letterCombinations = function(digits) {
    var backtrack = function(combination, nextDigits) {
        if (!nextDigits) {
            output.push(combination);
        } else {
            const letters = numToLetterDict[nextDigits[0]];

            for (const letter of letters) {
                backtrack(combination + letter, nextDigits.substring(1,));
            }
        }
    };
    
    if (!digits) {
        return [];
    }
    const output = [];
    backtrack('', digits);
    return output;
};
