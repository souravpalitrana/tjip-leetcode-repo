/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlenumber;

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
public class SingleNumberSolutionTest {
    
    private SingleNumberSolution solution;
    
    public SingleNumberSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new SingleNumberSolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSingleNumberCase1() {
        int [] nums = {2,2,1};
        int expected = 1;
        int actual = solution.singleNumber(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberCase2() {
        int [] nums = {4,1,2,1,2};
        int expected = 4;
        int actual = solution.singleNumber(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberCase3() {
        int [] nums = {1,1,2,2,3};
        int expected = 3;
        int actual = solution.singleNumber(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberFirstAlternateCase1() {
        int [] nums = {2,2,1};
        int expected = 1;
        int actual = solution.singleNumberFirstAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberFirstAlternateCase2() {
        int [] nums = {4,1,2,1,2};
        int expected = 4;
        int actual = solution.singleNumberFirstAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberFirstAlternateCase3() {
        int [] nums = {1,1,2,2,3};
        int expected = 3;
        int actual = solution.singleNumberFirstAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberSecondAlternateCase1() {
        int [] nums = {2,2,1};
        int expected = 1;
        int actual = solution.singleNumberSecondAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberSecondAlternateCase2() {
        int [] nums = {4,1,2,1,2};
        int expected = 4;
        int actual = solution.singleNumberSecondAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSingleNumberSecondAlternateCase3() {
        int [] nums = {1,1,2,2,3};
        int expected = 3;
        int actual = solution.singleNumberSecondAlternate(nums);
        assertEquals(expected, actual);
    }
    
}
