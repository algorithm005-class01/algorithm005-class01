package Week_07.G20190343020220.leetcode_146_0220;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Darcy
 * @date 2020-02-09 10:24
 */
public class LRUCache {
    private Map<Integer, Node> map;
    private DoubleList cache;
    private Integer cap;


    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }


        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }


        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }


        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }


        public int size() {
            return size;
        }


    }

    class Node {
        public Node prev, next;
        public Integer k;
        public Integer v;

        public Node() {
        }

        public Node(Integer k, Integer v) {
            this.k = k;
            this.v = v;
        }
    }


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).v;

        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);
        /*缓存中包含*/
        if (map.containsKey(key)) {
            /*删除原位置*/
            cache.remove(map.get(key));
            /*添加到缓存头部*/
        } else {
            /*cache已经满了*/
            if (cap == cache.size()) {
                /*移除末尾的*/
                Node last = cache.removeLast();
                /*更新hash*/
                map.remove(last.k);
            }

        }
        cache.addFirst(x);
        map.put(key, x);
    }
}
