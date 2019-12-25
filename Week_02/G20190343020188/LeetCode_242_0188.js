/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  // 创建两个哈希表存储字母出现次数
  var dicts = Object.create(null);
  var dictt = Object.create(null);
  
  // 统计字符串 s 的字母及出现次数
  for(var i = 0; i < s.length; i++){
    var k = s.charCodeAt(i);
    if(dicts[k]){
      dicts[k]++;
    }else{
      dicts[k] = 1;
    }
  }

  // 统计字符串 t 的字母及出现次数
  for(var i = 0; i < t.length; i++){
    var k = t.charCodeAt(i);
    if(dictt[k]){
      dictt[k]++;
    }else{
      dictt[k] = 1;
    }
  }

  // 检查字母数量是否一致
  if(Object.keys(dicts).length !== Object.keys(dictt).length) return false;

  // 读取字母
  var keys = Object.keys(dicts);

  // 比较每个字母的出现次数
  for(var i = 0; i < keys.length; i++){
    if(dicts[keys[i]] !== dictt[keys[i]]) return false;
  };

  return true;
};