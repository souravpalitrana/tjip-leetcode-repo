/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthlargestnumber;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author souravpalit
 */
public class KthLargestNumberSolution {
    
    // Time complexity O(nlogn) Space Complexity O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    // This is typical use of min heap. So at first we insert k element from the
    // start to the queue. Now we add one value and poll one value from heap. 
    // Logic is the heap will contains k item always. So after adding all value 
    // in the last heap has k element as it is min heap that means top value or
    // we can so min value of the heap is the kth largest value.
    // Time complexity O(nlogk) Space Complexity O(k)
    public int findKthLargestFirstAlternate(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (i >= k) {
                minHeap.poll();
            }
        }
        
        return minHeap.poll();
    }
}
