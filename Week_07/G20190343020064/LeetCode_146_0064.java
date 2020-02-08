package G20190343020064;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * LRU缓存机制
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-07 10:17 下午
 */
public class LeetCode_146_0064 {

    /**
     * 通过继承 LinkedHashMap 有序哈希表直接使用LRU功能
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            // accessOrder 指该链表的顺序排列
            // true 按照读取的顺序 即LRU顺序
            // false 按照插入顺序
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        //===============================================================================
        //  在新增之后调用该方法
        //  是否删除最旧的元素策略  默认为 false
        //  这里重写之后 当map的size 大于 容量capacity 时，则删除最旧元素 保持容器最大缓存容量不变
        //===============================================================================
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

    }

    class LRUCache2 {

        class Node {

            public Node(int key,int value){
                this.value = value;
                this.key = key;
            }

            int key;
            int value;
            Node pre;
            Node next;
        }

        /**
         * 在头插入节点
         * @param node
         */
        public void addNode(Node node) {
            node.pre = head;
            node.next = head.next;

            head.next.pre = node;
            head.next = node;
        }

        /**
         * 将节点移到头部
         * @param node
         */
        public void moveToHead(Node node){
            this.removeNode(node);
            this.addNode(node);
        }

        /**
         * 删除节点
         * @param node
         */
        public void removeNode(Node node){
            Node pre = node.pre;
            Node next = node.next;

            pre.next = next;
            next.pre = pre;
        }

        /**
         * 删除尾部元素
         */
        public void removeTailNode(){
            Node pre = tail.pre;
            this.removeNode(pre);
        }

        private int capacity;
        private Node head, tail;
        private HashMap<Integer, Node> map;


        public LRUCache2(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node(-1,-1);
            tail = new Node(-1,-1);

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {return -1;}
            moveToHead(node);
            return node.value;
        }

        /**
         * 注意 put(1,2) put(1,3) 替换之后，需要移动位置
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                Node newNode = new Node(key,value);
                map.put(key,newNode);
                addNode(newNode);
                if (map.size() > capacity) {
                    map.remove(tail.pre.key);
                    removeTailNode();
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

    }


}
