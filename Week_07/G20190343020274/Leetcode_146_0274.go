package main

// Design and implement a data structure for Least Recently Used (LRU) cache. 
// It should support the following operations: get and put.

// get(key) - Get the value (will always be positive) of the key if the key 
// exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. 
// When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

// The cache is initialized with a positive capacity.

import (
	"fmt"
	"testing"
)

type Node struct {
	key int
	value int
	next *Node
	prev *Node
}

func newNode(key int, value int) *Node {
	return &Node{key, value, nil, nil}
}

type LRUCache struct {
    remain int
    head *Node
    tail *Node
}


func Constructor(capacity int) LRUCache {
    return LRUCache{capacity, nil, nil}
}


func (this *LRUCache) Get(key int) int {
	cur := this.getNode(key)
	if (nil == cur) {
		return -1
	}
	this.delete(cur)
	this.insertHead(cur)
	return cur.value
}

func (this *LRUCache) Put(key int, value int)  {
    cur := this.getNode(key)
    if (nil == cur) {
    	if (this.remain > 0) {
    		this.remain--
    	} else {
    		this.delete(this.tail)
    	}
    } else {
    	this.delete(cur)
    }
    this.insertHead(newNode(key, value))
}

func (this *LRUCache) getNode(key int) *Node {
    if this.head == nil {
    	return nil
    }
    for cur := this.head; cur != nil; cur = cur.next {
    	if cur.key == key {
    		return cur
    	}
    }	
    return nil
}

func (this *LRUCache) insertHead(node *Node) {
	if this.head == nil {
		this.head, this.tail = node, node
		node.prev, node.next = nil, nil
	} else {
		node.prev, node.next = nil, this.head
		this.head.prev = node
		this.head = node	
	}
}

func (this *LRUCache) delete(cur *Node) {
	if this.head == cur && this.tail == cur {
		this.head, this.tail = nil, nil
	} else if this.head == cur {
		this.head = this.head.next
		this.head.prev = nil
	} else if this.tail == cur {
		this.tail = this.tail.prev
		this.tail.next = nil
	} else {
		cur.prev.next, cur.next.prev = cur.next, cur.prev
	}
}

func (this *LRUCache)printlru() {
	fmt.Print("[")
	for cur := this.head; cur != nil; cur = cur.next {
		fmt.Print("(", cur.key, ",", cur.value, ") ")
	}
	fmt.Println("]")
}

func assertEqual(t *testing.T, a bool, err string) {
	if !a {
		t.Errorf(err)
	}
}


func TestSolution(t *testing.T) {
	lrucache := Constructor(2)
	lrucache.Put(1, 1)
	lrucache.printlru()
	lrucache.Put(2, 2)
	lrucache.printlru()
	assertEqual(t, lrucache.Get(1) == 1, "lrucache.Get(1) == 1")
	lrucache.printlru()
	lrucache.Put(3, 3)
	lrucache.printlru()
	assertEqual(t, lrucache.Get(2) == -1, "lrucache.Get(2) == -1")
	lrucache.printlru()
	lrucache.Put(4, 4)
	lrucache.printlru()
	assertEqual(t, lrucache.Get(1) == -1, "lrucache.Get(1) == -1")
	lrucache.printlru()
	assertEqual(t, lrucache.Get(3) == 3, "lrucache.Get(3) == 3")
	lrucache.printlru()
	assertEqual(t, lrucache.Get(4) == 4, "lrucache.Get(4) == 4")
	lrucache.printlru()
}

func TestSolution1(t *testing.T) {
	lrucache := Constructor(2)
	lrucache.Put(2, 1)
	lrucache.printlru()
	lrucache.Put(2, 2)
	lrucache.printlru()
	assertEqual(t, lrucache.Get(2) == 2, "lrucache.Get(1) == 1")
	lrucache.printlru()
}