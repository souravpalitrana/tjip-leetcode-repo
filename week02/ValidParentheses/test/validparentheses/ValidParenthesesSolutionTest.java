/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validparentheses;

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
public class ValidParenthesesSolutionTest {
    
    private ValidParenthesesSolution solution;
    
    public ValidParenthesesSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new ValidParenthesesSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class ValidParenthesesSolution.
     */
    @Test
    public void testIsValidCase1() {
        String s = "()";
        ValidParenthesesSolution instance = new ValidParenthesesSolution();
        boolean expResult = true;
        boolean result = solution.isValid(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidCase2() {
        String s = "()[]{}";
        ValidParenthesesSolution instance = new ValidParenthesesSolution();
        boolean expResult = true;
        boolean result = solution.isValid(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidCase3() {
        String s = "(]";
        ValidParenthesesSolution instance = new ValidParenthesesSolution();
        boolean expResult = false;
        boolean result = solution.isValid(s);
        assertEquals(expResult, result);
    }
}
