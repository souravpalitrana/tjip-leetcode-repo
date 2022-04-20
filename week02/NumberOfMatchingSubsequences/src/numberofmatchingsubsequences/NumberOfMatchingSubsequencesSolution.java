/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofmatchingsubsequences;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class NumberOfMatchingSubsequencesSolution {

    // Time Limit Exceded
    // Time Complexity O(NS) where N is the nunber of words and S is the length
    // of s string
    // Space Complexity: O(1)
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        
        for (String seq : words) {
            if (isSubsequence(s, seq)) {
                count++;
            }
        }
        
        return count;
    }
    
    // Linear Subsequence checking
    public static boolean isSubsequence(String word, String subSequence) {
        int wordIdx = 0;
        int seqIdx = 0;
        
        while (wordIdx < word.length() && seqIdx < subSequence.length()) {
            if (word.charAt(wordIdx) == subSequence.charAt(seqIdx)) {
                seqIdx++; 
            }
            
            wordIdx++;
        }
        
        return seqIdx == subSequence.length();
    }
    
    // Time Complexity O(NS) where N is the nunber of words and S is the length
    // of s(bigger) string
    // Space Complexity: O(1)
    public int numMatchingSubseqFirstAlternate(String s, String[] words) {
        int count = 0;
        
        for (String seq : words) {
            if (isSubsequence2(s, seq)) {
                count++;
            }
        }
        
        return count;
    }
    
    // Used indexOf function which return the index of first matching character
    // works faster than loop checking and also accepted
    public static boolean isSubsequence2(String s, String seq) {
        int currentMatchingPosition = 0;
        for (int i = 0; i < seq.length(); i++) {
            int matchedPositionAt = s.indexOf(seq.charAt(i), currentMatchingPosition);
            if (matchedPositionAt == - 1) {
                return false;
            }
            currentMatchingPosition = matchedPositionAt + 1; 
        }
        return true;
    }

    // Time Complexity: O(NS) where N is the number of word and S is the length
    // of the string s(Bigger String)
    // Space Complexity: O(words.length) words.length means sum of all words
    // Store all word based on their first character. Now start processing the
    // first string. For each character go to the specific position of the array
    // and get the list which first character is this. Now as we found a matched
    // character we need to increase the index of all word for that instead of
    // storing only string we store wordInfo which store both word and current
    // checking position of the word. So we increase the index position. Now
    // if the index position == word.length we are sure that we found a sequence
    // matched. So we increase the matchedCounter. If not now as we moved the index
    // position so now our word's first character is changed. So we need to move
    // this word to the specific position of the wordsByCharacter array.
    public int numMatchingSubseqSecondAlternate(String s, String[] words) {  
        List<WordInfo> wordsByCharacter [] = new ArrayList[26];
        int matchedCount = 0;
        
        for (int i = 0; i < 26; i++) {
            wordsByCharacter[i] = new ArrayList<WordInfo>();
        }
        
        for (String word : words) {
            wordsByCharacter[word.charAt(0) - 'a'].add(new WordInfo(word, 0));
        }
        
        for (int i = 0; i < s.length(); i++) {
            List<WordInfo> wordList = wordsByCharacter[s.charAt(i) - 'a'];
            // We are going the process all the word in this index so we are
            // setting this position to new arraylist which will store new value
            // if comes. During processing same character may appear. In that
            // case we store that word in this list.
            wordsByCharacter[s.charAt(i) - 'a'] = new ArrayList<WordInfo>();
            
            for (WordInfo wordInfo : wordList) {
                wordInfo.index++;
                if (wordInfo.index == wordInfo.word.length()) {
                    matchedCount++;
                } else {
                    int newPositionInWordsByCharacter = wordInfo.word.charAt(wordInfo.index) - 'a';
                    wordsByCharacter[newPositionInWordsByCharacter].add(wordInfo);
                }
            }
            
            // We can ignore clearing this list also
            wordList.clear();
        }
        
        return matchedCount;
    }
    
    public class WordInfo {
        String word;
        int index;
        
        public WordInfo(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
