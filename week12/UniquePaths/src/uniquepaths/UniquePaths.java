/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquepaths;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 * Leetcode: Unique Paths
 * Problem Link: https://leetcode.com/problems/unique-paths/
 * @author souravpalit
 */
public class UniquePaths {

    // TC: O(mn) SC: O(mn)
    public int uniquePaths(int m, int n) {
        Map<Pair, Integer> cache = new HashMap<>();
        return getNumberOfWays(m - 1, n - 1, m, n, cache);
    }
    
    public int getNumberOfWays(
        int row, 
        int col, 
        int m, 
        int n, 
        Map<Pair, Integer> cache) {
        if (row < 0 || col < 0) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        } else if (cache.containsKey(new Pair(row, col))) {
            return cache.get(new Pair(row, col));
        } 
        
        int ways = getNumberOfWays(row - 1, col, m, n, cache) 
                + getNumberOfWays(row, col - 1, m, n, cache);
        cache.put(new Pair(row, col), ways);
        return ways;
    }
}
