/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package besttimetobuysellstockii;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author souravpalit
 */
public class BestTimeToBuySellStockIISolutionTest {
    
    private BestTimeToBuySellStockIISolution solution;
    
    public BestTimeToBuySellStockIISolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new BestTimeToBuySellStockIISolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMaxProfitCase1() {
        int [] prices = {7,1,5,3,6,4};
        int expected = 7;
        int actual = solution.maxProfit(prices);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMaxProfitCase2() {
        int [] prices = {1,2,3,4,5};
        int expected = 4;
        int actual = solution.maxProfit(prices);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMaxProfitCase3() {
        int [] prices = {7,6,4,3,1};
        int expected = 0;
        int actual = solution.maxProfit(prices);
        assertEquals(expected, actual);
    }
    
}
