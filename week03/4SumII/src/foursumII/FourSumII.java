/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursumII;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class FourSumII {
    
    // Checking all possible combination.
    // TLE; However Time Complexity: O(n^4) Space Complexity: O(1)
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int total4SumCount = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        int sum = nums1[i] + nums2[j] + nums3[k] + nums4[l];
                        if (sum == 0) {
                            total4SumCount++;
                        }
                    }
                }
            }
        }
        
        return total4SumCount;
    }
    
    
    // Time Complexity: O(n^2) for both generating two sum and checking another 
    // Space Complexity: O(n^2) for storing all the combination of two array of 
    // n length
    public int fourSumCountAlternate(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> twoSums = new HashMap<>();
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                twoSums.put(sum, twoSums.getOrDefault(sum, 0) + 1);
            }
        }
        
        int totalCount = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                totalCount += twoSums.getOrDefault(-sum, 0);
            }
        }
        
        return totalCount;
    }
    
}
