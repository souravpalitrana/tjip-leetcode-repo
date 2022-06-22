/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeksortedlists;

/**
 *
 * @author souravpalit
 */
public class MergeKSortedLists {

    /**
     * Basically using the same technique of merge two list.
     * Time complexity: O(kn)
     * Space Complexity: O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        switch (lists.length) {
            case 0: return null;
            case 1: return lists[0];
        }
        
        ListNode firstListHead = lists[0];
        ListNode secondListHead = lists[1];
        
        ListNode mergeListJead = mergeTwoLists(firstListHead, secondListHead);
        
        for (int i = 2; i < lists.length; i++) {
            mergeListJead = mergeTwoLists(mergeListJead, lists[i]);
        }
        
        return mergeListJead;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode mergedList = dummy;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    mergedList.next = list1;
                    list1 = list1.next;
                } else {
                    mergedList.next = list2;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }

        return dummy.next;
    }
}
