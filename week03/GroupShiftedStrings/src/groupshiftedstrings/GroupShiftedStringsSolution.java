/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupshiftedstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class GroupShiftedStringsSolution {
    
    public static void main(String args []) {
        String s1 = "bcd";
        String s2 = "wxy";
        
        System.out.println(getHash(s1));
        System.out.println(getHash(s2));
    }

    // Time Complexity: O(MN) where M is the max length of a string and N is the
    // number of string.
    // Space Complexity: O(MN) same like above
    // Technique: Hashing. Suppose we have two word 'bcd' and 'wxy' now how can we
    // determine they are in same shifting group. If they are same shifting group
    // that means we can transform both string to a uniform string by shifting.
    // Now as they are different string how can we determine how many shift require
    // to transform a string to a target string? Lets consider we will try to 
    // shift the string based on first character. Our main target is to transform
    // the first character of a string to 'a' now we apply same number of shifting
    // to rest of the character of the string. Here in the string 'bcd', first character
    // is 'b' so to transform 'b' to 'a' we need to do 25 shift (circular) now doing
    // same amount of shift to 'c' we get 'b' and 'd' we get 'c'. So 'bcd' to 
    // 'abc' by doing 25 shift. Now if we can generate 'wxy' to 'abc' by doing 
    // any number of shift than we can say they are both in same group. So to 
    // transform 'w' to 'a' we need 4 shift. Now doing same amount of shift to 
    // 'x' we get 'b' and for 'y' we get 'c' so from 'wxy' we got 'abc' which is
    // the same of the word bcd
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> group = new ArrayList<List<String>>();
        Map<String, List<String>> stringsGroupMap = new HashMap<>();
        
        for (String string : strings) {
            String hash = getHash(string);;
            stringsGroupMap.putIfAbsent(hash, new ArrayList<String>());
            stringsGroupMap.get(hash).add(string);
        }
        
        for (List<String> stringByGroup : stringsGroupMap.values()) {
            group.add(stringByGroup);
        }
        
        return group;
    }
    
    public static String getHash(String string) {
        StringBuilder builder = new StringBuilder();
        
        int shift = string.charAt(0);
        
        for (int i = 0; i < string.length(); i++) {
            builder.append(shiftCharacter(string.charAt(i), shift));
        }
        
        return builder.toString();
    }
    
    public static char shiftCharacter(char ch, int shift) {
        return (char) ((ch - shift + 26) % 26 + 'a');
    }
    
}
