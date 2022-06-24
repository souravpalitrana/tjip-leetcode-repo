/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetingroomsii;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author souravpalit
 */
public class MeetingRoomsII {

    // TC: O(nlogn) SC: O(n) where n is the number of meetings
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> meetingRooms = new TreeMap<Integer, Integer>();
        
        for (int [] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            meetingRooms.put(start, meetingRooms.getOrDefault(start, 0) + 1);
            meetingRooms.put(end, meetingRooms.getOrDefault(end, 0) - 1);
        }
        
        int currentRoomCount = 0;
        int minRoomCount = Integer.MIN_VALUE;
        
        for (int value : meetingRooms.values()) {
            currentRoomCount += value;
            minRoomCount = Math.max(minRoomCount, currentRoomCount);
        }
        
        return minRoomCount;
    }
    
}
