// 解法二：简化Trie + DFS
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
    // 搜索方向向量
    let dx = [-1,1,0,0];
    let dy = [0,0,-1,1];
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
        for(let r = 0; r < 4;r++){
            let tmp_i = dx[r] + i;
            let tmp_j = dy[r] + j;
            // 边界情况处理
            if(tmp_i >= 0 && tmp_i < m && tmp_j >= 0 && tmp_j < n && board[tmp_i][tmp_j] != '#'){
                boardDFS(tmp_i,tmp_j,curStr);                           
            }
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