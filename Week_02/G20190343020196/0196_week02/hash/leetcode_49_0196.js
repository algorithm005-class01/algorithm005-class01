/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */

 //网上的解法：let str = strs[i].split('').sort().join(), 
 //字符先排序，找到唯一key, 没有就put, 已有就get(key).add
 //复杂度O(K * N* logN)
//  https://leetcode-cn.com/problems/group-anagrams/solution/js-xie-leetcode-by-zhl1232-3/
/* var groupAnagrams = function (strs) {
    //1.同一长度 key, 将其str转成acii入表  
    //2.组成不同长度的value 
    //结果不成功， 没考虑到  一个单词有相同字母
    //后面用累加，累乘，质数表都不成功，有一定局限性
    let hash = new Map();
    let alpha = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103];
    strs.forEach((str) => {

        let len = str.length;
        let sum = 1;

        // Array(24).fill(null).map((_, h) => h);
        // [0, 1, ..., 26]
        //以 len + str转成acii的累乘 为key
        for (let i = 0; i < len; i++) {
        

            let code = str.charCodeAt(i);
            // console.log(alpha[code - 97]++);
          
            sum *= alpha[code - 97];
          
        }

        sum += len;
        sum /= 10000;

        //是否有这个key
        if (hash.has(sum)) {
            let temp = hash.get(sum);
            temp.push(str);
            hash.set(sum, temp);
        } else {
            hash.set(sum, [str]);
        }

    })
    console.log(hash);
    return [...hash.values()];
}; */

var groupAnagrams = function (strs) {
    let hash = new Map();
    strs.forEach((str)=>{
        let alpha = Array(26).fill(0);
        for(let i = 0; i < str.length; i++){
            alpha[str.charCodeAt(i) - 97]++
        }

        let hashKey = alpha.join('#')
        if(hash.has(hashKey)) {
            let temp = hash.get(hashKey)
            temp.push(str)
            hash.set(hashKey, temp)
        } else {
            hash.set(hashKey, [str])
        }
       
    })
    return [...hash.values()]
}
// @lc code=end

let strs = ["cat","rye","aye","cud","cat","old","fop","bra"];

// groupAnagrams(strs).forEach(ele=>{
//     if(ele.length != 1){
//         console.log(ele);
//     }
// });
console.log(groupAnagrams(strs));