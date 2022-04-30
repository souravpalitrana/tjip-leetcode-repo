/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupshiftedstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class GroupShiftedStringsSolutionTest {
    
    private GroupShiftedStringsSolution solution;
    
    public GroupShiftedStringsSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new GroupShiftedStringsSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of groupStrings method, of class GroupShiftedStringsSolution.
     */
    @Test
    public void testGroupStringsCase1() {
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
        List<List<String>> expResult = new ArrayList<>();
        expResult.add(Arrays.asList("acef"));
        expResult.add(Arrays.asList("a","z"));
        expResult.add(Arrays.asList("abc","bcd","xyz"));
        expResult.add(Arrays.asList("az","ba"));
        
        List<List<String>> result = solution.groupStrings(strings);
        
        for (List<String> actResult : result) {
            assertEquals(true, isContains(expResult, actResult));
        }
    }
    
    @Test
    public void testGroupStringsCase2() {
        String[] strings = {"abc","bcd","acef","xyz","az","bc","a","z"};
        List<List<String>> expResult = new ArrayList<>();
        expResult.add(Arrays.asList("acef"));
        expResult.add(Arrays.asList("a","z"));
        expResult.add(Arrays.asList("abc","bcd","xyz"));
        expResult.add(Arrays.asList("az"));
        expResult.add(Arrays.asList("bc"));
        
        List<List<String>> result = solution.groupStrings(strings);
        
        for (List<String> actResult : result) {
            assertEquals(true, isContains(expResult, actResult));
        }
    }

    private boolean isContains(List<List<String>> expResult, List<String> targetList) {
        for (List<String> expList : expResult) {
            int matchCount = 0;
            for (String string : expList) {
                if (targetList.contains(string)) {
                    matchCount++;
                }
            }
            if (matchCount == targetList.size()) {
                return true;
            }
        }
        
        return false;
    }
    
}
