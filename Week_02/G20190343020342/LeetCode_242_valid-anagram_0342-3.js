// 方法三：数组计数 时间复杂度 O(n) 
// 类似题型 1122. 数组的相对排序
// 时间复杂度 O(n)
// 空间复杂度 O(1) O(26)==O(1)
// 分别对其中一个单词每个字母出现的字符次数进行增加，对另一给单词每个字母出现的次数进行减少
// 维护一个26位的数组，且初始化为0，方便遍历时直接进行++，而不用判断是否存在
// 最后遍历结果数组只要有不为0的就是false

// 72ms 三个题解最快


/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {

    if(s.length != t.length){
        return false;
    }

    var result = new Array(26).fill(0);//简化初始化方式
    // for (var i = 0; i < 26; i++) {
    //     result[i] = 0;
    // }
    var aCode = 'a'.charCodeAt();
    for (var i = 0; i < s.length; i++) {
        result[s[i].charCodeAt() - aCode]++;
    }
    for (var r = 0;r <t.length; r++) {
        var tmpCode = t[r].charCodeAt() - aCode;
        result[tmpCode]--;
        if(result[tmpCode] < 0){
           return false;
        }
    }
    return true;
};

