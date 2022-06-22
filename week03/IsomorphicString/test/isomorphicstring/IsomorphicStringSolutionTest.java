/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isomorphicstring;

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
public class IsomorphicStringSolutionTest {
    
    private IsomorphicStringSolution solution;
    
    public IsomorphicStringSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new IsomorphicStringSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isIsomorphic method, of class IsomorphicStringSolution.
     */
    @Test
    public void testIsIsomorphicCase1() {
        String s = "egg";
        String t = "add";
        boolean expResult = true;
        boolean result = solution.isIsomorphic(s, t);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsIsomorphicCase2() {
        String s = "foo";
        String t = "bar";
        boolean expResult = false;
        boolean result = solution.isIsomorphic(s, t);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsIsomorphicCase3() {
        String s = "paper";
        String t = "title";
        boolean expResult = true;
        boolean result = solution.isIsomorphic(s, t);
        assertEquals(expResult, result);
    }
    
}
