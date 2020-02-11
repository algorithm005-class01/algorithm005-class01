package g20190343020320

// 146.LRU缓存机制
// https://leetcode-cn.com/problems/lru-cache/

type LRUCache struct {
	Max    int
	Weight int
	Maps   map[int]*MyListNode
	Head   *MyListNode
	Tail   *MyListNode
}

type MyListNode struct {
	Key  int
	Val  int
	Next *MyListNode
	Prev *MyListNode
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		Max:  capacity,
		Maps: make(map[int]*MyListNode, capacity),
		Head: nil,
		Tail: nil,
	}
}

func (this *LRUCache) Get(key int) int {
	if v, ok := this.Maps[key]; ok {
		// 更新
		if this.Tail == v && v.Prev != nil {
			this.Tail = v.Prev
		}
		if this.Head != v {
			if v.Next != nil {
				v.Next.Prev = v.Prev
			}
			v.Prev.Next, v.Prev = v.Next, nil
			this.Head, this.Head.Prev, v.Next = v, v, this.Head
		}
		return v.Val
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if v := this.Get(key); v != -1 {
		this.Maps[key].Val = value
	} else {
		// 添加
		newNode := &MyListNode{
			Val:  value,
			Key:  key,
			Next: this.Head,
		}
		if this.Head != nil {
			this.Head.Prev = newNode
		}
		if this.Tail == nil {
			this.Tail = newNode
		}
		this.Head, this.Maps[key] = newNode, newNode

		// 清理
		if len(this.Maps) > this.Max {
			delete(this.Maps, this.Tail.Key)
			this.Tail, this.Tail.Prev = this.Tail.Prev, nil
			if this.Tail != nil {
				this.Tail.Next = nil
			}
		}
	}
}
