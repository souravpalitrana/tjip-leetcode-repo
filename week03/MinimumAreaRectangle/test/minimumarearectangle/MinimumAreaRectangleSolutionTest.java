/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumarearectangle;

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
public class MinimumAreaRectangleSolutionTest {
    
    private MinimumAreaRectangleSolution solution;
    
    public MinimumAreaRectangleSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new MinimumAreaRectangleSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of minAreaRect method, of class MinimumAreaRectangleSolution.
     */
    @Test
    public void testMinAreaRectCase1() {
        int [][] points = { {1,1}, {1,3}, {3,1}, {3,3}, {2,2}};
        int expResult = 4;
        int result = solution.minAreaRect(points);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMinAreaRectCase2() {
        int [][] points = { {1,1}, {1,3}, {3,1}, {3,3}, {4,1}, {4,3}};
        int expResult = 2;
        int result = solution.minAreaRect(points);
        assertEquals(expResult, result);
    }
}
