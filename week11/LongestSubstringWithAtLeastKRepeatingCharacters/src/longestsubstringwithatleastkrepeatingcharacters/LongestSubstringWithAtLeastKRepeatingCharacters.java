/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringwithatleastkrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    // TC: O(n) SC: O(1)
    public int longestSubstring(String s, int k) {
        if (s == null || k == 0 || k > s.length()) {
            return 0;
        } else if (k == 1) {
            return s.length();
        }
        
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);;
        }
        
        // Now we need to find a character which frequency count is less than
        // the k so that we can split.
        int l = 0;
        while (l < n && freqMap.get(s.charAt(l)) >= k) {
            l++;
        }
        
        // If there is no character which frequency count is less than k in that
        // case we will reach at the end of the string. so return the length of s
        if (l == n) {
            return l;
        }
        
        // Now we found our position. So we can split string
        int ls1 = longestSubstring(s.substring(0, l), k);
        
        // there are many repetiation of same character so ignore them also
        while (l < n && freqMap.get(s.charAt(l)) < k) {
            l++;
        }
        int ls2 = (l < n) ? longestSubstring(s.substring(l), k) : 0;
        
        return Math.max(ls1, ls2);
    }
    
}
