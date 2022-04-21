/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movezeros;

/**
 *
 * @author souravpalit
 */
public class MoveZerosSolution {
    
    // Time Complexity: O(n) Space Complexity: O(1)
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        int nonZeroPointer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[nonZeroPointer] != 0 && nums[zeroPointer] == 0) {
                int temp = nums[nonZeroPointer];
                nums[nonZeroPointer] = 0;
                nums[zeroPointer] = temp;
            } 
            
            if (nums[zeroPointer] == 0) {
                nonZeroPointer++;
            } else {
                zeroPointer++;
                nonZeroPointer++;
            }
        }
    }
    
    // Time Complexity: O(n) Space Complexity: O(1)
    public void moveZeroesAlternate(int[] nums) {
        int lastNonZeroFoundAt = 0;
        
        // At first we are moving all the non positive value to the left side
        // of the array.
        // Don't worry before replacing the old positive with new
        // positive the old positive will move more left
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt] = nums[i];
                lastNonZeroFoundAt++;
            }
        }
        
        // now we have all positive value at the first of the array but in our
        // array we have some duplicate value which we need to set zero
        // so in the lastNonZeroFoundAt - 1 is the value just we put the non zero
        // so from lastNonZeroFoundAt to last we can set all the value zero
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
       
}
