/**
 * @author boyang.lby
 * @date 5/16/17
 * @description
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {

    private int size = 0;
    private int capacity = 0;
    private Map<Integer, Node> cache = new HashMap<Integer,Node>();
    private Node head = new Node();
    private Node tail = new Node();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return ;
        }
        if(cache.containsKey(key)){
            cache.get(key).value = value;
            moveToHead(cache.get(key));
            return;
        }
        if(size + 1 > capacity){
            Node node = tail.pre;
            deleteNode(node);
            cache.remove(node.key);
        }
        Node newNode = new Node();
        newNode.key  = key;
        newNode.value = value;
        cache.put(key,newNode);
        addNode(newNode);
        size++;
    }

    public void moveToHead(Node node){
        deleteNode(node);
        addNode(node);
    }

    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addNode(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }



    class Node{
        int key;
        int value;
        Node pre;
        Node next;
    }
}
