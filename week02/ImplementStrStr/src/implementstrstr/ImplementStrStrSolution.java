/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementstrstr;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author souravpalit
 */
public class ImplementStrStrSolution {
    
    private int BASE = 29;
    private int MOD = 1000000007;
    
    // Typical linear checking
    // Time Complexity: O(n^2) Space Complexity: O(1)
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) &&
                    isSubstringPresentAt(i, haystack, needle)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isSubstringPresentAt(int position, String haystack, String needle) {
        int haystackIdx = position;
        int needleIdx = 0;
        
        while (haystackIdx < haystack.length() && needleIdx < needle.length()) {
            if (haystack.charAt(haystackIdx) != needle.charAt(needleIdx)) {
                return false;
            }
            haystackIdx++;
            needleIdx++;
        }
        
        return true;
    }
    
    // Typical linear checking by substring copy
    // Time Complexity: O(n^2) Space Complexity: O(1)
    public int strStrFirstAlternate(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    
    // Typical linear checking by substring copy but it will be faster as we
    // are not creating and matcing substring in all position. We are doing that
    // when only first character matched
    // Time Complexity: O(n^2) Space Complexity: O(1)
    public int strStrSecondAlternate(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
               String substring = haystack.substring(i, i + needle.length());
               if (substring.equals(needle)) {
                   return i;
               } 
            } 
        }
        return -1;
    }
    
    public int strStrThirdAlternate(String haystack, String needle) {
        long [] prefixHashHaystack = new long [haystack.length() + 1];
        long [] pows = new long [haystack.length() + 1];
        long needleHashValue = getHashValue(needle);
        
        calculatePrefixHash(haystack, prefixHashHaystack, pows);
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            long hayStackHashValue = getRangeHash(i, 
                    i + needle.length() - 1, prefixHashHaystack, pows);
            if (hayStackHashValue == needleHashValue) {
                return i;
            }
        }
        
        return -1;
    }
    
    public void calculatePrefixHash(String string, long [] prefixHash, long [] pows) {
        prefixHash[0] = string.charAt(0);
        pows[0] = 1;
        
        for (int i = 1; i < string.length(); i++) {
            prefixHash[i] = ((prefixHash[i - 1] * BASE) % MOD) + string.charAt(i);
            pows[i] = (pows[i - 1] * BASE) % MOD;
        }
    }
    
    public long getHashValue(String string) {
        long hash = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            hash = ((hash * BASE) + string.charAt(i)) % MOD;
        }
        return hash;
    }
    
    public long getRangeHash(int start, int end, long [] prefixHash, long [] pows) {
        long x = prefixHash[end];
        long y = (start == 0) ? 0 : (prefixHash[start - 1] * pows[end - start + 1]) % MOD;
        // x-y can be negative so adding MOD value and then doing mod again
        return (x - y + MOD) % MOD;
    }
    
}
