/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class ValidParenthesesSolution {
    
    private char FIRST_BRACKET_START = '(';
    private char FIRST_BRACKET_END = ')';
    private char SECOND_BRACKET_START = '{';
    private char SECOND_BRACKET_END = '}';
    private char THIRD_BRACKET_START = '[';
    private char THIRD_BRACKET_END = ']';
    
    // We first add each parenthes to stack. Before adding if current parenthes
    // is equal to the end parenthes then we will pop instead of adding. Otherwise
    // we add to the stack.
    // Time Complexity: O(n) Space Complexity: O(n) because of stack
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char parenthes = s.charAt(i);
            
            if (stack.empty() || !isValidClosingParenthes(stack.peek(), parenthes)) {
                stack.add(parenthes);
            } else {
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
    // We can use hashmap to avoid this method
    public boolean isValidClosingParenthes(char start, char end) {
        if (start == FIRST_BRACKET_START && end == FIRST_BRACKET_END) {
            return true;
        } else if (start == SECOND_BRACKET_START && end == SECOND_BRACKET_END) {
            return true;
        } else if (start == THIRD_BRACKET_START && end == THIRD_BRACKET_END) {
            return true;
        } else {
            return false;
        }
    }
}
