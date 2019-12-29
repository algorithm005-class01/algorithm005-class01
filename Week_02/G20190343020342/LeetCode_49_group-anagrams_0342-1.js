// 方法一：哈希表
// 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
// 维护一个哈希映射 ans : {String -> List}，其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K。
// 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。


var groupAnagrams = function(strs) {
    var hash = new Map();
    var groupAnagrams = [];
    strs.forEach(item => {
        let sortedItem = item.split('').sort().join('');
   		hash.has(sortedItem) ? hash.set(sortedItem, Array.prototype.concat(hash.get(sortedItem), [item])) : hash.set(sortedItem, [item]);
    })
    for (var item of hash.keys()) {
        groupAnagrams.push(hash.get(item));
    }
    return groupAnagrams;
};

// 展开运算符
// 可以将字符串展开为字符串数组
// 可以代替concat
// 可以摊开iterable对象
var groupAnagrams = function(strs) {
    var hash = new Map();
    strs.forEach(item => {
        let sortedItem = [...item].sort().join('');
   		hash.has(sortedItem) ? hash.set(sortedItem, [...hash.get(sortedItem), ...[item]]) : hash.set(sortedItem, [item]);
    })

    return [...hash.values()];
};

 