/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validanagram;

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
public class ValidAnagramSolutionTest {
    
    private ValidAnagramSolution solution;
    
    public ValidAnagramSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new ValidAnagramSolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidAnagramCase1() {
        String s = "anagram";
        String t = "nagaram";
        boolean expected = true;
        boolean actual = solution.isAnagram(s, t);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testValidAnagramCase2() {
        String s = "rat";
        String t = "car";
        boolean expected = false;
        boolean actual = solution.isAnagram(s, t);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testValidAnagramCase3() {
        String s = "aa";
        String t = "a";
        boolean expected = false;
        boolean actual = solution.isAnagram(s, t);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testValidAnagramCase4() {
        String s = "ab";
        String t = "a";
        boolean expected = false;
        boolean actual = solution.isAnagram(s, t);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testValidAnagramAlternateCase1() {
        String s = "anagram";
        String t = "nagaram";
        boolean expected = true;
        boolean actual = solution.isAnagramAlternate(s, t);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testValidAnagramAlternateCase2() {
        String s = "rat";
        String t = "car";
        boolean expected = false;
        boolean actual = solution.isAnagramAlternate(s, t);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testValidAnagramAlternateCase3() {
        String s = "aa";
        String t = "a";
        boolean expected = false;
        boolean actual = solution.isAnagramAlternate(s, t);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testValidAnagramAlternateCase4() {
        String s = "ab";
        String t = "a";
        boolean expected = false;
        boolean actual = solution.isAnagramAlternate(s, t);
        assertEquals(expected, actual);
    }
    
}
