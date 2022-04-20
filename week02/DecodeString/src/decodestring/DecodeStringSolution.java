/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodestring;

import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class DecodeStringSolution {
    
    // Solution 1:
    // We track last non digit idx because when we find a starting bracket
    // we can create a number string just creating a substring by 
    // lastNonDigitCharacterIdx + 1 to i position and add this number to stack
    // for character we add all individual character one by one
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        int lastNonDigitCharacterIdx = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack.add(s.substring(lastNonDigitCharacterIdx + 1, i));
                lastNonDigitCharacterIdx = i;
            } else if (ch == ']') {
                lastNonDigitCharacterIdx = i;
                decodeLastString(stack);
            } else if (ch > 58) {
                lastNonDigitCharacterIdx = i;
                stack.add(ch + "");
            }
        }
        
        decodeLastString(stack);
        return stack.peek();
    }
    
    
    // Solution 2
    // We add separate string and number value in the stack instead of adding single 
    // digit and letter. To do that we need two variable one will track start of
    // the letters and another track the start of the digit. When we found '['
    // we can add number as we know that before start of a bracket there is a
    // number. Again when we found a digit or end bracket ] we can construct a
    // letter string if our startOfLetterIdx is not -1. This -1 help us to 
    // identify is there any letter we seen or not. Same goes for digitIdx too.
    // At the last of the string it can be end with end bracket or letter. So
    // if it is end with letter that means we need to add the last part if
    // i == length - 1
    public static String decodeStringFirstAlternate(String s) {
        Stack<String> stack = new Stack<String>();
        int startOfNumberIdx = -1;
        int startOfLetterIdx = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
             
            if (ch == '[') {
                // Before start of bracket ther will be always a number. So 
                // we can create the numberString
                stack.add(s.substring(startOfNumberIdx, i));
                startOfNumberIdx = -1;
            } else if (ch == ']') {
                startOfNumberIdx = -1;
                if (startOfLetterIdx != -1) {
                    stack.add(s.substring(startOfLetterIdx, i));
                }
                startOfLetterIdx = -1;
                decodeLastString(stack);
            } else if (ch > 58) {
                if (startOfLetterIdx == -1) {
                    startOfLetterIdx = i;
                } 
                // If string ends with letters like 2[ab]ccd
                if (i == s.length() - 1) {
                    stack.add(s.substring(startOfLetterIdx));
                }
                startOfNumberIdx = -1;
            } else {
                // It is start of a digit. So we may create string
                if (startOfLetterIdx != -1) {
                    stack.add(s.substring(startOfLetterIdx, i));
                }
                startOfLetterIdx = -1;
                
                if (startOfNumberIdx == -1) {
                    startOfNumberIdx = i;
                }
            }
        }
        
        decodeLastString(stack);
        return stack.peek();
    }
    
    public static void decodeLastString(Stack<String> stack) {
        String currentString = "";
        String currentNumber = "";
        while (!stack.empty()) {
            String value = stack.pop();
            if (value.charAt(0) > 47 && value.charAt(0) < 58) {
                currentNumber = value;
                break;
            } else {
                 currentString = value + currentString;
            }
        }
        
        int number = (currentNumber.length() > 0) ? Integer.valueOf(currentNumber) : 1;
        
        String decodedString = "";
        for (int i = 1; i <= number; i++) {
            decodedString += currentString;
        }
        
        stack.add(decodedString);
    }
    
}
