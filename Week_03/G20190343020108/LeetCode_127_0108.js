/**
 * 广度优先搜索，使用 Hash Map
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    if (!endWord || !wordList.includes(endWord)) return 0;
    const L = beginWord.length; // 每个单词的长度都相同，都为 L
    const genericDict = new Map(); // 生成通用词的 HashMap 词典
    wordList.forEach(word => {
        for (let i = 0; i < L; i++) {
            const gKey = word.substring(0, i) + '*' + word.substring(i + 1, L);
            if (!genericDict.has(gKey)) genericDict.set(gKey, []);
            genericDict.set(gKey, [...genericDict.get(gKey), word]);
        }
    });

    let queue = [[beginWord, 1]]; // 单词项：[word: 单词, trans: 到目前为止变换到该单词的转换次数]
    let visited = new Map(); // 记录每个单词的访问状态
    visited.set(beginWord, true);

    // BFS 处理 queue 中每个单词项
    while (queue.length > 0) {
        let item = queue.shift();
        let [word, trans] = [...item];
        for (let i = 0; i < L; i++) {
            // get the generic form of each word
            const gKey = word.substring(0, i) + '*' + word.substring(i + 1, L);
            if (genericDict.has(gKey)) {
                // beginword 中的通用单词可能不存在于 wordlist 的通用单词字典中
                const adjacentWords = genericDict.get(gKey);
                // 这里如果用 forEach 的写法，则无法提前 return，需要注意
                for (let j = 0; j < adjacentWords.length; j++) {
                    if (adjacentWords[j] == endWord) return trans + 1;
                    if (!visited.get(adjacentWords[j])) {
                        visited.set(adjacentWords[j], true);
                        queue.push([adjacentWords[j], trans + 1]);
                    }
                }
            }
        }
    }
    // 处理完之后，如果 beginword 中的通用单词可能不存在于 wordlist 的通用单词字典中，说明无法转换
    return 0;
};
