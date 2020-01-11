class Solution {    
    public int ladderLength(String beginWorld, String endWord, List<String> wordList) {
        Set<String> stringSet = new HashSet<String>();
        for (String s : wordList) stringSet.add(s);
        if (!stringSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWorld);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                String currentWorld = queue.poll();
                char[] worldChars = currentWorld.toCharArray();
                for (int j = 0; j < worldChars.length; ++j) {
                    char originalChar = worldChars[j];
                    for (char c = 'a'; c < 'z'; ++c) {
                        if (worldChars[j] == c) continue;
                        worldChars[j] = c;
                        String newWorld = String.valueOf(worldChars);
                        if (newWorld.equals(endWord)) return level + 1;
                        if (stringSet.contains(newWorld)) {
                            queue.offer(newWorld);
                            stringSet.remove(newWorld);
                        }
                    }
                    worldChars[j] = originalChar;
                }
            }
            ++ level;
        }
        return 0;
    }
}
