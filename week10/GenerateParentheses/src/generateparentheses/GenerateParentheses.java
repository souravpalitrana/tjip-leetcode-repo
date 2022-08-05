/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateparentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class GenerateParentheses {

    // Process the result of n - 1 to obtain n.
    // For each element if we get ( then add () inside and at last add
    // () at the beginning
    public List<String> generateParenthesis(int n) {
        Set<String> parenthesis = generate(n);
        List<String> result = new ArrayList();
        result.addAll(parenthesis);
        return result;
    }
    
    public Set<String> generate(int n) {
        Set<String> result = new HashSet<String>();
        if (n == 0) {
            result.add("");
            return result;
        } 
        
        Set<String> previous = generate(n - 1);
        
        for (String element : previous) {
            for (int i = 0; i < element.length(); i++) {
                if (element.charAt(i) == '(') {
                    result.add(insertInside(element, i));
                }
            }
            result.add("()" + element);
        }
        
        return result;
    }
    
    private String insertInside(String element, int position) {
        String prefix = element.substring(0, position + 1);
        String suffix = element.substring(position + 1);
        return prefix + "()" + suffix;
    }
    
    // TC: O(c(n)) and SC: O(c(n)) where c(n) is the nth Casatalan number
    public List<String> generateParenthesisAlternate(int n) {
        List<String> result = new ArrayList<>();
        char [] brackets = new char[n * 2]; // if n = 3 that means 3 opening and 3 closing
        generateParenthesisAlternate(result, n, n, brackets, 0);
        return result;
    }
    
    // Backtracking
    public void generateParenthesisAlternate(
            List<String> result, 
            int opening, 
            int closing, 
            char [] brackets, 
            int index
    ) {
        if (opening < 0 || closing < opening) {
            return;
        } else if (opening == 0 && closing == 0) {
            result.add(String.copyValueOf(brackets));
            return;
        }
        
        brackets[index] = '(';
        generateParenthesisAlternate(result, opening - 1, closing, brackets, index + 1);
        brackets[index] = ')';
        generateParenthesisAlternate(result, opening, closing - 1, brackets, index + 1);
    }
    
}
