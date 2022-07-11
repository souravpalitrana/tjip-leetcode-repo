/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofislands;

/**
 * Leetcode: 200. Number of Islands
 * Problem Link: https://leetcode.com/problems/number-of-islands/
 * @author souravpalit
 */
public class NumberOfIslands {

    // TC: O(mn) SC: O(1)
    int [] directions = {-1, 0, 1, 0, -1};
    
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    numOfIslands++;
                    explore(grid, row, col);
                }
            }
        }
        
        return numOfIslands;
    }
    
    public void explore(char [][] grid, int row, int col) {
        if (grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        
        for (int i = 0; i < directions.length - 1; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];
                
            if (newRow < grid.length && newCol < grid[0].length && 
                    newRow >= 0 && newCol >= 0) {
                explore(grid, newRow, newCol);
            }
        }
    }
    
}
