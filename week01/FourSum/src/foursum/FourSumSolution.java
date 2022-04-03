/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class FourSumSolution {

    // Time Complexity: O(n^3) Space Complexity: O(n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> resultSet = new HashSet<String>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            fourNumberSum(nums, target, i + 1, result, resultSet);
        }

        return result;
    }

    public void fourNumberSum(
            int[] array,
            int targetSum,
            int start,
            List<List<Integer>> result,
            Set<String> resultSet
    ) {

        int previous = array[start - 1];
        for (int i = start; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int currentSum = previous + array[i] + array[left] + array[right];
                
                if (currentSum == targetSum ) {
                    String resultKey = getResultKey(previous, array[i], array[left], array[right]);
                    if (!resultSet.contains(resultKey)) {
                        result.add(Arrays.asList(previous, array[i], array[left], array[right]));
                        resultSet.add(resultKey);
                    }
                    
                    left++;
                    
                } else if (currentSum > targetSum) {
                    // need smaller number
                    right--;
                } else {
                    left++;
                }
            }
        }
    }
    
    private String getResultKey(int first, int second, int third, int fourth) {
        return first + "-" + second + "-" + third + "-" + fourth;
    }
}
