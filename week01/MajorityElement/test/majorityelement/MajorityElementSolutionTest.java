/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorityelement;

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
public class MajorityElementSolutionTest {
    
    private MajorityElementSolution solution;
    
    public MajorityElementSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new MajorityElementSolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMajorityElementCase1() {
        int [] nums = {3,2,3};
        int expected = 3;
        int actual = solution.majorityElement(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMajorityElementCase2() {
        int [] nums = {2,2,1,1,1,2,2};
        int expected = 2;
        int actual = solution.majorityElement(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMajorityElementFirstAlternateCase1() {
        int [] nums = {3,2,3};
        int expected = 3;
        int actual = solution.majorityElementFirstAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMajorityElementFirstAlternateCase2() {
        int [] nums = {2,2,1,1,1,2,2};
        int expected = 2;
        int actual = solution.majorityElementFirstAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMajorityElementSecondAlternateCase1() {
        int [] nums = {3,2,3};
        int expected = 3;
        int actual = solution.majorityElementFirstAlternate(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testMajorityElementSecondAlternateCase2() {
        int [] nums = {2,2,1,1,1,2,2};
        int expected = 2;
        int actual = solution.majorityElementFirstAlternate(nums);
        assertEquals(expected, actual);
    }
    
}
