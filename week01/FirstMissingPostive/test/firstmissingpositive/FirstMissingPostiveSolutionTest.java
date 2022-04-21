/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstmissingpositive;

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
public class FirstMissingPostiveSolutionTest {
    
    private FirstMissingPositiveSolution solution;
    
    public FirstMissingPostiveSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new FirstMissingPositiveSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of firstMissingPositive method, of class FirstMissingPostiveSolution.
     */
    @Test
    public void testFirstMissingPositiveCase1() {
        int[] nums = {1,2,0};
        int expResult = 3;
        int result = solution.firstMissingPositive(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveCase2() {
        int[] nums = {3,4,-1,1};
        int expResult = 2;
        int result = solution.firstMissingPositive(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveCase3() {
        int[] nums = {7,8,9,11,12};
        int expResult = 1;
        int result = solution.firstMissingPositive(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveCase4() {
        int[] nums = {0};
        int expResult = 1;
        int result = solution.firstMissingPositive(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveAlternateCase1() {
        int[] nums = {1,2,0};
        int expResult = 3;
        int result = solution.firstMissingPositiveAlternate(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveAlternateCase2() {
        int[] nums = {3,4,-1,1};
        int expResult = 2;
        int result = solution.firstMissingPositiveAlternate(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveAlternateCase3() {
        int[] nums = {7,8,9,11,12};
        int expResult = 1;
        int result = solution.firstMissingPositiveAlternate(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveAlternateCase4() {
        int[] nums = {0};
        int expResult = 1;
        int result = solution.firstMissingPositiveAlternate(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveAlternateCase5() {
        int[] nums = {3, 4, -1};
        int expResult = 1;
        int result = solution.firstMissingPositiveAlternate(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveAlternateCase6() {
        int[] nums = {0,1,2};
        int expResult = 3;
        int result = solution.firstMissingPositiveAlternate(nums);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstMissingPositiveAlternateCase7() {
        int[] nums = {1};
        int expResult = 2;
        int result = solution.firstMissingPositiveAlternate(nums);
        assertEquals(expResult, result);
    }
    
}
