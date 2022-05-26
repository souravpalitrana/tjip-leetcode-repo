/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearchii;

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
}
