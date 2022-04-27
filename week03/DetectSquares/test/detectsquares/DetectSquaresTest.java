/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectsquares;

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
public class DetectSquaresTest {
    
    private DetectSquares solution;
    
    public DetectSquaresTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new DetectSquares();
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of count method, of class DetectSquares.
     */
    @Test
    public void testCountCase1() {
        solution.add(new int [] {3, 10});
        solution.add(new int [] {11, 2});
        solution.add(new int [] {3, 2});
        int[] qPoint = {11, 10};
        assertEquals(1, solution.count(new int[] {11, 10}));
        assertEquals(0, solution.count(new int[] {14, 8}));
        solution.add(new int [] {11, 2});
        assertEquals(2, solution.count(new int[] {11, 10}));
    }
    
}
