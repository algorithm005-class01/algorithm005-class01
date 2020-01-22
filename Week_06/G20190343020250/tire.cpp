struct TrieNode{
    bool isEnd;
    TrieNode* next[26];
}

class Trie{
private:
    bool isEnd;
    Trie* next[26];
public:
    Trie(){
        isEnd = false;
        memset(next , 0 , sizeof(next));
    }

    void insert(string word){
        Trie* node = this;
        for(char c : word){
            if ((node->next[c-'a']) == NULL)
            {
                node->next[c-'a'] = new Trie();  
            }
            node = node->next[c-'a'];
        }
        node->isEnd = true;
    }

    bool search(string word){
        Trie* node = this;
        for(char c: word){
            node = node->next[c-'a'];
            if(node == NULL){
                return false;
            }
        }
        return node->isEnd();
    }

    bool startsWith(string prefix) {
        Trie* node = this;
        for(char c: prefix){
            node = node->next[c-'a'];
            if(node == NULL){
                return false;
            }
        }
        return true;
    }

    void deleteWord(const string& word){
        if(!search(word)){
            return;
        }
        Trie* node = this;
        __deleteWord(node,word,0);
    }

    bool __deleteWord(Trie*& node,const string &word,int cnt){
        if(d == word.length()){
            node->isEnd = false;
        } else {
            __deleteWord(node->next[word[d] - 'a'], word,d+1);
        }
        
        if(node->isEnd){
            return;
        }
        
        for (Trie* item : node->next) {
            if (item != NULL) {
                return;
            }
        }
        delete node;
        node = NULL;
    }
};

