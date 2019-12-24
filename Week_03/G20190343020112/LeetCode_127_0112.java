class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> dic = initDictionary(wordList);
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        visited.add(beginWord);
        int length = beginWord.length();
        while (queue.peek() != null) {
            Pair pair = queue.poll();
            int level = pair.v;
            for (int i = 0; i < length; i++) {
                List<String> words = dic.getOrDefault(genericWord(pair.k, i), new ArrayList<String>());
                for (String word: words) {
                    if (word.equals(endWord)) return level + 1;
                    if (!visited.contains(word)) {
                        queue.offer(new Pair(word, level + 1));
                        visited.add(word);
                    }
                }
            }
        }
        return 0;

    }

    private Map<String, List<String>> initDictionary(List<String> wordList) {
        Map<String, List<String>> dic = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String key = genericWord(word, i);
                List<String> list = dic.getOrDefault(key, new ArrayList<String>());
                list.add(word);
                dic.put(key, list);
            }
        });
        return dic;
    }

    private String genericWord(String word, int i) {
        char[] cs = word.toCharArray();
        cs[i] = '*';
        return String.valueOf(cs);
    }

    class Pair {
        String k;
        int v;

        public Pair(String k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}