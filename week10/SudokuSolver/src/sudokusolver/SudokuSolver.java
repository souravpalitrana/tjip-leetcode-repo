/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

/**
 *
 * @author souravpalit
 */
public class SudokuSolver {

    // TC: As size fixed  so constant time complexity
    // SC: As size fixed  so constant space complexity
    // '.' means empty place
    public void solveSudoku(char[][] board) {
        canSolveSudoku(board, 0, 0); 
    }
    
    private boolean canSolveSudoku(char [][] board, int row, int col) {
        int currentRow = row;
        int currentCol = col;
        
        if (currentCol == board.length) {
            currentRow++;
            currentCol = 0;
            
            if (currentRow == board.length) {
                return true;
            }
        }
        
        if (board[currentRow][currentCol] == '.') {
            return placeDigitAtPosition(board, currentRow, currentCol);
        } else {
            return canSolveSudoku(board, currentRow, currentCol + 1);
        }
    }
    
    private boolean placeDigitAtPosition(char [][] board, int row, int col) {
        for (int digit = 1; digit < 10; digit++) {
            if (canPlaceDigitAtPosition(board, row, col, digit)) {
                board[row][col] = (char)(digit + '0');
                
                if (canSolveSudoku(board, row, col)) {
                    return true;
                }
            }
        }
        
        board[row][col] = '.';
        return false;
    }
    
    private boolean canPlaceDigitAtPosition(char [][] board, int row, int col, int digit) {
        // row check
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == (char)(digit + '0')) {
                return false;
            }
        }
        
        // col check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char)(digit + '0')) {
                return false;
            }
        }
        
        // subgrid check
        int gridStartRowIdx = (row / 3) * 3;
        int gridStartColIdx = (col / 3) * 3;
        
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int gridRowIdx = gridStartRowIdx + rowIdx;
                int gridColIdx = gridStartColIdx + colIdx;
                if (board[gridRowIdx][gridColIdx] == (char)(digit + '0')) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
