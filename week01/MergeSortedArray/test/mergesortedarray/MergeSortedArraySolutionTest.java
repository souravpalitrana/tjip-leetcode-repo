/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortedarray;

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
public class MergeSortedArraySolutionTest {
    
    private MergeSortedArraySolution solution;
    
    public MergeSortedArraySolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new MergeSortedArraySolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMergeCase1() {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;
        int [] expected = {1,2,2,3,5,6};
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
    
    @Test
    public void testMergeCase2() {
        int [] nums1 = {1};
        int m = 1;
        int [] nums2 = {};
        int n = 0;
        int [] expected = {1};
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
    
    @Test
    public void testMergeCase3() {
        int [] nums1 = {0};
        int m = 0;
        int [] nums2 = {1};
        int n = 1;
        int [] expected = {1};
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
    
    @Test
    public void testMergeCase4() {
        int [] nums1 = {1,2,4,5,6,0};
        int m = 5;
        int [] nums2 = {3};
        int n = 1;
        int [] expected = {1,2,3,4,5,6};
        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
    
}
