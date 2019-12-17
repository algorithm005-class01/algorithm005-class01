// 方法 1：有序字典
// 想法
// 题目要求实现 LRU 缓存机制，需要在 O(1) 时间内完成如下操作：
// 获取键 / 检查键是否存在
// 设置键
// 删除最近最少使用的数据值，可以简单理解为冷key
// 前两个操作可以用标准的哈希表在 O(1) 时间内完成。
// 复杂度分析
// 时间复杂度：对于 put 和 get 操作复杂度是 O(1)，因为有序字典中的所有操作：get/in/set/move_to_end/popitem（get/containsKey/put/remove）都可以在常数时间内完成。
// 空间复杂度：O(capacity)，因为空间只用于有序字典存储最多 capacity + 1 个元素。

//
// js中的有序字典Map Map的有序性实现参考https://www.jianshu.com/p/9b8be246f0f0
// Map 中的键值是有序的，而添加到对象中的键则不是。因此，当对它进行遍历时，Map 对象是按插入的顺序返回键值
// Map.prototype.keys() 返回一个新的 Iterator对象， 它按插入顺序包含了Map对象中每个元素的键 。
// 1、尾部元素一直是最新set的，对应于LRU的最近使用原则，简单理解为热key
// Map.set()
// 2、头部元素是最远使用的，简单理解为冷key，用于LRU容量满载时删除最远使用的元素，可获取其key
// Map.keys().next().value
// 解题步骤
// get
//  -元素存在 delete、set
//  -元素不存在 return -1
// put
//  -元素存在 delete、set
//  -元素不存在
//      -容量超出 delete map头部元素(最远不常用)、set
//      -没超 set

/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.cap = capacity;
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    // get一个key的时候先删除这个key再set这个key，会将这个key更新到尾部作为热key不会被优先删除
    let cache = this.cache;
    if(cache.has(key)){
        let val = cache.get(key);
        cache.delete(key);
        cache.set(key,val);
        return val;
    }else{
        return -1;
    }
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    // put一个key如果有的话先删除，或者如果size满了删除头部的冷key
    let cache = this.cache;   
    if(cache.has(key)){
        cache.delete(key);
    }else{
        if(cache.size == this.cap){
            cache.delete(cache.keys().next().value);
        }
    }
    cache.set(key,value);
};
