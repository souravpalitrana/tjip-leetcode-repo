/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designlinkedlist;

/**
 *
 * @author souravpalit
 */
public class MyLinkedList {

    public Node head;
    public int size = 0;

    public MyLinkedList() {
        head = new Node(Integer.MIN_VALUE, null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node current = head.next;
        
        while (index > 0) {
            current = current.next;
            index--;
        }
        
        return current.value;
    }

    public void addAtHead(int val) {
        add(0, val);
    }

    public void addAtTail(int val) {
        add(size, val);
    }

    public void addAtIndex(int index, int val) {
        add(index, val);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        Node current = head;
        
        while (index > 0) {
            current = current.next;
            index--;
        }
        
        Node tempNode = current.next;
        current.next = current.next.next;
        tempNode = null;
        size--;
    }

    private void add(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        
        Node current = head;

        while (index > 0) {
            current = current.next;
            index--;
        }

        Node newNode = new Node(val, null);
        Node tempNode = current.next;
        current.next = newNode;
        newNode.next = tempNode;
        size++;
    }
}
