/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstmissingpositive;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class FirstMissingPositiveSolution {
    
    // we are going to run a loop from 1 to length + 1 because if all value
    // present it will place in each position. If any value is missing that 
    // means we will get that by checking in this length.
    // Time Complexity : O(n) Space Complexity: O(n)
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        
        for (Integer num : nums) {
            numsSet.add(num);
        }
        
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!numsSet.contains(i)) {
                return i;
            }
        }
        
        return 0;
    }
    
    // First we scan the input array and set the value of a index negative.
    // This negative means we got the value which help us to avoid using set in
    // the first solution
    // Time Complexity: O(n) Space Complexity: O(1)
    public int firstMissingPositiveAlternate(int [] nums) {
        // checking if 1 contains
        // because if 1 is not present than we can return 1 as it is the first
        // positive value 
        boolean containsOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                containsOne = true;
                break;
            }
           
        }
        
        if (!containsOne) {
            return 1;
        }
        
        // As we have at least 1 one so we can set all negative and zero value to
        // 1. Otherwise when we multiply -1 with 0 it will remain 0 always. Which
        // requires extra condition to handle. 
        // Again we can set those values to 1 which is greater than nums.length
        // as we will not checking those values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            
            if (num == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[num] = -Math.abs(nums[num]);
            }
        }
        
        // Checking if all the value present by checking they are negative. If 
        // positive that means it is not present.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        
        // As we checked from 1 so last value we did not checked as we put it
        // in [0] position
        if (nums[0] > 0) {
            return nums.length;
        } else {
            return nums.length + 1;
        }
    }
    
}
