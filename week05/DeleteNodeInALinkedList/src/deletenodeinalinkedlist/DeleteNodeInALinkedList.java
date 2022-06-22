/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletenodeinalinkedlist;

/**
 *
 * @author souravpalit
 */
public class DeleteNodeInALinkedList {

    // Time Complexity: O(1) Space Complexity: O(1)
    public void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next; 
    }

}
