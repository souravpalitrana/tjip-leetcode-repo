/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofmatchingsubsequences;

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
public class NumberOfMatchingSubsequencesSolutionTest {
    
    private NumberOfMatchingSubsequencesSolution solution;
    
    public NumberOfMatchingSubsequencesSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new NumberOfMatchingSubsequencesSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of numMatchingSubseq method, of class NumberOfMatchingSubsequencesSolution.
     */
    @Test
    public void testNumMatchingSubseqCase1() {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        int expResult = 3;
        int result = solution.numMatchingSubseq(s, words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumMatchingSubseqCase2() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        int expResult = 2;
        int result = solution.numMatchingSubseq(s, words);
        assertEquals(expResult, result);
    }

    @Test
    public void testNumMatchingSubseqFirstAlternateCase1() {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        int expResult = 3;
        int result = solution.numMatchingSubseqFirstAlternate(s, words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumMatchingSubseqFirstAlternateCase2() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        int expResult = 2;
        int result = solution.numMatchingSubseqFirstAlternate(s, words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumMatchingSubseqSecondAlternateCase1() {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        int expResult = 3;
        int result = solution.numMatchingSubseqSecondAlternate(s, words);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNumMatchingSubseqSecondAlternateCase2() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        int expResult = 2;
        int result = solution.numMatchingSubseqSecondAlternate(s, words);
        assertEquals(expResult, result);
    }
    
}
