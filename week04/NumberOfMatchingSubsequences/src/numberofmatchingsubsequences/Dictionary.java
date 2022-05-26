/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofmatchingsubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class Dictionary {
    
    private Map<Character, List<Integer>> charMap = new HashMap<>();
    
    public Dictionary(String s) {
        charMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charMap.putIfAbsent(ch, new ArrayList<Integer>());;
            charMap.get(ch).add(i);
        }
    }
    
    public int indexOf(char ch, int offset) {
        if (!charMap.containsKey(ch))  {
            return -1;
        }
        
        for (int idx : charMap.get(ch)) {
            if (idx >= offset) {
                return idx;
            }
        }
        
        return -1;
    }
    
}
