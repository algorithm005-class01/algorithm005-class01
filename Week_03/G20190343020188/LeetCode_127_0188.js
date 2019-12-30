/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  // 词汇表
  var wordListSet = new Set(wordList);

  // 若词汇表中没有结束词，直接返回
  if(!wordListSet.has(endWord)) return 0;

  // 创建双端词汇组
  var beginSet = new Set([beginWord]);
  var endSet = new Set([endWord]);

  var level = 1;

  // BFS
  while (beginSet.size) {
    // 创建下一个头端词汇组
    var nextBeginSet = new Set();

    // 遍历头端词汇组
    for(var key of beginSet){
      // 遍历词汇的每个字
      for(var i = 0;i < key.length;i++){
        // 缓存词的前缀、后缀和编码
        var prefix = key.substring(0,i);
        var suffix = key.substring(i+1);
        var charCode = key.charCodeAt(i);

        // 遍历替换 26 个字母
        for(var j = 0;j !== charCode && j < 26;j++){
          // 生成新词
          var s =  String.fromCharCode(97+j);
          var newWord = prefix + s + suffix;

          // 若尾端词组包含新词，直接返回结果
          if(endSet.has(newWord)){
            return level + 1;
          }

          // 若词汇表包含新词，则在下一个头端词汇表中加入该词，并从词汇表中删除该词
          if(wordListSet.has(newWord)){
            nextBeginSet.add(newWord);
            wordListSet.delete(newWord);
          }
        }
      }
    }

    // 初始化下一层遍历的变量
    beginSet = nextBeginSet;
    level++;

    // 若头端词组大于尾端词组，则交换值
    if(beginSet.size > endSet.size){
      [beginSet, endSet] = [endSet, beginSet];
    }
  }
  return 0;
};