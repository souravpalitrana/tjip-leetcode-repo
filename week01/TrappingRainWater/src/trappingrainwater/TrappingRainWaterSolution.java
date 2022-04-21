/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trappingrainwater;

/**
 *
 * @author souravpalit
 */
public class TrappingRainWaterSolution {

    // Time Complexity: O(n) and Space Complexity: O(n)
    public int trap(int[] height) {
        // We will first calculate the left maximum and the right maximum value
        // for each position
        int [] leftMaxHeight = new int [height.length];
        int [] rightMaxHeight = new int [height.length];
        
        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMaxHeight[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }
        
        int rightMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMaxHeight[i] = rightMax;
            rightMax = Math.max(rightMax, height[i]);
        }
        
        // Tapped water in a position will be 
        // min(leftMaxHeight[i], rightMaxHeight[i]) - height[i] if
        // min(leftMaxHeight[i], rightMaxHeight[i]) is bigger than heighti[]
        
        int totalTrappedWaterHeight = 0;
        for (int i = 0; i < height.length; i++) {
            int maxTappableHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (maxTappableHeight > height[i]) {
                totalTrappedWaterHeight += maxTappableHeight - height[i];
            }
        }
        
        return totalTrappedWaterHeight;
    }
    
}
