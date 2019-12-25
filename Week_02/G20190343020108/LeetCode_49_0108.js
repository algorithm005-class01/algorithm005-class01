/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    // 解法一：排序数组分类
    if (!strs || !strs.length) return [];
    const ans = new Map();
    let key;
    for (let str of strs) {
        // 将排序后的字符串作为分组的 key
        key = str
            .split('')
            .sort()
            .join('');
        if (!ans.has(key)) ans.set(key, [str]);
        else ans.set(key, [...ans.get(key), str]);
    }
    return [...ans.values()];
};

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams2 = function(strs) {
    // 字符串中的数字只有小写字母 用字符的出现次数来统计是否是异位词
    // 按照次数统计作为 key 来分组不同的异位词
    if (!strs || !strs.length) return [];
    const ans = new Map();
    let counter, key;
    for (let str of strs) {
        counter = Array(26).fill(0); // 申请一个大小为26的数组，统计每个字母映射后的下标元素出现次数
        for (let i = 0; i < str.length; i++)
            counter[str.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        key = counter.join('#'); // 构建异位词分组的 key
        if (!ans.has(key)) ans.set(key, [str]);
        else ans.set(key, [...ans.get(key), str]);
    }
    return [...ans.values()];
};
