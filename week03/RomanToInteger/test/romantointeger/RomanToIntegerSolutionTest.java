/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package romantointeger;

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
public class RomanToIntegerSolutionTest {
    
    private RomanToIntegerSolution solution;
    
    public RomanToIntegerSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new RomanToIntegerSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of romanToInt method, of class RomanToIntegerSolution.
     */
    @Test
    public void testRomanToIntCase1() {
        String s = "III";
        int expResult = 3;
        int result = solution.romanToInt(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRomanToIntCase2() {
        String s = "LVIII";
        int expResult = 58;
        int result = solution.romanToInt(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRomanToIntCase3() {
        String s = "MCMXCIV";
        int expResult = 1994;
        int result = solution.romanToInt(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRomanToIntFirstAlternateCase1() {
        String s = "III";
        int expResult = 3;
        int result = solution.romanToIntAlternate(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRomanToIntFirstAlternateCase2() {
        String s = "LVIII";
        int expResult = 58;
        int result = solution.romanToIntAlternate(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRomanToIntFirstAlternateCase3() {
        String s = "MCMXCIV";
        int expResult = 1994;
        int result = solution.romanToIntAlternate(s);
        assertEquals(expResult, result);
    }

    
    
}
