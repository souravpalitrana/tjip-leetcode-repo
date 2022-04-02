/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class ThreeSumSolution {
    
    // Time complexity: O(n^2) Space Complexity: O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            // To remove duplicate
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            findThreeSum(nums, i, result); 
        }
        
        return result;
    }
    
    public static void findThreeSum(int[] nums, int i, List<List<Integer>> result) {
        int low = i + 1;
        int high = nums.length - 1;
        
        while (low < high) {
            int threeSum = nums[i] + nums[low] + nums[high];
            if (threeSum == 0) {
                List<Integer> list = new ArrayList<>();
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                // To remove duplicate
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            } else if (threeSum > 0) {
                high--;
            } else {
                low++;
            }
        }
    }
    
}
