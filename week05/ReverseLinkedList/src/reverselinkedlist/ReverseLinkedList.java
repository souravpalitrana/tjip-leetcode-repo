/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author souravpalit
 */
public class ReverseLinkedList {

    // Time Complexity: O(n) Space Complexity: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;;
            current = next;
        }
        
        return prev;
    }
    
}
