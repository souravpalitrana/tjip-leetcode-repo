/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author souravpalit
 */
public class Subsets {

    // Time Complexity: O(N * 2^N)
    // Space Complexity:: O(N * 2^N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<Integer>());
        
        for (int value : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            
            for (List<Integer> sets : allSubsets) {
                List<Integer> newSet = new ArrayList<>();
                newSet.addAll(sets);
                newSet.add(value);
                newSubsets.add(newSet);
            }
            
            allSubsets.addAll(newSubsets);
        }
        
        return allSubsets;
    }
    
    // Backtrack
    // Time Complexity: O(N * 2^N)
    // Space Complexity:: O(N * 2^N)
    List<List<Integer>> allSubsets;
    public List<List<Integer>> subsetsAlternate(int[] nums) {
        allSubsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<Integer>());
        return allSubsets;
    }
    
    private void generateSubsets(int [] nums, int idx, List<Integer> currentSets) {
        if (idx == nums.length) {
            List<Integer> newSets = new ArrayList<>();
            newSets.addAll(currentSets);
            allSubsets.add(newSets);
            return;
        }
        
        currentSets.add(nums[idx]);
        generateSubsets(nums, idx + 1, currentSets);
        currentSets.remove(currentSets.size() - 1);
        generateSubsets(nums, idx + 1, currentSets);
    }
    
}
