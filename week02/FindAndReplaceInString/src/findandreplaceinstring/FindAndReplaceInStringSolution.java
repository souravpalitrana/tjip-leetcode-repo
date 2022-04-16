/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findandreplaceinstring;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class FindAndReplaceInStringSolution {
    
    // First we check substring presents based on the given indices. If presents
    // we add the indics value as well as indics position to a map. This map will
    // help us to identify in which position we need to perform the replacement
    // again when we do the replacement we need to skip the matching substring 
    // which we can do by incrementing the position by currentSource length. We can access
    // source and target with the help of map value.
    
    // Time Complexity: O(ks + n) where k is the indics number and s is the max
    // length of a substring and n is the main string length. We can say it
    // O(S) where s is the sum of all string length.
    // Space Complexity: O(k) for k indics
    public String findReplaceString(String s, int[] indices, 
            String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
     
        for (int i = 0; i < indices.length; i++) {
            if (isSubstringPresentAt(s, sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }
       
        return replaceString(s, map, sources, targets);
    }
    
    public boolean isSubstringPresentAt(String s, String substring, int position) {
       int stringIdx = position;
       int substringIdx = 0;
       while (stringIdx < s.length() && substringIdx < substring.length()) {
           if (s.charAt(stringIdx) != substring.charAt(substringIdx)) {
               return false;
           }
           stringIdx++;
           substringIdx++;
       }
       
       return substringIdx == substring.length();
    }
    
    public String replaceString(String s, Map<Integer, Integer> map, 
            String[] sources, String[] targets) {
        if (map.size() == 0) {
            return s;
        }
        
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (map.containsKey(i)) {
                builder.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                builder.append(s.charAt(i));
                i++;
            }
        }
        
        return builder.toString();
    }
}
