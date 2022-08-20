/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestincreasingsubsequence;

/**
 *
 * @author souravpalit
 */
public class LongestIncreasingSubsequence {

    /*
    // Time complexity: O(n^2) SC: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int [] maxSequenceCounts = new int [nums.length];
        Arrays.fill(maxSequenceCounts, 1);
        int maxSequence = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxSequenceCounts[i] = Math.max(maxSequenceCounts[i], maxSequenceCounts[j] + 1);
                }
            }
            maxSequence = Math.max(maxSequence, maxSequenceCounts[i]);
        }
        
        return maxSequence;
    }*/
    
    // TC: O(nlogn) SC: O(n)
    public int lengthOfLIS(int[] nums) {
        int length = 0;
        int [] indices = new int [nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            int position = getLcsLengthWithThisValue(1, length, nums, indices,  nums[i]);
            indices[position] = i;
            length = Math.max(length, position);
        }
        return length;
    }
    
    private int getLcsLengthWithThisValue(
        int startIdx, 
        int endIdx,
        int [] nums, 
        int [] indices, 
        int currentNum
    ) {
        while (startIdx <= endIdx) {
            int mid = (startIdx + endIdx) / 2;
            if (nums[indices[mid]] < currentNum) {
                startIdx = mid + 1;
            } else {
                endIdx = mid - 1;
            }
        }
        
        return startIdx;
    }
    
}
