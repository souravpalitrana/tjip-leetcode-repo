/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class LongestSubstringWithoutRepeatingCharactersSolution {
    
    // HashMap to track repeating character. We are going to track repeating
    // character and which position it is last repeated also. HashMap will store
    // maximum 256 characters so we can consider it constant space.
    // Time Complexity: O(n) and Space Complexity:: O(1)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<Character, Integer>();
        int startIdx = 0;
        int longestSubstringLength = 0;
        for (int endIdx = 0; endIdx < s.length(); endIdx++) {
            char ch = s.charAt(endIdx);
            
            if (seen.containsKey(ch) && seen.get(ch) >= startIdx) {
                longestSubstringLength = Math.max(longestSubstringLength, endIdx - startIdx);
                startIdx = seen.get(ch) + 1;
            } else if (endIdx == s.length() - 1) {
                // We reached at the end of the string without finding any 
                // repeat character. So calculate the length. Again need to add
                // 1 extra because last character inclusive
                longestSubstringLength = Math.max(longestSubstringLength, endIdx - startIdx + 1);
            } 
            seen.put(ch, endIdx);
        }
        
        return longestSubstringLength;
    }
}
