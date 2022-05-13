/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textjustification;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
public class TextJustificationSolutionTest {
    
    private TextJustificationSolution solution;
    
    public TextJustificationSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new TextJustificationSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of fullJustify method, of class TextJustificationSolution.
     */
    @Test
    public void testFullJustifyCase1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> expResult = Arrays.asList("This    is    an", "example  of text","justification.  ");
        List<String> result = solution.fullJustify(words, maxWidth);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFullJustifyCase2() {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> expResult = Arrays.asList("What   must   be", "acknowledgment  ", "shall be        ");
        List<String> result = solution.fullJustify(words, maxWidth);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFullJustifyCase3() {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        List<String> expResult = Arrays.asList("Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  ");
        List<String> result = solution.fullJustify(words, maxWidth);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFullJustifyCase4() {
        String[] words = {"What","must","be","shall","be."};
        int maxWidth = 12;
        List<String> expResult = Arrays.asList("What must be","shall be.   ");
        List<String> result = solution.fullJustify(words, maxWidth);
        assertEquals(expResult, result);
    }

   
    
    
}
