/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package besttimetobuysellstock;

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
public class BestTimeToBuySellStockSolutionTest {
    
    private BestTimeToBuySellStockSolution solution;
    
    public BestTimeToBuySellStockSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new BestTimeToBuySellStockSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BestTimeToBuySellStockSolution.
     */
    @Test
    public void testMaxProfitCase1() {
        int [] prices = {7,1,5,3,6,4};
        int expectedValue = 5;
        int actualValue = solution.maxProfit(prices);
        assertEquals(expectedValue, actualValue);
    }
    
    /**
     * Test of main method, of class BestTimeToBuySellStockSolution.
     */
    @Test
    public void testMaxProfitCase2() {
        int [] prices = {7,6,4,3,1};
        int expectedValue = 0;
        int actualValue = solution.maxProfit(prices);
        assertEquals(expectedValue, actualValue);
    }
    
}
