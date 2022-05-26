/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofmatchingsubsequences;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class NumberOfMatchingSubsequences {
    
    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> charMap = new HashMap<>();
        Trie trie = new Trie();
        trie.addAll(words);
        
        return findMatchCount(s, trie.root, 0);
    }
    
    public static int findMatchCount(String s, TrieNode currentNode, int matchIdx) {
        int matchCount = 0;
        
        if (currentNode == null) {
            return 0;
        }
        
        if (currentNode.isWord) {
            matchCount += currentNode.wordCount;
        }
        
        for (int i = 0; i < 26; i++) {
            if (currentNode.children[i] != null) {
                char ch = (char) (i + 'a');
                int index = s.indexOf(String.valueOf(ch), matchIdx);
                
                if (index != -1) {
                    matchCount += findMatchCount(s, currentNode.children[i], index + 1);
                }
            }
        }
        
        return matchCount;
    }
    
    
    
}
