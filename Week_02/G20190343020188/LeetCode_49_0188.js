/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  // 创建字典
  var dict = {};

  // 遍历数组
  for(var i = 0;i < strs.length;i++){
    // 将排序后的字符串作为 key
    var key = strs[i].split('').sort().join();

    // 检查字典中是否有 key 一致的字符串，有则增加，没则创建
    if(dict[key]){
      dict[key].push(strs[i]);
    }else{
      dict[key] = [strs[i]]
    }
  }

  // 返回字典全部的值
  return Object.values(dict);
};