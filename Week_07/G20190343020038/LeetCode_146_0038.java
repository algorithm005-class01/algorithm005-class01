class LRUCache {
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);//先检查key在不在
        if (node == null) {//key不存在，退出
            return -1;
        }
        if (node != tail) { //看node是不是最新最右的位置，如果最右不需要移动node,如果不是则继续
            if (node == head) {//node是否为head节点
                head = head.next;//是则 head空出来，因为最least的最左边
            } else {
                node.prev.next = node.next;//node非head的情况，移除node，将其放到尾部
                node.next.prev = node.prev;
            }
            tail.next = node;//在尾部最新位置添加node
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);//先检查node在不在
        if (node != null) {//如果node存在
            node.value = value;//先更新value
            if (node != tail) {//看node是不是最右最新，如果最右不需要做什么
                if (node == head) {//node是否是head节点
                    head = head.next;

                } else {//非head的普通节点
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;//更新最新的尾部节点
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        } else {//node不存在
            Node newNode = new Node(key, value);//新建node
            if (capacity == 0) {//当前map容量不足，则删除最旧的节点
                Node temp = head;
                head = head.next;
                map.remove(temp.key);//map中移除最旧节点的坐标
                capacity++;//空出一个容量位置
            }
            if (head == null && tail == null) {//node不存在且链表为空时
                head = newNode;//先收拾head部分
            } else {//链表不为空，且有空间，则在尾部插入新node
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);//添加新node, 并在map中标记
            capacity--;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */