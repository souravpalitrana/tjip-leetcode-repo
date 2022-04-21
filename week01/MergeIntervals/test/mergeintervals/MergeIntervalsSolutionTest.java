/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeintervals;

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
public class MergeIntervalsSolutionTest {
    
    private MergeIntervalsSolution solution;
    
    public MergeIntervalsSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new MergeIntervalsSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of merge method, of class MergeIntervalsSolution.
     */
    @Test
    public void testMergeCase1() {
        
        int[][] intervals = { {1,3}, {2,6}, {8,10}, {15,18} };
        int[][] expResult = {{1,6},{8,10},{15,18}};
        int[][] result = solution.merge(intervals);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of merge method, of class MergeIntervalsSolution.
     */
    @Test
    public void testMergeCase2() {
        
        int[][] intervals = { {1,4},{4,5} };
        int[][] expResult = {{1,5}};
        int[][] result = solution.merge(intervals);
        assertArrayEquals(expResult, result);
    }
    
}
