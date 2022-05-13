/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupanagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class GroupAnagramSolution {
    
    // Sort a string and use it as a key. Now check this sorted string is
    // present in the hashmap or not. If present that means we found a group
    // anagram and we add the orginal word in that group.
    // Time Complexity: O(wnlogn) where w is the word count and nlogn is for 
    // sorting a single word of n characters
    // Space Complexity: O(wn) as we need to store all the words in the hashmap
     public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            char [] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);
            
            if (anagrams.containsKey(sortedStr)) {
                anagrams.get(sortedStr).add(str);
            } else {
                List<String> words = new ArrayList<String>();
                words.add(str);
                anagrams.put(sortedStr, words);
            }
        }
        
        return new ArrayList<>(anagrams.values());
    }
}
