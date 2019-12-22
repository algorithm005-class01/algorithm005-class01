// 解法三：计数 用charCode来处理字母实际上不用排序了
// 首先初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。

// 这样的话，"abb" 就映射到了 "1#2#0#0#0"。

// "cdc" 就映射到了 "0#0#2#1#0"。

// "dcc" 就映射到了 "0#0#2#1#0"。

// 然后和其他解法一样，如果 key 一样，就把值映射到对应的 key 里。

// 时间复杂度：O(NK)。

// 所有的方法基本上都是为哈希表设计合适的键

// 因为需要几个值同时对应同一个键

// 所以要找到一个合适键的规则

var groupAnagrams = function(strs) {
    let hash = new Map()
     
    for(let i = 0; i < strs.length; i++) {
        let str = strs[i]
        let arr = Array(26).fill(0)
        for(let j = 0; j < str.length; j++) {
            arr[str.charCodeAt(j) - 97] ++
        }
        let hashKey = arr.join('#')
        if(hash.has(hashKey)) {
            let temp = hash.get(hashKey)
            temp.push(str)
            hash.set(hashKey, temp)
        } else {
            hash.set(hashKey, [str])
        }
    }
    return [...hash.values()]
};