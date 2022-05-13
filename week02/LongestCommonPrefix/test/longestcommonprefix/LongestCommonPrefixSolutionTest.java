/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcommonprefix;

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
public class LongestCommonPrefixSolutionTest {
    
    private LongestCommonPrefixSolution solution;
    
    public LongestCommonPrefixSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new LongestCommonPrefixSolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void longestCommonPrefixCase1() {
        String [] strs = {"flower","flow","flight"};
        String expected = "fl";
        String actual = solution.longestCommonPrefix(strs);
        assertEquals(expected, actual);
    }
    
    @Test
    public void longestCommonPrefixCase2() {
        String [] strs = {"dog","racecar","car"};
        String expected = "";
        String actual = solution.longestCommonPrefix(strs);
        assertEquals(expected, actual);
    }
    
    @Test
    public void longestCommonPrefixCase3() {
        String [] strs = {"","racecar","car"};
        String expected = "";
        String actual = solution.longestCommonPrefix(strs);
        assertEquals(expected, actual);
    }
    
    @Test
    public void longestCommonPrefixCase4() {
        String [] strs = {"dog","dog","dog"};
        String expected = "dog";
        String actual = solution.longestCommonPrefix(strs);
        assertEquals(expected, actual);
    }
    
    @Test
    public void longestCommonPrefixCase5() {
        String [] strs = {"dogs","dog","dog"};
        String expected = "dog";
        String actual = solution.longestCommonPrefix(strs);
        assertEquals(expected, actual);
    }
    
}
