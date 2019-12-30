/*
 * @lc app=leetcode.cn id=127 lang=javascript
 *
 * [127] 单词接龙
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

//解法1：BFS
//时间复杂度：O(M * N) ,M为单词长度(beginword)，,N为单词列表长度(wordList)
// 空间复杂度：O(M * N) ,M长度的单词化为邻接单词形式时需要M，N同上
var ladderLength = function (beginWord, endWord, wordList) {

    //不存在endword
    if (!endWord || wordList.indexOf(endWord) == -1) {
        return 0;
    }

    //各个通用状态对应所有单词
    let comboDicts = {};

    let len = beginWord.length;

    for (let i = 0; i < wordList.length; i++) {
        //遍历beginword
        for (let r = 0; r < len; r++) {
            var newWord = wordList[i].substring(0, r) + '*' + wordList[i].substring(r + 1, len);
            (!comboDicts[newWord]) && (comboDicts[newWord] = []);
            comboDicts[newWord].push(wordList[i]);
        }
    }

    let queue = [[beginWord, 1]];
    
    // visited
	var visited = {beginWord:true};
	while(queue.length > 0){
		var currNode = queue.shift();
		var currWord = currNode[0];
		var currLevel = currNode[1];
		for(var i = 0;i < len;i++){
            // 通用状态
			var newWord = currWord.substring(0,i)+'*'+currWord.substring(i+1,len);
            if(newWord in comboDicts){
                var tmpWords = comboDicts[newWord];
                for(var z = 0;z<tmpWords.length;z++){
                    if(tmpWords[z] == endWord){
                        return currLevel + 1;
                    }
                    if(!visited[tmpWords[z]]){
                        visited[tmpWords[z]] = true;
                        queue.push([tmpWords[z],currLevel+1]);
                    }
                }
            }
		}
	}
	return 0;    
    


};
// @lc code=end