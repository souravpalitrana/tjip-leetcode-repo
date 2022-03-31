/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movezeros;

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
public class MoveZerosSolutionTest {
    
    private MoveZerosSolution solution;
    
    public MoveZerosSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new MoveZerosSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of moveZeroes method, of class MoveZerosSolution.
     */
    @Test
    public void testMoveZeroesCase1() {
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        solution.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }
    
    /**
     * Test of moveZeroes method, of class MoveZerosSolution.
     */
    @Test
    public void testMoveZeroesCase2() {
        int[] nums = {0};
        int[] expected = {0};
        solution.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }
    
    @Test
    public void testMoveZeroesAlternateCase1() {
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        solution.moveZeroesAlternate(nums);
        assertArrayEquals(expected, nums);
    }
    
    /**
     * Test of moveZeroes method, of class MoveZerosSolution.
     */
    @Test
    public void testMoveZeroesAlternateCase2() {
        int[] nums = {0};
        int[] expected = {0};
        solution.moveZeroesAlternate(nums);
        assertArrayEquals(expected, nums);
    }
    
}
