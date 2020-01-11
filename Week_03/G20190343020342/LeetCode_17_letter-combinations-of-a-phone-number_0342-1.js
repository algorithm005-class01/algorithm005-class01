// 回溯
// 时间复杂度： O(3^N * 4^M)
// N 是输入数字中对应 3 个字母的数目（比方说 2，3，4，5，6，8）
// M 是输入数字中对应 4 个字母的数目（比方说 7，9），N+M 是输入数字的总数。
    
// 空间复杂度：O(3^N * 4^M) 需要保存 3^N * 4^M 个结果。

/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {

    if(!digits){
        return [];
    }
    let len = digits.length;
    let map = new Map();
    map.set('2','abc');
    map.set('3','def');
    map.set('4','ghi');
    map.set('5','jkl');
    map.set('6','mno');
    map.set('7','pqrs');
    map.set('8','tuv');
    map.set('9','wxyz');
    let result = [];
    function _generate(i, str){

        // terminator
        if (i == len) {
            result.push(str);
            return;
        }
        // process
        let tmp = map.get(digits[i]);
        for (let r = 0; r < tmp.length; r++) {
            // drill down
            _generate(i + 1, str + tmp[r]);
        }
    }
    _generate(0, '');
    return result;

};