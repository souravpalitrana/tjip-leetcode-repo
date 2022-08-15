/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
class Solution {

    /**
     * First we will construct a Trie with all the word of wordDict. Then we 
     * will scan the big strigng (s) and try to find it in the trie. When we
     * found a word then we recursively call the method again to find word for
     * the remaining string. For example we have a wordDict = "abcde", "abcdef", 
     * "gmn" and a big string "abcdefgmn". So we can separate big string like
     * "abcdef" and "gmn". But give a close attention. When we find scan and 
     * reach to e it is present in our wordDict. So remaining string is fgmn.
     * But we could not separate "fgmn" because though we have "gmn" but we do'nt
     * have "f". So last time when we separated the main string is not the right
     * place to separate. Lets try to move on and find other place to separate.
     * So moving e to f we found another match "abcdef" and remaining string is
     * "gmn" now do same in "gmn" which is our remaining string. Now "gmn" is 
     * present in our wordDict. So we can return true as we can separate the 
     * input string.
     */ 
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for (String word : wordDict) {
            trie.addWord(word);
        }

        Map<Integer, Boolean> memo = new HashMap<>();
        return canSeparated(s, 0, trie, memo);
    }

    private boolean canSeparated(
            String s, 
            int startIdx, 
            Trie trie, 
            Map<Integer, Boolean> memo
    ) {
        if (memo.containsKey(startIdx)) {
            return memo.get(startIdx);
        }
        
        TrieNode currentNode = trie.root;

        for (int i = startIdx; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!currentNode.children.containsKey(ch)) {
                return false;
            }

            currentNode = currentNode.children.get(ch);

            if (currentNode.children.containsKey(trie.endSymbol)) {
                // If we reach at the end of the string and found the last wordd
                // so we can return true
                if (i == s.length() - 1) {
                    return true;
                } else {
                    // Now we have to check if we can separate remaining string
                    // thats why started from i + 1
                    if (canSeparated(s, i + 1, trie, memo)) {
                        return true;
                    } else {
                        memo.put(i + 1, false);
                    }
                }
            }
        }

        return false;
    }

    class TrieNode {

        public Map<Character, TrieNode> children = new HashMap<>();
        public String word;
    }

    class Trie {

        public TrieNode root;
        public char endSymbol = '*';

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode currentNode = root;

            for (char ch : word.toCharArray()) {
                if (!currentNode.children.containsKey(ch)) {
                    currentNode.children.put(ch, new TrieNode());
                }

                currentNode = currentNode.children.get(ch);
            }

            currentNode.word = word;
            currentNode.children.put(endSymbol, null);
        }
    }
}
