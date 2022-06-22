/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsdifferbyonecharacter;

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
public class StringsDifferByOneCharacterSolutionTest {
    
    private StringsDifferByOneCharacterSolution solution;
    
    public StringsDifferByOneCharacterSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new StringsDifferByOneCharacterSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of differByOne method, of class StringsDifferByOneCharacterSolution.
     */
    @Test
    public void testDifferByOneCase1() {
        String[] dict = {"abcd","acbd", "aacd"};
        boolean expResult = true;
        boolean result = solution.differByOne(dict);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDifferByOneCase2() {
        String[] dict = {"ab","cd","yz"};
        boolean expResult = false;
        boolean result = solution.differByOne(dict);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDifferByOneCase3() {
        String[] dict = {"abcd","cccc","abyd","abab"};
        boolean expResult = true;
        boolean result = solution.differByOne(dict);
        assertEquals(expResult, result);
    }
    
}
