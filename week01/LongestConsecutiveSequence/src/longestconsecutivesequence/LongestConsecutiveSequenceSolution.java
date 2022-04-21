/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class LongestConsecutiveSequenceSolution {
    
    // Time complexity: O(n) Space Complexity: O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        
        int lcsLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (isStartingValueOfASequence(numsSet, nums[i])) {
                int length = calculateConsecutiveSequenceLength(numsSet, nums[i]);
                lcsLength = Math.max(length, lcsLength);
            }
        }
        
        return lcsLength;
    }
    
    // Time complexity: O(1) Space Complexity: O(1)
    public boolean isStartingValueOfASequence(Set<Integer> lookup, int value) {
        return !lookup.contains(value - 1);
    }
    
    // Time complexity: O(k) where k is the longest consecutive sequence.
    // Though it seems this function is adding O(k) extra complexity but in
    // reality k will be less or equal to n and after calculating a sequence we
    // are not calculating those value again so thats why O(k) will not multiply
    // with the total time complexity
    public int calculateConsecutiveSequenceLength(Set<Integer> numsSet, int value) {
        int length = 0;
        
        while (length < numsSet.size()) {
            if (numsSet.contains(value + length)) {
                length++;
            } else {
                break;
            }
        }
        
        return length;
    }
}
