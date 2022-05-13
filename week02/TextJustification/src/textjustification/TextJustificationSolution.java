/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textjustification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author souravpalit
 */
public class TextJustificationSolution {
    
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> charMap = new HashMap<>();
        int currentLine = 0;
        
        lines.add(new ArrayList<String>());
        charMap.put(currentLine, maxWidth);
        
        for (String word : words) {
            int remainingChar = charMap.get(currentLine);
            if (word.length() <= remainingChar) {
                addWordToLine(currentLine, lines, charMap, word, maxWidth);
            } else {
                currentLine++;
                lines.add(new ArrayList<String>());
                charMap.put(currentLine, maxWidth);
                addWordToLine(currentLine, lines, charMap, word, maxWidth);
            }
        }
            
        formatLines(lines, result, maxWidth);
        return result;
    }
    
    public void addWordToLine(
        Integer currentLine, 
        List<List<String>> lines, 
        Map<Integer, Integer> charMap, 
        String word,
        int maxWidth) {
        
        lines.get(currentLine).add(word);
        // Now change remaining and add space if required
        charMap.put(currentLine, charMap.get(currentLine) - word.length());
       
        // We have to add a space if at least one position left otherwise we
        // can not add a new word. So subtracting one from remaining character
        if (charMap.get(currentLine) != 0) {
            charMap.put(currentLine, charMap.get(currentLine) - 1);
        }
    }              
    
    public void formatLines(
        List<List<String>> lines, 
        List<String> result, 
        int maxWidth
    ) {
       for (int currentLine = 0; currentLine < lines.size(); currentLine++) {
           List<String> line = lines.get(currentLine);
           
           if (line.size() == 1 || currentLine == lines.size() - 1) {
               result.add(makeLeftAligned(line, maxWidth));
           } else {
               result.add(makeMiddleAligned(line, maxWidth));
           }
       }  
    }
    
    public String makeLeftAligned(List<String> words, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        int remainingPos = maxWidth - getCharacterCount(words);
        
        for (String word : words) {
            builder.append(word);
            if (remainingPos > 0) {
                builder.append(' ');
                remainingPos--;
            }
        }
        
        while (remainingPos > 0) {
            builder.append(' ');
            remainingPos--;
        }
        
        return builder.toString();
    }
    
    public String makeMiddleAligned(List<String> line, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        int remainingChar = maxWidth - getCharacterCount(line);
        
        for (int i = 0; i < line.size(); i++) {
            builder.append(line.get(i));
            
            // Do not add space after last word
            if (i != line.size() - 1) {
                int wordsRequiredSpaceCount = line.size() -i - 1;
                int spaces = (int) Math.ceil((double) remainingChar / (double) wordsRequiredSpaceCount);
                remainingChar -= spaces;
                
                for (int j = 0; j < spaces; j++) {
                    builder.append(' ');
                }
            } 
        }
        
        return builder.toString();
    }
    
    private int getCharacterCount(List<String> line) {
        int count = 0;
        for (String word : line) {
            count += word.length();
        }
        return count;
    }
}
