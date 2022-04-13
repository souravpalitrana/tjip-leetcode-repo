/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcommonprefix;

/**
 *
 * @author souravpalit
 */
public class LongestCommonPrefixSolution {
    
    // First get the minimum length of a string as we need to check till that
    // then from starting check characters matched in a position for all string
    // if not match generate substring 
    // Time Complexity: O(mn) where n is the number of string and m is the 
    // minimum length of a string
    public String longestCommonPrefix(String[] strs) {
        int endPosition = getMinLengthOfString(strs);
        int position = 0;
        
        while (position < endPosition) {
            if (!isSameCharacterAtThisPosition(strs, position)) {
                if (position == 0) {
                    return "";
                } else {
                    return strs[0].substring(0, position);
                }
            } else if (position == endPosition - 1) {
                return strs[0].substring(0, endPosition);
            }
            
            position++;
        }
        
        return "";
    }
    
    public int getMinLengthOfString(String[] strs) {
        int endPosition = Integer.MAX_VALUE;
        
        for (String str : strs) {
            endPosition = Math.min(endPosition, str.length());;
        }
        
        return endPosition;
    }
    
    public boolean isSameCharacterAtThisPosition(String[] strs, int position) {
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].charAt(position) != strs[i + 1].charAt(position)) {
                return false;
            }
        }
        
        return true;
    }
}
