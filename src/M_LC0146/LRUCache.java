package M_LC0146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;

    }

    public void put(int key, int val){
        Node x = new Node(key, val);
        if(map.containsKey(key)){
            //删除旧节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        }else{
            if(cap == cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
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
    private Node head, tail;//头尾虚节点
    private int size;//链表元素个数

    public DoubleList(){
        head = new Node(0, 0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //在链表头部添加节点x
    public void addFirst(Node x){
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    //删除链表中的x节点(x一定存在)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除链表最后一个节点
    public Node removeLast(){
        if(tail.prev == head){
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    //返回链表长度
    public int size(){return size;}
}
