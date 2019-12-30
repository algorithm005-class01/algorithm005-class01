package week03;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordList)
            wordSet.add(word);

        // bfs
        LinkedList<Pair<String, Integer>> q = new LinkedList<>();
        q.addLast(new Pair<>(beginWord, 1));
        wordSet.remove(beginWord);

        HashSet<String> visited = new HashSet<>();

        while (!q.isEmpty()) {

            String curWord = q.getFirst().getKey();
            int curStep = q.getFirst().getValue();
            q.removeFirst();

            visited.clear();
            for (String word : wordSet) {
                if (similar(word, curWord)) {
                    if (word.equals(endWord))
                        return curStep + 1;
                    q.addLast(new Pair<>(word, curStep + 1));
                    visited.add(word);
                }
            }

            for (String word : visited)
                wordSet.remove(word);
        }

        return 0;
    }

    private boolean similar(String word1, String word2) {

        if (word1.length() != word2.length() || word1.equals(word2))
            throw new IllegalArgumentException();

        int diff = 0;
        for (int i = 0; i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        return true;
    }

}
