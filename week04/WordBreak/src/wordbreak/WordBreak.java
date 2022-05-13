/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbreak;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class WordBreak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String s = "catsandog";
        List<String> words = Arrays.asList("cats","dog","sand","and","cat");*/
        String s = "catsandogcat";
        List<String> words = Arrays.asList("cats","dog","sand","and","cat","an");
        Solution solution = new Solution();
        
        System.out.println(solution.wordBreak(s, words));
    }
    
}
