/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copylistwithrandompointer;

/**
 *
 * @author souravpalit
 */
public class Node {

    int val;
    Node next;
    Node random;

    Node() {
    }

    Node(int val) {
        this.val = val;
        this.random = null;
        this.next = null;
    }
}
