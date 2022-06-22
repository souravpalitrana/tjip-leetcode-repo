/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removenthnodefromendoflist;

/**
 *
 * @author souravpalit
 */
public class RemoveNthNodeFromEndOfList {
    
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);;
        dummy.next = head;
        
        ListNode frontNode = dummy;
        ListNode backNode = dummy;
        
        while (n >= 0) {
            frontNode = frontNode.next;
            n--;
        }
        
        while (frontNode != null) {
            frontNode = frontNode.next;
            backNode = backNode.next;
        }
        
        backNode.next = backNode.next.next;
       
        return dummy.next;
    }
    
}
