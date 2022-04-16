/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findandreplaceinstring;

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
public class FindAndReplaceInStringSolutionTest {
    
    private FindAndReplaceInStringSolution solution;
    
    public FindAndReplaceInStringSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new FindAndReplaceInStringSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findReplaceString method, of class FindAndReplaceInStringSolution.
     */
    @Test
    public void testFindReplaceStringCase1() {
        String s = "abcd";
        int [] indices = {0, 2};
        String [] sources = {"a", "cd"};
        String [] targets = {"eee", "ffff"};
        String expResult = "eeebffff";
        String result = solution.findReplaceString(s, indices, sources, targets);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFindReplaceStringCase2() {
        String s = "abcd";
        int [] indices = {0, 2};
        String [] sources = {"ab","ec"};
        String [] targets = {"eee", "ffff"};
        String expResult = "eeecd";
        String result = solution.findReplaceString(s, indices, sources, targets);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFindReplaceStringCase3() {
        String s = "abcde";
        int [] indices = {2, 2};
        String [] sources = {"cdef","bc"};
        String [] targets = {"f", "fe"};
        String expResult = "abcde";
        String result = solution.findReplaceString(s, indices, sources, targets);
        assertEquals(expResult, result);
    }
}
