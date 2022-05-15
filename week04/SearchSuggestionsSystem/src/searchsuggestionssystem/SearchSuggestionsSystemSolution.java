/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsuggestionssystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class SearchSuggestionsSystemSolution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            String word = searchWord.substring(0, i + 1);
            search(word, products, result);
        }

        return result;
    }

    private void search(String searchWord, String[] products, List<List<String>> result) {
        List<String> searchResult = new ArrayList<String>();

        for (String product : products) {
            if (product.startsWith(searchWord)) {
                searchResult.add(product);
                if (searchResult.size() == 3) {
                    break;
                }
            }
        }

        result.add(searchResult);
    }
    
    public List<List<String>> suggestedProductsFirstAlternate(String[] products, String searchWord) {
        //Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        
        for (String product : products) {
            trie.addWord(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            String word = searchWord.substring(0, i + 1);
            result.add(trie.searchWord(word));
        }

        return result;
    }

}
