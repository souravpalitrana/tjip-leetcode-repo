/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistcycle;

/**
 *
 * @author souravpalit
 */
public class LinkedListCycle {

    // Time complexity: O(n) Space Complexity: O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode fastPointer = head.next;
        ListNode slowPointer = head;
        
        while (fastPointer != null && fastPointer.next != null) {
            if (fastPointer == slowPointer) {
                return true;
            }
            
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        return false;
    }
}
