/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestconsecutivesequence;

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
public class LongestConsecutiveSequenceSolutionTest {
    
    private LongestConsecutiveSequenceSolution solution;
    
    public LongestConsecutiveSequenceSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new LongestConsecutiveSequenceSolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testlongestConsecutiveCase1() {
        int [] nums = {100,4,200,1,3,2};
        int expected = 4;
        int actual = solution.longestConsecutive(nums);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testlongestConsecutiveCase2() {
        int [] nums = {0,3,7,2,5,8,4,6,0,1};
        int expected = 9;
        int actual = solution.longestConsecutive(nums);
        assertEquals(expected, actual);
    }
    
    
}
