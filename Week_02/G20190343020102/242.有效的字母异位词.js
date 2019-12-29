/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  //方法1 57.55%
  // let hash1 = {}
  // for (let i = 0; i < s.length; i++) {
  //   hash1[s[i]] ? hash1[s[i]] ++ : hash1[s[i]] = 1
  // }
  // for (let i = 0; i < t.length; i++) {
  //   if(!hash1[t[i]] || hash1[t[i]] <= 0) {
  //     return false
  //   } else {
  //     hash1[t[i]] --
  //   }
  // }
  // for(let key in hash1) {
  //   if(hash1[key] > 0) {
  //     return false
  //   }
  // }
  // return true

  //方案2 75.4%
  // if(s.length != t.length) {
  //   return false
  // }
  // let map = new Map()
  // for(let i = 0; i < s.length; i++) {
  //   value = map.get(s[i])
  //   map.set(s[i],value ? value + 1 : 1) 
  //   value = map.get(t[i])
  //   map.set(t[i], value ? value - 1:-1)
  // } 
  // let flag = true
  // map.forEach((item,key) => {
  //   if(item != 0) {
  //     flag = false
  //     return false
  //   }
  // })
  // return flag

  //方案3 优化代码格式
  // if(s.length != t.length) return false
  // let ans = new Array(26).fill(0)
  // for(let i = 0; i < s.length; i++) {
  //   ans[transKey(s[i])] ++
  // }
  // for(let i = 0; i < t.length; i++) {
  //   ans[transKey(t[i])] --
  //   if(ans[transKey(t[i])] < 0) {
  //     return false
  //   }
  // }
  // return true

  //国际站代码 83.65%
  const map = {};
  s.split('').map(c => map[c] = map[c] ? map[c] + 1 : 1);
  t.split('').map(c => map[c] = map[c] ? map[c] - 1 : -1);
  return Object.keys(map).every(k => map[k] === 0);
};

let transKey = (c) => {
  return c.charCodeAt() - 'a'.charCodeAt()
}
// @lc code=end

