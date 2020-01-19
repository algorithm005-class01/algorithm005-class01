#解法1：字典树 + dfs 
def findWords(board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """ 
        #dfs
        def dfs(i,j,t,s):
            ch = board[i][j]
            if ch not in t:
                return             #递归终止条件
            t = t[ch]              #当前层处理逻辑
            if "end" in t and t['end'] == 1: #word 在board里
                res.append(s+ch)
                t['end'] = 0
            board[i][j] = '#'           #drill down
            if i + 1 < m and board[i+1][j] != '#':
                dfs(i+1,j,t,s+ch)
            if i - 1 >= 0 and board[i-1][j] != '#':
                dfs(i-1,j,t,s+ch)
            if j + 1 < n and board[i][j+1] != '#':
                dfs(i,j+1,t,s+ch)
            if j - 1 >= 0 and board[i][j-1] != '#':
                dfs(i,j-1,t,s+ch)
            board[i][j] = ch   # reverse state

        #把单词存入字典树中
        trie = {}
        for word in words:
            t = trie
            print("0",t)
            for ch in word:
                if ch not in t:
                    t[ch] = {}
                    print("1",t)
                t = t[ch]
                print("2",t)
            t['end'] = 1
        print("3",trie)
        
        #对board 进行深度优先遍历
        m, n  = len(board),len(board[0])
        res = []
        for i in range(m):
            for j in range(n):
                dfs(i,j,trie,'')
        return res

# 解法2：字典树 + dfs， 比解法1 只是写法不一样，把字典树单独建了一个类
class TrieNode():
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isWord = False
    
class Trie():
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for w in word:
            node = node.children[w]
        node.isWord = True
    
    def search(self, word):
        node = self.root
        for w in word:
            node = node.children.get(w)
            if not node:
                return False
        return node.isWord

class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        trie = Trie()
        node = trie.root
        for w in words:
            trie.insert(w)
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board,node,i,j,'',res)
        return res

    def dfs(self,board,node,i,j,path,res):
        if node.isWord:
            res.append(path)
            node.isWord = False
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return
        temp = board[i][j]
        node = node.children.get(temp)
        if not node:
            return 
        board[i][j] = '#'

        self.dfs(board,node,i+1,j,path + temp, res)
        self.dfs(board,node,i-1,j,path + temp, res)
        self.dfs(board,node,i,j+1,path + temp, res)
        self.dfs(board,node,i,j-1,path + temp, res)

        board[i][j] = temp  

#解法3：复数的知识简化操作
class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        root = {}
        for word in words:
            node = root
            for c in word:
                node = node.setdefault(c, {})
            node[None] = True
        board = {i + 1j*j: c
                 for i, row in enumerate(board)
                 for j, c in enumerate(row)}

        found = []
        def search(node, z, word):
            if node.pop(None, None):
                found.append(word)
            c = board.get(z)
            if c in node:
                board[z] = None
                for k in range(4):
                    search(node[c], z + 1j**k, word + c)
                board[z] = c
        for z in board:
            search(root, z, '')

        return found
        
