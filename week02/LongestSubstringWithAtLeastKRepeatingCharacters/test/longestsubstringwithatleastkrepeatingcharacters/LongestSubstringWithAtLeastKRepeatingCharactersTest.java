/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringwithatleastkrepeatingcharacters;

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
public class LongestSubstringWithAtLeastKRepeatingCharactersTest {
    
    private LongestSubstringWithAtLeastKRepeatingCharacters solution;
    
    public LongestSubstringWithAtLeastKRepeatingCharactersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new LongestSubstringWithAtLeastKRepeatingCharacters();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of longestSubstring method, of class LongestSubstringWithAtLeastKRepeatingCharacters.
     */
    @Test
    public void testLongestSubstringCase1() {
        System.out.println("longestSubstring");
        String s = "aaabb";
        int k = 3;
        int expResult = 3;
        int result = solution.longestSubstring(s, k);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestSubstringCase2() {
        System.out.println("longestSubstring");
        String s = "ababbc";
        int k = 2;
        int expResult = 5;
        int result = solution.longestSubstring(s, k);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestSubstringFirstAlternateCase1() {
        System.out.println("longestSubstring");
        String s = "aaabb";
        int k = 3;
        int expResult = 3;
        int result = solution.longestSubstringFirstAlternate(s, k);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLongestSubstringFirstAlternateCase2() {
        System.out.println("longestSubstring");
        String s = "ababbc";
        int k = 2;
        int expResult = 5;
        int result = solution.longestSubstringFirstAlternate(s, k);
        assertEquals(expResult, result);
    }
    
}
