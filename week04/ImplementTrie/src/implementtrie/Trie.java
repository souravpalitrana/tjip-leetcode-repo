/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementtrie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class Trie {

    public TrieNode root;
    public char endSymbol = '*';

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        return searchWord(word, false);
    }

    public boolean startsWith(String prefix) {
        return searchWord(prefix, true);
    }

    public boolean searchWord(String word, boolean isPrefixSearch) {
        TrieNode currentNode = root;

        for (char ch : word.toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                return false;
            }
            currentNode = currentNode.children.get(ch);
        }

        return (isPrefixSearch) ? true : currentNode.children.containsKey(endSymbol);
    }

    class TrieNode {

        public Map<Character, TrieNode> children = new HashMap<>();
        public String word;
    }
}
