/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlenumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class SingleNumberSolution {
    
    // Sorting
    // Time Complexity: O(nlogn) Space Complexity: O(1)
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                return nums[i];
            }
        }
        
        return nums[nums.length - 1];
    }
    
    // Hashmap
    // Time Complexity: O(n) Space Complexity: O(n)
    public int singleNumberFirstAlternate(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return 0;
    }
    
    // Bit : XOR operation 1 ^ 1 = 0 , 1 ^ 0 = 1 , 0 ^ 1 = 1, 0 ^ 0 = 0
    // Time Complexity: O(n) Space Complexity: O(1)
    public int singleNumberSecondAlternate(int[] nums) {
        int singleNumber = 0;
        
        for (Integer num : nums) {
            singleNumber ^= num;
        }
        
        return singleNumber;
    }
}
