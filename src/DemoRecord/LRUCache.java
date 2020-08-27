package DemoRecord;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    //最大容量
    private int cap;
    public LRUCache(int capacity){
        map = new HashMap<>();
        cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        put(key, node.val);
        return node.val;
    }

    public void put(int key, int val){
        Node node = new Node(key, val);
        if(map.containsKey(key)){
            //删除旧节点
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        }else{
            //如果容量满了
            if(cap == cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }

}

class Node{
    public int key, val;
    public Node next, prev;
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}
class DoubleList{
    private Node head, tail;
    private int size;
    public DoubleList(){
        head = new Node(0, 0);
        tail = new Node(0, 0 );
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
    //在链表头加节点x
    public void addFirst(Node x){
        Node next = head.next;
        head.next = x;
        x.prev = head;
        x.next = next;
        next.prev = x;
        size++;
    }

    //删除链表中的x节点(x一定存在)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除链表中的最后一个节点,并返回该节点
    public Node removeLast(){
        if(tail.prev == head)
            return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size(){
        return size;
    }

}