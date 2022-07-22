/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallestrectangleenclosingblackpixels;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 * Leetcode: 302. Smallest Rectangle Enclosing Black Pixels
 * Problem Link: https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
 * @author souravpalit
 */
public class SmallestRectangleEnclosingBlackPixels {

    int [] directions = {-1, 0, 1, 0, -1};
    
    // TC: O(MN) SC: O(MN)
    public int minArea(char[][] image, int x, int y) {
        List<Pair<Integer, Integer>> blackCells = new ArrayList<>();
        exploreShips(image, x, y, blackCells);
        int minRow, maxRow, minCol, maxCol;
        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;
        
        for (Pair<Integer, Integer> cell : blackCells) {
            int row = cell.getKey();
            int col = cell.getValue();
            minRow = Math.min(row, minRow);
            minCol = Math.min(col, minCol);
            maxRow = Math.max(row, maxRow);
            maxCol = Math.max(col, maxCol);
        }
        
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        
        return width * height;
    }
    
    public void exploreShips(char [][] image, int row, int col, List<Pair<Integer, Integer>> blackCells ) {
        if (image[row][col] == '1') {
            blackCells.add(new Pair(row, col));
            image[row][col] = '0';
            
            for (int i = 0; i < directions.length - 1; i++) {
                int newRow = row + directions[i];
                int newCol = col + directions[i + 1];
                
                if (newRow < image.length && newCol < image[0].length && 
                        newRow >= 0 && newCol >= 0) {
                    exploreShips(image, newRow, newCol, blackCells);
                }
            }
        }
    }
    
}
