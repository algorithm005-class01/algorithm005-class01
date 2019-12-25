/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    // 解法一：使用哈希表计数器
    if (s.length !== t.length) return false;
    const hash = new Map();
    for (let i = 0; i < s.length; i++) {
        if (hash.has(s.charAt(i)))
            hash.set(s.charAt(i), hash.get(s.charAt(i)) + 1);
        else hash.set(s.charAt(i), 1);

        if (hash.has(t.charAt(i)))
            hash.set(t.charAt(i), hash.get(t.charAt(i)) - 1);
        else hash.set(t.charAt(i), -1);
    }
    for (let val of hash.values()) {
        if (val !== 0) return false;
    }
    return true;
};

/**
 * 方法二：使用数组计数器
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram2 = function(s, t) {
    if (s.length !== t.length) return false;
    // 初始化一个大小为 （122 - 65 + 1）的数组，初始值为0
    // [A-Za-z] ASCII 码的值的区间
    const counter = Array(58).fill(0); // [A-Za-z][65-122]
    for (let i = 0; i < s.length; i++) {
        counter[s.charCodeAt(i) - 65]++;
        counter[t.charCodeAt(i) - 65]--;
    }
    for (let item of counter) {
        if (item !== 0) return false;
    }
    return true;
};

/**
 * 方法三：排序后比较
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram3 = function(s, t) {
    const sortedS = s
        ? s
              .split('')
              .sort()
              .join('')
        : '';
    const sortedT = t
        ? t
              .split('')
              .sort()
              .join('')
        : '';
    return sortedS === sortedT;
};
