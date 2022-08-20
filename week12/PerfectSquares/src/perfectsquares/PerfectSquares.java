/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectsquares;

import java.util.Arrays;

/**
 *
 * @author souravpalit
 */
public class PerfectSquares {

    private int [] cache;
    ///TC: O(n * root(n)) SC: O(n)
    public int numSquares(int n) {
        cache = new int [n + 1];
        Arrays.fill(cache, -1);
        return getLeastNumOfSquares(n);
    }
    
    private int getLeastNumOfSquares(int n) {
        if (n < 2) {
            return n;
        } else if (cache[n] != -1) {
            return cache[n];
        }
        
        int minCount = Integer.MAX_VALUE / 2;
        for (int i = 1; i * i <= n; i++) {
            minCount = Math.min(minCount, 1 + getLeastNumOfSquares(n - i * i));
        }
        
        cache[n] = minCount;
        return minCount;
    }
}
