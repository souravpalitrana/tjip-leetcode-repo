/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addtwonumbers;

/**
 *
 * @author souravpalit
 */
public class AddTwoNumbersSolution {

    /**
     * Approach 1: Convert linkedlist 1 to a number and convert linkedlist 2 to 
     * a number. Calculate the sum. Now convert the sum to string and place all
     * the digit to a linked list in reverse order.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    
    /**
     * Approach 2: Iterate simultaneously. Add two value and put to a new list.
     * Need to carry forward the carry.
     * Time Complexity: O(max(m,n))
     * Space Complexity: O(max(m,n))
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        int carry = 0;
        
        ListNode currentSumNode = dummyHead;
        
        while (l1 != null || l2 != null || carry != 0) {
            int firstDigit = (l1 != null) ? l1.val : 0;
            int secondDigit = (l2 != null) ? l2.val : 0;
            
            int sum = firstDigit + secondDigit + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            currentSumNode.next = new ListNode(sum);
            currentSumNode = currentSumNode.next;
            
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        
        return dummyHead.next;
    }
}
