/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uglynumberii;

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
public class UglyNumberIISolutionTest {
    
    private UglyNumberIISolution solution;
    
    public UglyNumberIISolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new UglyNumberIISolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class UglyNumberIISolution.
     */
    @Test
    public void testNthUglyNumberCase1() {
        int n = 10;
        int expected = 12;
        int actual = solution.nthUglyNumber(n);
        assertEquals(expected, actual);;
    }
    
    @Test
    public void testNthUglyNumberCase2() {
        int n = 15;
        int expected = 24;
        int actual = solution.nthUglyNumber(n);
        assertEquals(expected, actual);;
    }
    
    @Test
    public void testNthUglyNumberCase3() {
        int n = 16;
        int expected = 25;
        int actual = solution.nthUglyNumber(n);
        assertEquals(expected, actual);;
    }
    
    @Test
    public void testNthUglyNumberFirstAlternateCase1() {
        int n = 10;
        int expected = 12;
        int actual = solution.nthUglyNumberFirstAlternate(n);
        assertEquals(expected, actual);;
    }
    
    @Test
    public void testNthUglyNumberFirstAlternateCase2() {
        int n = 15;
        int expected = 24;
        int actual = solution.nthUglyNumberFirstAlternate(n);
        assertEquals(expected, actual);;
    }
    
    @Test
    public void testNthUglyNumberFirstAlternateCase3() {
        int n = 16;
        int expected = 25;
        int actual = solution.nthUglyNumberFirstAlternate(n);
        assertEquals(expected, actual);;
    }
    
}
