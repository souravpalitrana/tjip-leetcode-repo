/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestpalindromicsubstring;

/**
 *
 * @author souravpalit
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String str) {
         String maxPalindrome = "";
        
        for (int i = 0; i < str.length(); i++) {
            int oddPalindromeLength = getOddPalindromeLength(str, i);
            int evenPalindromeLength = getEvenPalindromeLength(str, i);
            
            if (oddPalindromeLength > maxPalindrome.length()) {
                int mid = oddPalindromeLength / 2;
                maxPalindrome = str.substring(i - mid, i + mid + 1);
            }
            
            if (evenPalindromeLength > maxPalindrome.length()) {
                int mid = evenPalindromeLength / 2;
                maxPalindrome = str.substring(i - mid, i + mid);
            }
        }
        
        return maxPalindrome;
    }
    
    public int getOddPalindromeLength(String str, int position) { 
        int count = 1;
        int left = position - 1;
        int right = position + 1;
        
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            } 
            count += 2;
            left--;
            right++;
        }
        
        return count;    
    }
    
    public int getEvenPalindromeLength(String str, int position) {
        int count = 0;
        int left = position - 1;
        int right = position;
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            } 
            count += 2;
            left--;
            right++;
        }
        
        return count;    
    }
    
}
