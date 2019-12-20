// 方法 2：哈希表 + 双向链表
// 想法
// 这个问题可以用哈希表，辅以双向链表记录键值对的信息。所以可以在 O(1) 时间内完成 put 和 get 操作，同时也支持 O(1) 删除第一个添加的节点。
// 使用双向链表的一个好处是不需要额外信息删除一个节点，同时可以在常数时间内从头部或尾部插入删除节点。
// 复杂度分析
// 时间复杂度：对于 put 和 get 都是 O(1)。
// 空间复杂度：O(capacity)O(capacity)，因为哈希表和双向链表最多存储 capacity + 1 个元素。

// 思路
// 哈希表
// 查找：O(1)，数据无序，但插入删除慢
// 双链表
// 插入、删除：O(1)，数据有序，但查找慢

// 伪代码
// 实现哈希表
// 实现双链表
// let LRUCache = function(capacity) {
//     初始化容量，用于判断LRU是否已满
//     初始化哈希表映射，用于查找节点
//     初始化双链表，用于插入、删除节点
// };
// LRUCache.prototype.get = function(key) {
//     if(哈希查找 不存在){
//         return -1;
//     }else{
//         将此节点置于开头，为最近访问节点
//         return 节点值
//     }
// }
// LRUCache.prototype.put = function(key, value) {
//     if(哈希查找 已经存在){
//         删除旧的数据
        
//     }else{
//         if(LRU 即 双链表已满){
//             删除尾节点
//             更新哈希映射值，并将更新后的节点置于开头
//         }
//         将新节点置于开头
//         新建新节点的哈希映射
//     }
// }

// 链表节点
class Node{
    constructor(key, val, prev, next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
// 双链表
class DoubleList{
    // 初始化头、尾节点、链表最大容量
    constructor(){
        // 头
        this.head = new Node(0,0);
        // 尾
        this.tail = new Node(0,0);
        // 容量
        this.size = 0;
        // 头的next指向尾
        this.head.next = this.tail;
        // 尾的prev指向头
        this.tail.prev = this.head;
    }
    // 在链表头部添加节点，相当于在head和head的next节点中间增加了一个node
    addFirst(node){
        // 节点的next指向head的next
        node.next = this.head.next;
        // 节点的prev指向head
        node.prev = this.head;
        // head的next的prev指向这个node
        this.head.next.prev = node;
        // head的next指向node
        this.head.next = node;
        // 增加链表容量
        this.size++;
    }
    // 删除链表中存在的node节点，即将两个节点中的node关联去掉
    remove(node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.size--;
    }
    // 删除链表中最后一个节点，并返回该节点
    removeLast(){
        // 链表为空，尾部的prev等于head
        if(this.tail.prev == this.head){
            return null;
        }
        // last为尾部的prev
        let last = this.tail.prev;
        this.remove(last);
        return last;
    }
}
/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.cap = capacity;
    this.map = new Map();
    this.cache = new DoubleList();
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    let map = this.map;
    if(!map.has(key)){
        return -1;
    }
    let val = map.get(key).val;
    // 最近访问数据置前
    this.put(key,val);
    return val;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    let cache = this.cache;
    let map = this.map;
    let node = new Node(key,value);
    if(map.has(key)){
        // 删除旧的节点，新的插到头部
        cache.remove(map.get(key));
    }else{
        if(this.cap == cache.size){
            // 删除最后一个
            let last = cache.removeLast();
            map.delete(last.key);
        }
    }
    // 新增头部
    cache.addFirst(node);
    // 更新 map 映射
    map.set(key,node);
};
