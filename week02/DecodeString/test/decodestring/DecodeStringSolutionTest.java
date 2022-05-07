/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodestring;

import java.util.Stack;
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
public class DecodeStringSolutionTest {
    
    private DecodeStringSolution solution;
    
    public DecodeStringSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new DecodeStringSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of decodeString method, of class DecodeStringSolution.
     */
    @Test
    public void testDecodeStringCase1() {
        String s = "3[a]2[bc]";
        String expResult = "aaabcbc";
        String result = solution.decodeString(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringCase2() {
        String s = "3[a2[c]]";
        String expResult = "accaccacc";
        String result = solution.decodeString(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringCase3() {
        String s = "2[abc]3[cd]ef";
        String expResult = "abcabccdcdcdef";
        String result = solution.decodeString(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringCase4() {
        String s = "10[a]";
        String expResult = "aaaaaaaaaa";
        String result = solution.decodeString(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringCase5() {
        String s = "100[leetcode]";
        String expResult = "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodele"
                + "etcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetco"
                + "deleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodelee"
                + "tcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
                + "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetco"
                + "deleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleet"
                + "codeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodele"
                + "etcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
                + "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode";
        String result = solution.decodeString(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringFirstAlternateCase1() {
        String s = "3[a]2[bc]";
        String expResult = "aaabcbc";
        String result = solution.decodeStringFirstAlternate(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringFirstAlternateCase2() {
        String s = "3[a2[c]]";
        String expResult = "accaccacc";
        String result = solution.decodeStringFirstAlternate(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringFirstAlternateCase3() {
        String s = "2[abc]3[cd]ef";
        String expResult = "abcabccdcdcdef";
        String result = solution.decodeStringFirstAlternate(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringFirstAlternateCase4() {
        String s = "10[a]";
        String expResult = "aaaaaaaaaa";
        String result = solution.decodeStringFirstAlternate(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringFirstAlternateCase5() {
        String s = "100[leetcode]";
        String expResult = "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodele"
                + "etcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetco"
                + "deleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodelee"
                + "tcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
                + "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetco"
                + "deleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleet"
                + "codeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodele"
                + "etcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
                + "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode";
        String result = solution.decodeStringFirstAlternate(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDecodeStringFirstAlternateCase6() {
        String s = "sd2[f2[e]g]i";
        String expResult = "sdfeegfeegi";
        String result = solution.decodeStringFirstAlternate(s);
        assertEquals(expResult, result);
    }
}
