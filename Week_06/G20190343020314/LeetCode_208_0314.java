package week06;

import java.util.HashMap;

/**
 * Description: 实现 Trie (前缀树).
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_208_0314 {
  public class Trie {
    
    private TrieNode root;
    
    class TrieNode {
      
      private HashMap<Character, TrieNode> children = new HashMap<>();
      
      //private String content;
      
      private boolean wordFlag;
      
      public HashMap<Character, TrieNode> getChildren() {
        return children;
      }
      
      public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
      }
      
      public boolean getWordFlag() {
        return wordFlag;
      }
      
      public void setWordFlag(boolean wordFlag) {
        this.wordFlag = wordFlag;
      }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
      root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
      TrieNode current = root;
      
      for (int i = 0; i < word.length(); i++) {
        current = current.getChildren()
            .computeIfAbsent(word.charAt(i), c -> new TrieNode());
      }
      current.setWordFlag(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      TrieNode current = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
          return false;
        }
        current = node;
      }
      return current.getWordFlag();
      
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      TrieNode current = root;
      for (int i = 0; i < prefix.length(); i++) {
        char ch = prefix.charAt(i);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
          return false;
        }
        current = node;
      }
      return true;
      
    }
    
    
  }
}
