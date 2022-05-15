/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsuggestionssystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
class Trie {

    public TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode currentNode = root;

        for (char ch : word.toCharArray()) {
            int nodeIdx = ch - 'a';
            
            if (currentNode.children[nodeIdx] == null) {
                currentNode.children[nodeIdx] = new TrieNode();
            }
            
            currentNode = currentNode.children[nodeIdx];
        }

        currentNode.word = word;
        currentNode.isWord = true;
    }
    
    public List<String> searchWord(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode currentNode = root;
        
        for (char ch : prefix.toCharArray()) {
            int nodeIdx = ch - 'a';
            
            if (currentNode.children[nodeIdx] == null) {
                return result;
            } 
            
            currentNode = currentNode.children[nodeIdx];
        }
        
        addWords(currentNode, result);
        return result;
    }
    
    private void addWords(TrieNode currentNode, List<String> result) {
        if (result.size() == 3) {
            return;
        }
        
        if (currentNode.isWord) {
            result.add(currentNode.word);
        }
        
        for (int i = 0; i < 26; i++) {
            if (currentNode.children[i] != null) {
                addWords(currentNode.children[i], result);
            }
        }
    }
}
