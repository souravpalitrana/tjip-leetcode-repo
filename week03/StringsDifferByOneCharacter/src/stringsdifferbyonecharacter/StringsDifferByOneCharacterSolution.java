/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsdifferbyonecharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class StringsDifferByOneCharacterSolution {
    
    public static final long BASE = 26;
    public static final long MOD = 10000000000007L;
    
    // Memory Limit Exceed O(M*N) Space Complexity:(M^2*N)
    // We are going to use HashSet where we store all the combination of a string
    // replacing each character with *. For example suppose we have two word "abc"
    // and "dbc" now for abc when we replace first character with * it becomes *bc and we store
    // it in the set. Now for dbc replacing first character with * it becomes *bc
    // now check this in the set already present or not. In this case we already have
    // *bc for the word abc so that means only one character differ which is in the
    // first character of the both string.
    // As we need to store M^2 string for a single String so if string size is
    // large then M^2 will be huge and for N string it will overflow the space
    public static boolean differByOne(String[] dict) {
        Set<String> pattern = new HashSet<String>();
        
        for (int i = 0; i < dict.length; i++) {
            StringBuilder builder = new StringBuilder(dict[i]);
            for (int j = 0; j < builder.length(); j++) {
                char ch = builder.charAt(j);
                builder.setCharAt(j, '*');
                String newString = builder.toString();
                if (pattern.contains(newString)) {
                    return true;
                } else {
                    pattern.add(newString);
                }
                builder.setCharAt(j, ch);
            }
        }
        
        return false;
    }
    
    // Time Complexity: O(M*N) Space Complexity: M(M*N)
    // Same appproach like above but difference is that instead of storing all
    // combination of a string we will store all combination of hash so we 
    // don't need to store huge string which will be converted a number.
    // For hash value generation we are using 10^13 + 7 as a MOD value. Below
    // that it will not work. sow how it works? First we generate hash value of
    // all the word. For example we have two string "abc" and "acc" now suppose
    // our hashfunction generates 28 for "abc" and 54 for "acc". Now we are going
    // to apply our above logic and generate a new hash using this hash.
    // For i = 1 our new hash for abc will be 2 this means removing b the hash of ac is 2
    // For i = 1 our new hash for acc will be 2 this means removing c the hash of ac is 2
    // we found a hash matching that means in this position they differ but same 
    // rest of the characters.
    public static boolean differByOneFirstAlternate(String [] dict) {
        int m = dict[0].length();
        int n = dict.length;
        long [] hashes = new long[n];
        
        for (int i = 0; i < n; i++) {
            hashes[i] = getHash(dict[i]);
        }
         
        long[] power = new long[m];
        power[0] = 1;
        
        for(int i = 1; i < m; i++) {
            power[i] = (power[i-1] * BASE) % MOD;
        }
        
        for (int i = 0; i < m; i++) {
            Set<Long> seen = new HashSet<>();
            
            for (int j = 0; j < n; j++) {
                long newHash = ((hashes[j] - (dict[j].charAt(i) - 'a') * power[m - i - 1]) % MOD + MOD) % MOD;
                if (seen.contains(newHash)) {
                    return true;
                }
                
                seen.add(newHash);
            }
        }
        
        return false;
    } 
    
    public static long getHash(String word) {
        long hash = word.charAt(0) - 'a';
        for (int i = 1; i < word.length(); i++) {
            hash = ((hash * BASE) % MOD) + word.charAt(i) - 'a';
        }
        return hash;
    }
    
}
