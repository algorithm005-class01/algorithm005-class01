#解法1 存储在字典里
#class TrieNode():
#    def __init__(self):
#        self.nodes = [None] * 26
#        self.last = False

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashtable = {}

        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        tree = self.hashtable

        for a in word:
            if a not in tree:
                tree[a] = {}
            tree = tree[a]
        tree['#'] = '#'
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        tree = self.hashtable
        for a in word:
            if a not in tree:
                return False
            tree = tree[a]
        if  "#" in tree:
            return True
        return False        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        tree = self.hashtable
        for a in prefix:
            if a not in tree:
                return False
            tree = tree[a]
        return True
        
        
