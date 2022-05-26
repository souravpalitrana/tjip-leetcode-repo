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
public class WordSearchIISolution {

    int [][] directions = {{0, 1}, {1, 0}, {0, - 1}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = createTrie(words);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                searchWord(row, col, board, trie.root, result);
            }
        }

        return result;
    }

    private void searchWord(
            int row, int col, 
            char [][] board, 
            TrieNode currentNode,
            List<String> result
    ) {
        char ch = board[row][col]; 
        int idx = ch - 'a';
       
        if (currentNode == null || ch == '#' || 
                currentNode.children[idx] == null) {
            return;
        } 
        
        currentNode = currentNode.children[idx];
        
        if (currentNode.isWord) {
            result.add(currentNode.word);
            currentNode.isWord = false;
        }
        
        board[row][col] = '#';
        
        for (int [] direction : directions) {
            try {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < board.length && newRow >= 0 && 
                    newCol >= 0 && newCol < board[0].length && 
                    board[newRow][newCol] != '#') {
                    searchWord(newRow, newCol, board, currentNode, result);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        board[row][col] = ch;
    }

    private Trie createTrie(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.addWord(word);
        }

        return trie;
    }
}
