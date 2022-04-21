/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetingroomsii;

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
public class MeetingRoomsIISolutionTest {
    
    private MeetingRoomsIISolution solution;
    
    public MeetingRoomsIISolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solution = new MeetingRoomsIISolution();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of minMeetingRooms method, of class MeetingRoomsIISolution.
     */
    @Test
    public void testMinMeetingRoomsCase1() {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int expResult = 2;
        int actualResult = solution.minMeetingRooms(intervals);
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testMinMeetingRoomsCase2() {
        int[][] intervals = {{7,10},{2,4}};
        int expResult = 1;
        int actualResult = solution.minMeetingRooms(intervals);
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testMinMeetingRoomsCase3() {
        int[][] intervals = {{5,8},{6,8}};
        int expResult = 2;
        int actualResult = solution.minMeetingRooms(intervals);
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testMinMeetingRoomsAlternateCase1() {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int expResult = 2;
        int actualResult = solution.minMeetingRoomsAlternate(intervals);
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testMinMeetingRoomsAlternateCase2() {
        int[][] intervals = {{7,10},{2,4}};
        int expResult = 1;
        int actualResult = solution.minMeetingRoomsAlternate(intervals);
        assertEquals(expResult, actualResult);
    }
    
    @Test
    public void testMinMeetingRoomsAlternateCase3() {
        int[][] intervals = {{5,8},{6,8}};
        int expResult = 2;
        int actualResult = solution.minMeetingRoomsAlternate(intervals);
        assertEquals(expResult, actualResult);
    }
    
}
