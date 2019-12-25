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
var groupAnagrams = function (strs) {
  //1.暴力
  //所有的都先排序 12.63% 傻瓜代码
  // let s = new Array(strs.length).fill(0)
  // let temp = []
  // let ans = []
  // for(let i = 0; i < strs.length; i++) {
  //   temp.push(strs[i].split('').sort().join(''))
  // }
  // for(let i = 0; i < strs.length; i++) {
  //   if(s[i] == 0) {
  //     let item = [] 
  //     for(let j = i; j < strs.length; j++) {
  //       if(temp[i] == temp[j]) {
  //         item.push(strs[j])
  //         s[j] ++
  //       }
  //     }
  //     ans.push(item)
  //   }
  // }
  // return ans

  //2.两层hash 超时了，再优化
  // let hash1 = new Array(strs.length).fill(0),map = {},item = {} ,ans = []
  // for(let i = 0; i < strs.length; i++) {
  //   if(hash1[i] === 0) {
  //     item = []
  //     for(let j = i; j < strs.length; j++) {
  //       map = {}
  //       strs[i].split('').map(c => map[c] = map[c] ? map[c] + 1 : 1)
  //       strs[j].split('').map(c => map[c] = map[c] ? map[c] - 1 : -1)
  //       if( Object.keys(map).every(k => map[k] === 0)) {
  //         item.push(strs[j])
  //         hash1[j] ++;
  //       }
  //     }
  //     ans.push(item)
  //   }
  // }
  // return ans

  //方案3，优化方案2  35.29%  使用hasOwnProperty 大大提高效率 93.26%
  //思路，两层循环一遍一遍有点蠢，应该就查一遍，维护一个对象
  let map = {}, ans = []
  for(let i = 0; i < strs.length; i++) {
    let key = strs[i].split('').sort().join('')
    if(!map.hasOwnProperty(key)) map[key] = [strs[i]]
    else map[key].push(strs[i])
  }
  // Object.keys(map).map(item => {
  //   ans.push(map[item])
  // })
  for(let key in map) {
    ans.push(map[key])
  }
  return ans

  // 方案4 80.63% 国际站代码，
  // var resultObj = {} ,resultArr = [];
  // function addIndexToObj (element) {
  //     var key = element.split("").sort().join("");
  //     if (resultObj.hasOwnProperty(key)) {
  //         resultObj[key].push(element);
  //     } else {
  //         resultObj[key] = [element];
  //     }
  // }
  // strs.forEach(addIndexToObj);
  
  // for (var key in resultObj) {
  //     resultArr.push(resultObj[key]);
  // }
  
  // return resultArr;
};

//总结，hasOwnProperty 判断键值对会大大提高效率
// @lc code=end

