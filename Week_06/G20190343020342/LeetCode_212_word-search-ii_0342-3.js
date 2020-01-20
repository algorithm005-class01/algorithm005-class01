// 优化版1
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    // 构建字典树
    class TrieNode{
        constructor(){
            this.END = false;
            this.children = {};
        }
    }
    let root = null;
    let Trie = function() {
        root  = new TrieNode();
    };
    Trie.prototype.insert = function(word) {
        let currNode = root;
        for(let i = 0;i < word.length;i++){
            if(currNode.children[word[i]] == undefined){
                currNode.children[word[i]] = new TrieNode();
            }
            currNode = currNode.children[word[i]];
        }
        currNode.END = true;
    };
    let searchPrefix = (word) => {
        let currNode = root;
        for(let i = 0;i < word.length;i++){
            if(currNode.children[word[i]]){
                currNode = currNode.children[word[i]];
            }else{
                return null;
            }
        }
        return currNode;
    }
    Trie.prototype.search = function(word) {
        let currNode = searchPrefix(word);
        return currNode != null && currNode.END;
    };
    Trie.prototype.startsWith = function(prefix) {
        return searchPrefix(prefix) != null;
    };
    // 初始化变量
    let m = board.length;
    let n = board[0].length;
    // 初始化字典树
    let wordsTrie = new Trie();
    for(let i = 0;i < words.length;i++){
        wordsTrie.insert(words[i]);
    }
    // DFS 搜索
    let boardDFS = (i,j,curStr) => {
        let restore = board[i][j];
        curStr += restore; 
        // 字典树中找到了
        if(wordsTrie.search(curStr) && result.indexOf(curStr) == -1){
            result.push(curStr);            
        }
        // 减枝 - 拼接字符判断是否存在于字典树中，如果前缀都不是，直接false
        if(!wordsTrie.startsWith(curStr)){
            return;
        }
        // 前进
        board[i][j] = '#';
        if(i > 0 && board[i-1][j] != '#'){
            boardDFS(i-1,j,curStr);                           
        }
        if(i + 1 < m && board[i+1][j] != '#'){
            boardDFS(i+1,j,curStr); 
        }
        if(j > 0 && board[i][j-1] != '#'){
            boardDFS(i,j-1,curStr);                           
        }
        if(j + 1 < n && board[i][j+1] != '#'){
            boardDFS(i,j+1,curStr); 
        }
        // 还原(回溯)
        board[i][j] = restore;
    }
    // 寻找结果
    let result = [];
    for(let i = 0;i < m;i++){
        for(let j = 0;j < n;j++){
            boardDFS(i,j,''); 
        }
    }
    return result;
};