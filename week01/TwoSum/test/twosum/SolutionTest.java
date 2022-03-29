/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;

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
public class SolutionTest {
    
    public SolutionTest() {
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
     * Test of twoSum method, of class Solution.
     */
    @Test
    public void testTwoSumCase1() {
        int [] nums = {2, 7, 11, 15};
        int target = 9;
        Solution instance = new Solution();
        int[] expResult = {0, 1};
        int[] result = instance.twoSum(nums, target);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of twoSum method, of class Solution.
     */
    @Test
    public void testTwoSumCase2() {
        int [] nums = {3, 2, 4};
        int target = 6;
        Solution instance = new Solution();
        int[] expResult = {1, 2};
        int[] result = instance.twoSum(nums, target);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of twoSum method, of class Solution.
     */
    @Test
    public void testTwoSumCase3() {
        int [] nums = {3, 3};
        int target = 6;
        Solution instance = new Solution();
        int[] expResult = {0, 1};
        int[] result = instance.twoSum(nums, target);
        assertArrayEquals(expResult, result);
    }
    
}
