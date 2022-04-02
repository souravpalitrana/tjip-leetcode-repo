/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class ThreesumSolutionTest {
    
    private ThreeSumSolution solution;
    
    public ThreesumSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new ThreeSumSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of threeSum method, of class ThreesumSolution.
     */
    @Test
    public void testThreeSumCase1() {
     
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> expResult = new ArrayList<List<Integer>>();
        expResult.add(Arrays.asList(-1,-1,2));
        expResult.add(Arrays.asList(-1,0,1));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expResult, result);
    }  
}
