/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designhashmap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class MyHashMap {
    
    private int capacity = 2069;
    private List<Bucket> bucketList;
    
    
    public MyHashMap() {
        bucketList = new ArrayList<Bucket>();
        for (int i = 0; i < capacity; i++) {
            bucketList.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int hashKey = key % capacity;
        bucketList.get(hashKey).put(key, value);
    }
    
    public int get(int key) {
        int hashKey = key % capacity;
        return bucketList.get(hashKey).get(key);
    }
    
    public void remove(int key) {
        int hashKey = key % capacity;
        bucketList.get(hashKey).remove(key);
    }
    
    class Pair<U, V> {
        public U key;
        public V value;
        
        public Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    class Bucket {
        private List<Pair<Integer, Integer>> pairs;
        
        public Bucket() {
            pairs = new LinkedList<Pair<Integer, Integer>>();
        }
        
        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : pairs) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }
            
            return -1; // According to question
        }
        
        public void put(Integer key, Integer value) {
            boolean isAlreadyPresent = false;
            
            for (Pair<Integer, Integer> pair : pairs) {
                if (pair.key.equals(key)) {
                    isAlreadyPresent = true;
                    pair.value = value;
                }
            }
            
            if (!isAlreadyPresent) {
                pairs.add(new Pair<Integer, Integer>(key, value));
            }
        }
        
        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : this.pairs) {
                if (pair.key.equals(key)) {
                    this.pairs.remove(pair);
                    break;
                }
            }
        }
    }
}
