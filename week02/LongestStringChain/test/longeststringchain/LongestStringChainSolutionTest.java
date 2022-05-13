/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longeststringchain;

import java.util.Map;
import java.util.Set;
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
public class LongestStringChainSolutionTest {
    
    private LongestStringChainSolution solution;
    
    public LongestStringChainSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new LongestStringChainSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of longestStrChain method, of class LongestStringChainSolution.
     */
    @Test
    public void testLongestStrChainCase1() {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        int expResult = 4;
        int result = solution.longestStrChain(words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestStrChainCase2() {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        int expResult = 5;
        int result = solution.longestStrChain(words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestStrChainCase3() {
        String[] words = {"abcd","dbqca"};
        int expResult = 1;
        int result = solution.longestStrChain(words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestStrChainFirstAlternateCase1() {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        int expResult = 4;
        int result = solution.longestStrChainFirstAlternate(words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestStrChainFirstAlternateCase2() {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        int expResult = 5;
        int result = solution.longestStrChainFirstAlternate(words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestStrChainFirstAlternateCase3() {
        String[] words = {"abcd","dbqca"};
        int expResult = 1;
        int result = solution.longestStrChainFirstAlternate(words);
        assertEquals(expResult, result);
    }
    
}
