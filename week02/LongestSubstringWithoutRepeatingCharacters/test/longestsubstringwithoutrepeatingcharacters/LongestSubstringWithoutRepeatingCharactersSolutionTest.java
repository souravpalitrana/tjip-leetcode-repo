/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringwithoutrepeatingcharacters;

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
public class LongestSubstringWithoutRepeatingCharactersSolutionTest {
    
    private LongestSubstringWithoutRepeatingCharactersSolution solution;
    
    public LongestSubstringWithoutRepeatingCharactersSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharactersSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lengthOfLongestSubstring method, of class LongestSubstringWithoutRepeatingCharactersSolution.
     */
    @Test
    public void testLengthOfLongestSubstringCase1() {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharactersSolution instance = new LongestSubstringWithoutRepeatingCharactersSolution();
        int expResult = 3;
        int result = instance.lengthOfLongestSubstring(s);
        assertEquals(expResult, result);
    }
    
    /*@Test
    public void testLengthOfLongestSubstringCase2() {
        String s = "bbbbb";
        LongestSubstringWithoutRepeatingCharactersSolution instance = new LongestSubstringWithoutRepeatingCharactersSolution();
        int expResult = 1;
        int result = instance.lengthOfLongestSubstring(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLengthOfLongestSubstringCase3() {
        String s = "pwwkew";
        LongestSubstringWithoutRepeatingCharactersSolution instance = new LongestSubstringWithoutRepeatingCharactersSolution();
        int expResult = 3;
        int result = instance.lengthOfLongestSubstring(s);
        assertEquals(expResult, result);
    }*/
    
}
