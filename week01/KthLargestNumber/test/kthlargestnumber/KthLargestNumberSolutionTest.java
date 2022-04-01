/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthlargestnumber;

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
public class KthLargestNumberSolutionTest {
    
    private KthLargestNumberSolution solution;
    
    public KthLargestNumberSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new KthLargestNumberSolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFindKthLargestCase1() {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        int expected = 5;
        int actual = solution.findKthLargest(nums, k);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindKthLargestCase2() {
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int expected = 4;
        int actual = solution.findKthLargest(nums, k);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindKthLargestFirstAlternateCase1() {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        int expected = 5;
        int actual = solution.findKthLargestFirstAlternate(nums, k);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindKthLargestAlternateCase2() {
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int expected = 4;
        int actual = solution.findKthLargestFirstAlternate(nums, k);
        assertEquals(expected, actual);
    }
    
}
