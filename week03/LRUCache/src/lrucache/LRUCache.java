/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class LRUCache {
    
    private int capacity;
    private int currentSize = 0;
    private DoublyLinkedList doublyLinkedList;
    private Map<Integer, DoublyLinkedListNode> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        doublyLinkedList = new DoublyLinkedList();
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            DoublyLinkedListNode node = cache.get(key);
            doublyLinkedList.setHead(node);
            return node.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            updateValue(key, value);
        } else {
            addNewValue(key, value);
        }
    }
    
    private void updateValue(int key, int value) {
        DoublyLinkedListNode newNode = cache.get(key);
        newNode.value = value;
        doublyLinkedList.setHead(newNode);
    }
    
    private void addNewValue(int key, int value) {
        currentSize++;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
        cache.put(key, newNode);
        doublyLinkedList.setHead(newNode);
        
        if (currentSize > capacity) {
            cache.remove(doublyLinkedList.tail.key);
            doublyLinkedList.removeTail();
            currentSize--;
        }
    }
}
