/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxpointsonaline;

import javafx.util.Pair;
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
public class MaxPointsOnALineSolutionTest {
    
    private MaxPointsOnALineSolution solution;
    
    public MaxPointsOnALineSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new MaxPointsOnALineSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of maxPoints method, of class MaxPointsOnALineSolution.
     */
    @Test
    public void testMaxPointsCase1() {
        int[][] points = {{1,1},{2,2},{3,3}};
        int expResult = 3;
        int result = solution.maxPoints(points);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMaxPointsCase2() {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int expResult = 4;
        int result = solution.maxPoints(points);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMaxPointsCase3() {
        int[][] points = {{0,0},{1, -1},{1,1}};
        int expResult = 2;
        int result = solution.maxPoints(points);
        assertEquals(expResult, result);
    }

}
