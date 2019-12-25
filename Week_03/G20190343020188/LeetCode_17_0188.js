/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  if(!digits) return [];

  var res = [];

  backtrack('', digits, res);

  return res;
};

var dict = {
  '2': ['a', 'b', 'c'],
  '3': ['d', 'e', 'f'],
  '4': ['g', 'h', 'i'],
  '5': ['j', 'k', 'l'],
  '6': ['m', 'n', 'o'],
  '7': ['p', 'q', 'r', 's'],
  '8': ['t', 'u', 'v'],
  '9': ['w', 'x', 'y', 'z']
}

function backtrack(combination, next_digits, res) {
  if (next_digits.length == 0) {
    res.push(combination);
  } else {
    var digit = next_digits.substring(0, 1);
    next_digits = next_digits.substring(1);
    for (letter of dict[digit]) {
      backtrack(combination + letter, next_digits, res);
    }
  }
}