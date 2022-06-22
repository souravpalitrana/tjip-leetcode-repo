/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isomorphicstring;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class IsomorphicStringSolution {

    // Checking left to right and right to left
    // Time complexity: O(n) Space Complexity: O(1) as maximum entry in the hashmap
    // will be 26
    public boolean isIsomorphic(String s, String t) { 
        return isIsomorphicInOneDirection(s, t) && isIsomorphicInOneDirection(t, s);
    }
    
    public boolean isIsomorphicInOneDirection(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charOfS = s.charAt(i);
            char charOfT = t.charAt(i);
            
            if (charMap.containsKey(charOfS) && charMap.get(charOfS) != charOfT) {
                return false;
            } 
            
            charMap.put(charOfS, charOfT);
        }
        
        return true;
    }
    
}
