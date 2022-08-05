/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringwithatmostkdistinctcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    // TC: O(n) where n is the length of s
    // SC: O(k) 
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        
        Map<Character, Integer> seenChars = new HashMap<Character, Integer>();
        int maxSubstringLength = 0;
        int windowStartIdx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
        
            if (seenChars.containsKey(ch)) {
                seenChars.put(ch, seenChars.get(ch) + 1);
            } else {
                if (seenChars.size() == k) {
                    // we need to reduce the size of the window
                    while (seenChars.size() == k) {
                        char charNeedToRemove = s.charAt(windowStartIdx);
                        if (seenChars.get(charNeedToRemove) == 1) {
                            seenChars.remove(charNeedToRemove);
                        } else {
                            seenChars.put(charNeedToRemove, seenChars.get(charNeedToRemove) - 1);
                        }
                        windowStartIdx++;
                    }
                } 
                seenChars.put(ch, 1);
            }
            
            maxSubstringLength = Math.max(maxSubstringLength, i - windowStartIdx + 1);
        }
        
        return maxSubstringLength;
    }
    
}
