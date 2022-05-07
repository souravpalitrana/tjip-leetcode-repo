/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementstrstr;

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
public class ImplementStrStrSolutionTest {
    
    private ImplementStrStrSolution solution;
    
    public ImplementStrStrSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new ImplementStrStrSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of strStr method, of class ImplementStrStrSolution.
     */
    @Test
    public void testStrStrCase1() {
        String haystack = "hello";
        String needle = "ll";
        int expResult = 2;
        int result = solution.strStr(haystack, needle);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of strStr method, of class ImplementStrStrSolution.
     */
    @Test
    public void testStrStrCase2() {
        String haystack = "aaa";
        String needle = "aaaa";
        int expResult = -1;
        int result = solution.strStr(haystack, needle);
        assertEquals(expResult, result);
    }

    /**
     * Test of isSubstringPresentAt method, of class ImplementStrStrSolution.
     */
    @Test
    public void testIsSubstringPresentAt() {
        int position = 2;
         String haystack = "hello";
        String needle = "ll";
        boolean expResult = true;
        boolean result = solution.isSubstringPresentAt(position, haystack, needle);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of strStr method, of class ImplementStrStrSolution.
     */
    @Test
    public void testStrStrFirstAlternateCase1() {
        String haystack = "hello";
        String needle = "ll";
        int expResult = 2;
        int result = solution.strStrFirstAlternate(haystack, needle);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of strStr method, of class ImplementStrStrSolution.
     */
    @Test
    public void testStrStrFirstAlternateCase2() {
        String haystack = "aaa";
        String needle = "aaaa";
        int expResult = -1;
        int result = solution.strStrFirstAlternate(haystack, needle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStrStrThirdAlternateCase1() {
        String haystack = "hello";
        String needle = "ll";
        int expResult = 2;
        int result = solution.strStrThirdAlternate(haystack, needle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStrStrThirdAlternateCase2() {
        String haystack = "aaa";
        String needle = "aaaa";
        int expResult = -1;
        int result = solution.strStrThirdAlternate(haystack, needle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStrStrThirdAlternateCase3() {
        String haystack = "mississippi";
        String needle = "mississippi";
        int expResult = 0;
        int result = solution.strStrThirdAlternate(haystack, needle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStrStrThirdAlternateCase4() {
        String haystack = "mississippi";
        String needle = "issip";
        int expResult = 4;
        int result = solution.strStrThirdAlternate(haystack, needle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStrStrThirdAlternateCase5() {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        int expResult = 4;
        int result = solution.strStrThirdAlternate(haystack, needle);
        assertEquals(expResult, result);
    }
    
}
