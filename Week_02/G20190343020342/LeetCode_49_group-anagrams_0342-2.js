// 解法二：利用数学设计键
// 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式。

// 利用这个，我们把每个字符串都映射到一个正数上。

// 用一个数组存储质数 prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]。

// 然后每个字符串的字符减去 ' a ' ，然后取到 prime 中对应的质数。把它们累乘。

// 例如 abc ，就对应 'a' - 'a'， 'b' - 'a'， 'c' - 'a'，即 0, 1, 2，也就是对应素数 2 3 5，然后相乘 2 * 3 * 5 = 30，就把 "abc" 映射到了 30。

// 相减时用 Unicode 编码。

// 和解法一的理论差不多，不过少了字符串的排序。

// 也就是用另外一种方式解决了哈希设计键。

// 时间复杂度 O(NK)

var groupAnagrams = function(strs) {
	let res = {};
	for(let i = 0; i < strs.length; i++) {
		const str = strs[i]
		const hash = str.split('').reduce((sum, s)=>{
			return sum * [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101][s.charCodeAt(0) - 97]
		}, 1)
		res[hash] ? res[hash].push(str) : res[hash] = [str]
	}
	
	return Object.values(res)

};

// 貌似不行
var groupAnagrams = function(strs) {
	let res = {};
	strs.forEach(item => {
        let key = [...item].map(item => item.charCodeAt()).reduce((prev, curr) => prev * curr, 1);
        res[key] ? res[key] = [...res[key], ...[item]] : res[key] = [item];
    })
	
	return Object.values(res)

};
