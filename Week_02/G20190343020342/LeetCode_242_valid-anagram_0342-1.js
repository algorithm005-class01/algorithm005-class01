// 方法一： 暴力排序 O(NlogN)
// 156ms 慢
var isAnagram = function(s, t) {
     if(s.length != t.length) return false;
     return  s.split('').sort().join('') == t.split('').sort().join('');
 }