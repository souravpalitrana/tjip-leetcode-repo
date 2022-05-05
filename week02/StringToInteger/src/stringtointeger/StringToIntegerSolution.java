/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtointeger;

/**
 *
 * @author souravpalit
 */
public class StringToIntegerSolution {
    
    // Time complexity: O(n) Space Complexity: O(1)
    public int myAtoi(String s) {
        int digitPos = 0;
        int n = s.length();
        int sign = 1;
        
        // ignore leading spaces
        while (digitPos < n && s.charAt(digitPos) == ' ') {
            digitPos++;
        }
        
        // Now the next charact should be either + - or a digit.
        if (digitPos < n && s.charAt(digitPos) == '-') {
            digitPos++;
            sign = -1;
        } else if (digitPos < n && s.charAt(digitPos) == '+') {
            digitPos++;
        }
        
        int result = 0;
        int threshold = Integer.MAX_VALUE / 10;
        // Now we will generate the number until finding a invalid character
        // or until end of the string
        while (digitPos < n && Character.isDigit(s.charAt(digitPos))) {
            int digit = s.charAt(digitPos) - '0';
            
            if (result > threshold || 
                    (result == threshold && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            digitPos++;
        }
        
        return sign * result;
    }
    
    // State Machine Solution
    // Time complexity: O(n) Space Complexity: O(1)
    public int myAtoiAlternate(String s) {
        StateMachine stateMachine = new StateMachine();
        
        for (int i = 0; i < s.length(); i++) {
            if (stateMachine.getState() == State.qd) {
                break;
            }
            
            stateMachine.transit(s.charAt(i));
        }
        
        return stateMachine.getInteger();
    }
}
