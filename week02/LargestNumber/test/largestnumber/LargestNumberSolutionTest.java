/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestnumber;

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
public class LargestNumberSolutionTest {
    
    private LargestNumberSolution solution;
    
    public LargestNumberSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new LargestNumberSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of largestNumber method, of class LargestNumberSolution.
     */
    @Test
    public void testLargestNumberCase1() {
        int nums[] = {10,2};
        String expected = "210";
        String actual = solution.largestNumber(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testLargestNumberCase2() {
        int nums[] = {3,30,34,5,9};
        String expected = "9534330";
        String actual = solution.largestNumber(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testLargestNumberCase3() {
        int nums[] = {34323,3432};
        String expected = "343234323";
        String actual = solution.largestNumber(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testLargestNumberCase4() {
        int nums[] = {0, 0};
        String expected = "0";
        String actual = solution.largestNumber(nums);
        assertEquals(expected, actual);
    }
}
