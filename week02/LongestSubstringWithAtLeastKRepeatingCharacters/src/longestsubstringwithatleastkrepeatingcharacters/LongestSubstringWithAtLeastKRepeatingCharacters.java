/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringwithatleastkrepeatingcharacters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    
    // Brute Force Solution. We will generate all possible substring and check
    // it is valid for the given conditions and it it is valid we will store the
    // length if length is greater than the previous valid substring. For the
    // validation check we need a frequencyMap to calculate the frequency.
    // TC: O(n^2) SC: O(1) ignoring freqMap as it is fixed 26 space and also
    // for the validation it is fixed 26 checking on each iteration
    public int longestSubstring(String s, int k) {
        if (s == null || k == 0 || k > s.length()) {
            return 0;
        } else if (k == 1) {
            return s.length();
        }
        
        int result = 0;
        // We will consider as constant memory as we have fixed length array 
        int [] freqMap = new int [26];
        
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(freqMap, 0);
            
            for (int j = i; j < s.length(); j++) {
                freqMap[s.charAt(j) - 'a']++;
                if (isValidSubstring(freqMap, k)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        
        return result;
    }
    
    public boolean isValidSubstring(int [] freqMap, int k) {
        for (int value : freqMap) {
            if (value != 0 && value < k) {
                return false;
            }
        }
        
        return true;
    }
    
    
    
    /*
    Devide & Conquer Solution: First we count a frequency map. Then we first 
    scan from the starting and for each character we check if the character freq
    is greater than or equal k and we move forward. If not that means we could 
    not take this character in our substring so our target substring may presents
    before this character or after this character. So we can devide the s string
    to s1 and s2 where s1 is before the character which freq count is less than k
    and s2 is all the character after that character. Now we pass this s1 and s2
    recursively to calculate the substring again. So we will get 1 value for s1 
    and another value for s2. We will return max value of this two value.
    Time Complexity: O(n^2) Space Complexity: O(n) because of call stack
    */
    public int longestSubstringFirstAlternate(String s, int k) {
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
        int ls1 = longestSubstringFirstAlternate(s.substring(0, l), k);
        
        // there are many repetiation of same character so ignore them also
        while (l < n && freqMap.get(s.charAt(l)) < k) {
            l++;
        }
        int ls2 = (l < n) ? longestSubstringFirstAlternate(s.substring(l), k) : 0;
        
        return Math.max(ls1, ls2);
    }
}
