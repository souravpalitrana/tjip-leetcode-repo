/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestnumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author souravpalit
 */
public class LargestNumberSolution {
    
    // Main trick part is in the comparator. For two value we generate ab and ba
    // then compare which one is large and sort the values based on that.
    // Time Complexity: O(nlogn) (Not 100% sure as for each comparison we are
    // doing 2 string concatenation
    // Space Complexity: O(n)
    public String largestNumber(int[] nums) {
        String [] newNums = mapToStringArray(nums);
        sort(newNums);
        return generateStringNumber(newNums);       
    }
      
    public String [] mapToStringArray(int [] nums) {
        String [] newNums = new String[nums.length]; 
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = String.valueOf(nums[i]);;
        }      
        return newNums;
    }
    
    public void sort(String [] nums) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        });
    }
    
    public String generateStringNumber(String [] nums) {
        // If first number of a digit 0 that means all other digits are also 0
        // so we need to return only 0 in that case
        if (nums[0].equals("0")) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (String num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }
}
