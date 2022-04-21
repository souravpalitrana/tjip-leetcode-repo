/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorityelement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class MajorityElementSolution {
    
    // As majority definition is more than n/2 that means if we sort the array
    // then at least it will cross the middle of the array. So we can pick the
    // middle value
    // Time Complexity O(nlogn) Space Complexity: O(1)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    // Frequency count technique
    // Time Complexity: O(n) Space Complexity: O(n)
    public int majorityElementFirstAlternate(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        int majorityNum = nums[0];
        for (Integer num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
            if (frequencyMap.get(num) > maxFrequency) {
                maxFrequency = frequencyMap.get(num);
                majorityNum = num;
            }
        }
        return majorityNum;
    }
    
    // Voting Algorithm Technique. But this will work because of the definition
    // of the majority matched the voting algorithm technique. If the majority 
    // definition is not n/2 then we could not apply this algorithm. 
    // Time complexity:: O(n) Space Complexity: O(1)
    public int majorityElementSecondAlternate(int[] nums) {
        int winner = 0;
        int voteCount = 0;
        
        for (Integer candidate : nums) {
            if (voteCount == 0) {
                winner = candidate;
                voteCount = 1;
            } else if (winner == candidate) {
                voteCount++;
            } else {
                voteCount--;
            }
        }
        
        return winner;
    }
}
