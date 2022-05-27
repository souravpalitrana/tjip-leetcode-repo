/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumtwinsumofalinkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author souravpalit
 */
public class MaximumTwinSumOfALinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity:: O(n)
     */
    public int pairSum(ListNode head) {
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        ListNode current = head;
        int index = 0;

        while (current != null) {
            visited.put(index, current.val);
            index++;
            current = current.next;
        }

        int n = visited.size();
        int maxTwinSum = Integer.MIN_VALUE;

        for (Entry<Integer, Integer> entry : visited.entrySet()) {
            int i = entry.getKey();
            int twinIdx = n - 1 - i;
            int twinSum = entry.getValue() + visited.get(twinIdx);;
            maxTwinSum = Math.max(twinSum, maxTwinSum);
        }

        return maxTwinSum;
    }
    
    /**
     * First find the mid. Then reverse the remaining part from the mid.
     * Now we have two parts. One is head to mid and other is mid + 1 to rest.
     * Now add sequentially with partOne with partTwo and calculate maxTwin sum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int pairSumOptimized(ListNode head) {
        ListNode fastPointer = head.next;
        ListNode slowPointer = head;
        int maxTwinSum = Integer.MIN_VALUE;
        
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        
        ListNode twinOne = head;
        ListNode twinTwo = revere(slowPointer.next);
        
        while (twinTwo != null) {
            int twinSum = twinOne.val + twinTwo.val;
            maxTwinSum = Math.max(twinSum, maxTwinSum);
            twinOne = twinOne.next;
            twinTwo = twinTwo.next;
        }

        return maxTwinSum;
    }
    
    public ListNode revere(ListNode head) {
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
