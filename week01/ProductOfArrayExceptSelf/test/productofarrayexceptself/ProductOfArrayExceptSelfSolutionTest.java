/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productofarrayexceptself;

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
public class ProductOfArrayExceptSelfSolutionTest {
    
    private ProductOfArrayExceptSelfSolution solution;
    
    public ProductOfArrayExceptSelfSolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new ProductOfArrayExceptSelfSolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of productExceptSelf method, of class ProductOfArrayExceptSelfSolution.
     */
    @Test
    public void testProductExceptSelfCase1() {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptSelfSolution instance = new ProductOfArrayExceptSelfSolution();
        int[] expResult = {24,12,8,6};
        int[] result = solution.productExceptSelf(nums);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testProductExceptSelfCase2() {
        int[] nums = {-1,1,0,-3,3};
        ProductOfArrayExceptSelfSolution instance = new ProductOfArrayExceptSelfSolution();
        int[] expResult = {0,0,9,0,0};
        int[] result = solution.productExceptSelf(nums);
        assertArrayEquals(expResult, result);
    }
    
     @Test
    public void testProductExceptSelfAlternateCase1() {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptSelfSolution instance = new ProductOfArrayExceptSelfSolution();
        int[] expResult = {24,12,8,6};
        int[] result = solution.productExceptSelfAlternate(nums);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testProductExceptSelfAlternateCase2() {
        int[] nums = {-1,1,0,-3,3};
        ProductOfArrayExceptSelfSolution instance = new ProductOfArrayExceptSelfSolution();
        int[] expResult = {0,0,9,0,0};
        int[] result = solution.productExceptSelfAlternate(nums);
        assertArrayEquals(expResult, result);
    }
    
}
