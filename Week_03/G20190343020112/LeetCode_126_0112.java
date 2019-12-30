class Solution {
    private int length;
    private Map<String, List<String>> dic = new HashMap<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return res;
        this.length = beginWord.length();
        // 初始化映射词典
        wordList.forEach(word->{
            for (int i = 0; i < length; i++) {
                String key = genericWord(word, i);
                List<String> list = dic.getOrDefault(key, new ArrayList<String>());
                list.add(word);
                dic.put(key, list);
            }
        });

        return bfs(beginWord, endWord);

    }

    private List<List<String>> bfs(String beginWord, String endWord) {
        Queue<Pair<List<String>>> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, new ArrayList<String>(){{
            add(beginWord);
        }}));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean done  = false;
        while(queue.peek() != null) {
            Set<String> curVisited = new HashSet<>();
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Pair<List<String>> pair = queue.poll();
                String word = pair.key;
                for (int i = 0; i < length; i++) {
                    List<String> list = dic.getOrDefault(genericWord(word, i), new ArrayList<String>());
                    for(String w : list) {
                        if (visited.contains(w)) continue;
                        List<String> curList = new ArrayList<>(pair.value);
                        curList.add(w);
                        if (w.equals(endWord)) {
                            done = true;
                            res.add(curList);
                        } 
                        queue.offer(new Pair(w, curList));
                        curVisited.add(w);
                    }
                }
            }
            visited.addAll(curVisited);
            if (done) break;
        }
        return res;
    }

    private String genericWord(String word, int i) {
        char[] cs = word.toCharArray();
        cs[i] = '*';
        String key = String.valueOf(cs);
        return key;
    }

    class Pair<T>{
        String key;
        T value;

        public Pair(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }
}