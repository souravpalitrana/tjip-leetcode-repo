/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trappingrainwater;

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
public class TrappingRainWaterSolutionTest {
    
    public TrappingRainWaterSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of trap method, of class TrappingRainWaterSolution.
     */
    @Test
    public void testTrapCase1() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWaterSolution solution = new TrappingRainWaterSolution();
        int expResult = 6;
        int result = solution.trap(height);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of trap method, of class TrappingRainWaterSolution.
     */
    @Test
    public void testTrapCase2() {
        int[] height = {4,2,0,3,2,5};
        TrappingRainWaterSolution solution = new TrappingRainWaterSolution();
        int expResult = 9;
        int result = solution.trap(height);
        assertEquals(expResult, result);
    }
    
}
