/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validanagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class ValidAnagramSolution {
    
    // Frequency calculation and equal matching
    // Time complexity O(n) where n is the length of the string 
    // Space Complexity O(1) as hashmap will store max 256 entries in each 
    // frequency map.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> sFrequencyMap = getFrequencyMap(s);
        Map<Character, Integer> tFrequencyMap = getFrequencyMap(t);
        
        if (sFrequencyMap.size() != tFrequencyMap.size()) {
            return false;
        }
        
        return isEqual(sFrequencyMap, tFrequencyMap);
    }
    
    public Map<Character, Integer> getFrequencyMap(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        
        return frequencyMap;
    }
    
    public boolean isEqual(Map<Character, Integer> sFrequencyMap, 
            Map<Character, Integer> tFrequencyMap) { 
        for (Map.Entry<Character, Integer> entry : tFrequencyMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            
            if (!sFrequencyMap.containsKey(ch) || sFrequencyMap.get(ch) < count) {
                return false;
            }
        }
        
        return true;
    }
    
    
    // Solution 2: Sort two strings then compare both string. 
    // Time Complexity: O(nlogn) & Space Complexity: O(n) because of toCharArray
    public boolean isAnagramAlternate(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        char [] sChars =  s.toCharArray();
        char [] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}
