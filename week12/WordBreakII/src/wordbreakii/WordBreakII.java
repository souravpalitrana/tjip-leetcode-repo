/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbreakii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class WordBreakII {

    private Map<Integer, List<String>> cache;
    private Trie trie;
    private String s;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();  
        trie = new Trie();
        for (String word : wordDict) {
            trie.addWord(word);
        }
        this.s = s;
        return findWords(0);
    }
    
    private List<String> findWords(int pos) {
        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }
        
        TrieNode currentNode = trie.root;
        List<String> sentences = new ArrayList<>();
        
        for (int i = pos; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!currentNode.children.containsKey(ch)) {
                break;
            }
            
            currentNode = currentNode.children.get(ch);
            
            if (currentNode.children.containsKey(trie.endSymbol)) {
                // Got a word
                String word = s.substring(pos, i + 1);
                if (i == s.length() - 1) {
                    sentences.add(word);
                } else {
                    List<String> nextSentences = findWords(i + 1);
                    if (nextSentences.size() > 0) {
                        for (int j = 0; j < nextSentences.size(); j++) {
                            sentences.add(word + " " + nextSentences.get(j));
                        }
                    }
                }
                
            }
            
        }
        cache.put(pos, sentences);
        return sentences;
        
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
