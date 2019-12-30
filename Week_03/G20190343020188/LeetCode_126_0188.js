/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function(beginWord, endWord, wordList) {
  // 将 wordList 转换为 Set
  wordList = new Set(wordList);

  // 若结束词不存在，直接返回
  if(!wordList.has(endWord)) return [];

  var ans = [];
  var visited = {};
  var neighborMap = {};
  var path = new Set([beginWord]);
  
  var height = bfs(beginWord, endWord);

  dfs(beginWord, endWord, path);

  return ans;

  function bfs(begin, end) {
    var beginSet = new Set([begin]);
    var endSet = new Set([end]);
    var isFound = false;
    var reverse = false;
    var height = 1;
    while(beginSet.size) {
      var tmp = new Set();
      for(var word of beginSet) {
        for(var i = 0; i < word.length; i++) {
          for(var j = 0; j <26; j++) {
            var ch = String.fromCharCode(97+j);
            if(ch !== word[i]) {
              var newWord = word.slice(0, i) + ch + word.slice(i+1);
              if(!wordList.has(newWord)) continue;
              if(endSet.has(newWord)){
                isFound = true;
              } else {
                tmp.add(newWord);
              }
              let key, value;
              if(reverse) {
                key = newWord;
                value = word;
              } else {
                key = word;
                value = newWord;
              }

              if(neighborMap[key]){
                neighborMap[key].add(value);
              } else {
                neighborMap[key] = new Set([value]);
              }
            }
          }
        }
      }
      height++;
      beginSet = tmp;

      if(!isFound) {
        if(beginSet.size > endSet.size) {
          [beginSet, endSet] = [endSet, beginSet];
          reverse = !reverse;
        }
      } else {
        break;
      }
    }
    return height;
  }

  visited[beginWord] = 1;
  function dfs(begin, end, path) {
    if(begin === end) {
      ans.push([...path]);
      return;
    }
    if(path.size >= height) return;

    var neighbors = neighborMap[begin] ? neighborMap[begin] : [];

    for(var neighbor of neighbors) {
      if(path.has(neighbor)) continue;
      if(visited[neighbor] < path.size+1) continue;
      path.add(neighbor);
      if(visited[neighbor]){
        visited[neighbor] = Math.min(visited[neighbor], path.size);
      } else {
        visited[neighbor] = path.size;
      }
      dfs(neighbor, end, path);
      path.delete(neighbor);
    }
  }
};