class Solution {

    public static class Pair<K, V> {

        private K key;

        public K getKey() {
            return key;
        }

        private V value;

        public V getValue() {
            return value;
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();

        // key: 如a*b  value:和key有关的字符串
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>(16);

        // 初始化key value,构造所有key
        wordList.forEach(
                word -> {
                    for (int i = 0; i < length; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                        ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        HashSet<String> visited = new HashSet<>(16);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < length; i++) {
                // 拼出当前单词的key，是否可以在"词典"中找到
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);

                // 找相邻的词
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

}