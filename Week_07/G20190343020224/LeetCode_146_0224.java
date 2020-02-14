class LRUCache {

    private final int capacity;

    private LinkedList<Integer> lruQueue;

    private Map<Integer, Integer> storageMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lruQueue = new LinkedList<>();
        this.storageMap = new HashMap<>();
    }

    public int get(int key) {
        if (!storageMap.containsKey(key)) {
            return -1;
        }
        lruQueue.remove(Integer.valueOf(key));
        lruQueue.offerFirst(key);
        return storageMap.get(key);
    }

    public void put(int key, int value) {
        if (storageMap.containsKey(key)) {
            lruQueue.remove(Integer.valueOf(key));
        } else if (lruQueue.size() >= capacity) {
            storageMap.remove(lruQueue.removeLast());
        }
        storageMap.put(key, value);
        lruQueue.offerFirst(key);
    }

}