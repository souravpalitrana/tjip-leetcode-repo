/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

/**
 *
 * @author souravpalit
 */
public class DoublyLinkedListNode {
    
    public int key;
    public int value;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;
    
    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    } 
    
    public void removeBindings() {
        if (prev != null) {
            prev.next = next;
        }
        
        if (next != null) {
            next.prev = prev;
        }
        
        next = null;
        prev = null;
    }
}
