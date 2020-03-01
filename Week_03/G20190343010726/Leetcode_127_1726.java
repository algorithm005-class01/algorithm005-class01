public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        
        set1.add(start);
        set2.add(end);
        
        return helper(dict, set1, set2, 1);
    }
    
    int helper(Set<String> dict, Set<String> set1, Set<String> set2, int level) {
        if (set1.isEmpty()) return 0;
        
        if (set1.size() > set2.size()) return helper(dict, set2, set1, level);
        
        // remove words from both ends
        for (String word : set1) { dict.remove(word); };
        for (String word : set2) { dict.remove(word); };
        
        // the set for next level
        Set<String> set = new HashSet<String>();
        
        // for each string in the current level
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                
                // change letter at every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);
                    
                    // found the word in other end(set)
                    if (set2.contains(word)) {
                        return level + 1;
                    }
                    
                    // if not, add to the next level
                    if (dict.contains(word)) {
                        set.add(word);
                    }
                }
            }
        }
        
        return helper(dict, set2, set, level + 1);
    }
}