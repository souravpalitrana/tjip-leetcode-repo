/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package romantointeger;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class RomanToIntegerSolution {
     
    // Time Complexity: O(1) Space Complexity: O(1)
    // Checking from first to last except last we will take 2 digit at a time
    // using substring and check it is present in hashmap or not. If present we
    // add the value and increment the position by two. If not that means it is
    // single digit get value by converting current digit to string and increment
    // the position by 1.
    public int romanToInt(String s) {
        Map<String, Integer> romanToNumberMap = new HashMap<String, Integer>();
        initRomanToNumberMap(romanToNumberMap);
        
        int value = 0;
        int position = 0;
        
        while (position < s.length()) {
            char digit = s.charAt(position);
            
            if (position == s.length() - 1) {
                value += romanToNumberMap.get(Character.toString(digit));
                return value;
            }
            
            String compositDigit = s.substring(position, position + 2);
            if (romanToNumberMap.containsKey(compositDigit)) {
                 value += romanToNumberMap.get(compositDigit);
                 position++;
            } else {
                value += romanToNumberMap.get(Character.toString(digit));
            }
            
            position++;
        }
        
        return value;
    }
    
    private void initRomanToNumberMap(Map<String, Integer> romanToNumberMap) {
        romanToNumberMap.put("I", 1);
        romanToNumberMap.put("V", 5);
        romanToNumberMap.put("X", 10);
        romanToNumberMap.put("L", 50);
        romanToNumberMap.put("C", 100);
        romanToNumberMap.put("D", 500);
        romanToNumberMap.put("M", 1000);
        romanToNumberMap.put("IV", 4);
        romanToNumberMap.put("IX", 9);
        romanToNumberMap.put("XL", 40);
        romanToNumberMap.put("XC", 90);
        romanToNumberMap.put("CD", 400);
        romanToNumberMap.put("CM", 900);
    }
    
  
    // Time Complexity: O(1) Space Complexity: O(1)
    // Roman numerals are usually written largest to smallest from left to right.
    // that means if go from right to left and find a digit which integer value
    // is less than last visited digit then we can subtract the value from total
    // otherwise add to total. For example XIV in this case when moving right to
    // left we found V whiich is 5 now move next which is I and value of I is 1 
    // which is less than last visited 5 that mans we need to subtract 5 - 1 = 4
    // now current last visited is 1 and move to next. Now it is X which value is 
    // 10. 10 is greater than last visited 1 so we are going to add 10. 10 + 4 = 14
    // XIV = 14
    public int romanToIntAlternate(String s) {
        int value = getRomanToNumeric(s.charAt(s.length() - 1));
        int position = s.length() - 2;
        int lastValue = value;
        
        while (position >= 0) {
            int currentValue = getRomanToNumeric(s.charAt(position));
            
            if (currentValue < lastValue) {
                value -= currentValue;
            } else {
                value += currentValue;
            }
            
            lastValue = currentValue;
            position--;
        }
        
        return value;
    }
    
    private int getRomanToNumeric(char roman) {
        switch (roman) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            default  : return 1000; // M
        }
    }
    
}
