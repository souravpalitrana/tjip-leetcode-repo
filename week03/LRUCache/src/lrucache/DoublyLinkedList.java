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
public class DoublyLinkedList {
    
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;
    
    public void setHead(DoublyLinkedListNode node) {
        if (head == node) {
            // It is already in the head so don't need to move to head again
            return;
        } else if (head == null) {
            // first node to add in the list
            head = node;
            tail = node;
        } else if (head == tail) {
            // only one node and we have a new head
            head = node;
            head.next = tail;
            tail.prev = head;
        } else {
            if (tail == node) {
                // as it is accessed so it will move to head that means tail 
                // will change and will move to its previous node
                removeTail();
            }
            
            node.removeBindings();
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    public void removeTail() {
        if (tail == null) {
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
}
