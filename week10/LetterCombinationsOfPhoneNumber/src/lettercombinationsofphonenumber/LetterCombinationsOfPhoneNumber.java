/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lettercombinationsofphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class LetterCombinationsOfPhoneNumber {

    // TC:O(4^N * N) SC: O(N)
    public List<String> letterCombinations(String digits) {
        Map<Character, Character []> letterMap = getLetterMap();
        List<String> result = new ArrayList<String>();
        char [] prefix = new char [digits.length()];
        if (digits.length() == 0) {
            return result;
        }
        generateLetterCombination(digits, 0, letterMap, result, prefix);;
        return result;
    }
    
    public void generateLetterCombination(
        String digits, 
        int pos, 
        Map<Character, Character []> letterMap,
        List<String> result,
        char [] prefix
    ) {
        if (pos >= digits.length()) {
            String combination = new String(prefix);
            result.add(combination);
            return;
        }
        
        for (char letter : letterMap.get(digits.charAt(pos))) {
            prefix[pos] = letter;
            generateLetterCombination(digits, pos + 1, letterMap, result, prefix);
        }
    }
    
    private Map<Character, Character []> getLetterMap() {
        Map<Character, Character []> letterMap = new HashMap<>();
        
        letterMap.put('2', new Character [] {'a', 'b', 'c'});
        letterMap.put('3', new Character [] {'d', 'e', 'f'});
        letterMap.put('4', new Character [] {'g', 'h', 'i'});
        letterMap.put('5', new Character [] {'j', 'k', 'l'});
        letterMap.put('6', new Character [] {'m', 'n', 'o'});
        letterMap.put('7', new Character [] {'p', 'q', 'r', 's'});
        letterMap.put('8', new Character [] {'t', 'u', 'v'});
        letterMap.put('9', new Character [] {'w', 'x', 'y','z'});
        
        return letterMap;
    } 
    
}
