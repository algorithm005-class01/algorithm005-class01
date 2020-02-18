/**
 * 题目：127.单词接龙（https://leetcode-cn.com/problems/word-ladder/submissions/）
 * 学号：1034（五期一班三组）
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
const ladderLength = function (beginWord, endWord, wordList) {
    const getStatusKey = (word, k) => word.substr(0, k) + '*' + word.substr(k + 1), LEN = endWord.length;
    let statusTreeMap = new Map();
    for (let word of wordList) {
        for (let k = 0; k < LEN; k++) {
            let statusKey = getStatusKey(word, k);
            if (!statusTreeMap.has(statusKey)) {
                statusTreeMap.set(statusKey, []);
            }
            statusTreeMap.get(statusKey).push(word);
        }
    }
    let [visited, queue] = [new Set([beginWord]), [[beginWord, 1]]];
    while (queue.length > 0) {
        let [currWord, currLen] = queue.shift();
        for (let k = 0; k < LEN; k++) {
            let statusKey = getStatusKey(currWord, k);
            if (statusTreeMap.has(statusKey)) {
                for (let word of statusTreeMap.get(statusKey)) {
                    if (word === endWord) {
                        return currLen + 1;
                    } else if (!visited.has(word)) {
                        visited.add(word);
                        queue.push([word, currLen + 1]);
                    }
                }
                statusTreeMap.delete(statusKey);
            }
        }
    }
    return 0;
};