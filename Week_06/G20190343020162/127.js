/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    if(!endWord || wordList.indexOf(endWord) == -1){
        return 0;
    }
	// 各个通用状态对应所有单词
	var comboDicts = {};
	var len = beginWord.length;
    for(var i = 0;i<wordList.length;i++){
		for(var r = 0;r<len;r++){
			var newWord = wordList[i].substring(0,r)+'*'+wordList[i].substring(r+1,len);
			(!comboDicts[newWord]) && (comboDicts[newWord] = []);
			comboDicts[newWord].push(wordList[i]);
		}
	}
    
    function visitWord(currQueue,currVisited,othersVisited){
        var currNode = currQueue.shift();
		var currWord = currNode[0];
		var currLevel = currNode[1];
		for(var i = 0;i < len;i++){
            // 通用状态
			var newWord = currWord.substring(0,i)+'*'+currWord.substring(i+1,len);
            if(newWord in comboDicts){
                var tmpWords = comboDicts[newWord];
                for(var z = 0;z<tmpWords.length;z++){
                    if(othersVisited[tmpWords[z]] != undefined){
                        return currLevel + othersVisited[tmpWords[z]];
                    }
                    if(currVisited[tmpWords[z]] == undefined){
                        currVisited[tmpWords[z]] = currLevel + 1;
                        currQueue.push([tmpWords[z],currLevel+1]);
                    }
                }
            }
		}
        return -1;
    }
    
	// Queue for BFS from beginWord
	var queueBegin = [[beginWord,1]];
    // Queue for BFS from endWord
    var queueEnd  = [[endWord,1]];
	// visited begin and end
	var visitedBegin = {};
    visitedBegin[beginWord] = 1;
	var visitedEnd = {};
    visitedEnd[endWord] = 1;
	while(queueBegin.length > 0 && queueEnd.length > 0){
        // fromBegin
        var ans = visitWord(queueBegin,visitedBegin,visitedEnd);
        if(ans > -1){
            return ans;
        }
        // formEnd
        ans = visitWord(queueEnd,visitedEnd,visitedBegin);
        if(ans > -1){
            return ans;
        }
	}
	return 0;
};