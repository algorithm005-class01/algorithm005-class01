package main.leetcode_solutions.hashtable;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/9 8:49 PM
 */
public class T146_LRUCache {

    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int capacity;

    public T146_LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (null != cache.get(key)){
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (null != cache.get(key)){
            Node node = cache.get(key);
            moveToHead(node);
            node.value = value;
        } else{
            Node node = new Node(key, value);
            if (cache.size() >= capacity){
                Node last = removeLast();
                cache.remove(last.key);
            }
            insertToHead(node);
            cache.put(key, node);
        }
    }

    private void moveToHead(Node node){
        remove(node);
        insertToHead(node);
    }

    private void remove(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void insertToHead(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private Node removeLast(){
        Node last = tail.pre;
        remove(last);
        return last;
    }

    private class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
