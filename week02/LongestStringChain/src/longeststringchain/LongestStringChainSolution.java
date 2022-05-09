/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longeststringchain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class LongestStringChainSolution {
    
    // Time Complexity: O(nl^2) because we have n word and for each word we
    // are running a dfs which will run l length (Max word length). For each 
    // iteration of l we are doing l another operation for predecessor generation
    // so total O(nl^2) ignoring initial O(n) of inserting all word in the set
    // as it is small compare to O(nl^2)
    // Space Complexity: O(n) because of set as well as recursion stack
    public int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<>();
        Set<String> wordsSet = new HashSet<String>();
        
        Collections.addAll(wordsSet, words);
     
        int maxStringChain = 0;
        
        for (String word : words) {
            maxStringChain = Math.max(maxStringChain, dfs(word, wordsSet, memo));
        }
        
        return maxStringChain;
    }
    
    public int dfs(String word, Set<String> wordsSet, Map<String, Integer> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        
        int maxLength = 1;
        
        StringBuilder stringBuilder = new StringBuilder(word);
        
        for (int i = 0; i < word.length(); i++) {
            stringBuilder.deleteCharAt(i);
            String newWord = stringBuilder.toString();
            
            if (wordsSet.contains(newWord)) {
                // Here 1 is adding because when we get the result it is from 
                // deleting one character that means current word to rest of the
                // words so we need to count the current word too.
                int currentLength = 1 + dfs(newWord, wordsSet, memo);
                maxLength = Math.max(maxLength, currentLength);
            }
            
            stringBuilder.insert(i, word.charAt(i));
        }
        
        memo.put(word, maxLength);
        return maxLength;
    }
    
    // Time Complexity: O(nlogn + nl^2) where nlogn for sorting and in the nl^2
    // n is for the n word and for each word max length of word is l as we are
    // running a second loop which will run l time and each time when we generate
    // predecessor using stringBuidlder.toString() it creates extra l complexity
    // so total nl^2
    // Space Complexity: O(n) as we just storing the n word in the map
    public int longestStrChainFirstAlternate(String[] words) {
        Map<String, Integer> chainCountMap = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int maxChainLength = 0;
        
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder(word);
            
            int currentLength = 1;
            for (int i = 0; i < word.length(); i++) {
               stringBuilder.deleteCharAt(i);
               String predecessor = stringBuilder.toString();
               
               int predecessorLength = chainCountMap.getOrDefault(predecessor, 0);
               currentLength = Math.max(currentLength, predecessorLength + 1);
               stringBuilder.insert(i, word.charAt(i));
            }
            
            chainCountMap.put(word, currentLength);
            maxChainLength = Math.max(maxChainLength, currentLength);
        }
        
        return maxChainLength;
    }
}
