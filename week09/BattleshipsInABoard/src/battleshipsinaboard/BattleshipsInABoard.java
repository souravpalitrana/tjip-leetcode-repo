/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipsinaboard;

/**
 *
 * @author souravpalit
 */
public class BattleshipsInABoard {

    // TC: O(mn) SC: O(1)
    int [] directions = {-1, 0, 1, 0, -1};
    public int countBattleships(char[][] board) {
        int shipCount = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    shipCount++;;
                    exploreShips(board, i, j);
                }
            }
        }
        
        return shipCount;
    }
    
    public void exploreShips(char [][] board, int row, int col) {
        if (board[row][col] == 'X') {
            board[row][col] = '.';
            
            for (int i = 0; i < directions.length - 1; i++) {
                int newRow = row + directions[i];
                int newCol = col + directions[i + 1];
                
                if (newRow < board.length && newCol < board[0].length && 
                        newRow >= 0 && newCol >= 0) {
                    exploreShips(board, newRow, newCol);
                }
            }
        }
    }
    
    // Without modifying the board. When we found a X we first count it now
    // when we found another X we check it's previous horizontal cell has X
    // If yes thats means it is same ship and we already calculated it. Same
    // goes for vertical as well if we found above row has X thats means we
    // calculated it
    // TC: O(mn) SC: O(1)
    public int countBattleshipsEnhanced(char[][] board) {
        int shipCount = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')  continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                shipCount++;
            }
        }
        
        return shipCount;
    }
}
