/**
 * 利用 JavaScript 中 Map （本质上是 Ordered Hashmap）
 */
class LRUCache {
    /**
     * 初始化容量大小为 capacity 的缓存
     * @param {number} capacity
     */
    constructor(capacity) {
        this.capacity = capacity;
        this.cache = new Map();
    }

    /**
     * @param {number} key
     * @return {number}
     */
    get(key) {
        // 访问到缓存
        if (this.cache.has(key)) {
            let val = this.cache.get(key);
            // 删除缓存 并添加到最前面
            this.cache.delete(key);
            this.cache.set(key, val);
            return val;
        }
        return -1;
    }

    /**
     * @param {number} key
     * @param {number} value
     * @return {void}
     */
    put(key, value) {
        if (this.cache.has(key)) {
            this.cache.delete(key);
        } else {
            if (this.cache.size === this.capacity) {
                // 使用迭代器获取第一个记录（对应的就是LRU Cache中最旧的元素）
                let last = this.cache.keys().next().value;
                this.cache.delete(last);
            }
        }
        this.cache.set(key, value);
    }
}
