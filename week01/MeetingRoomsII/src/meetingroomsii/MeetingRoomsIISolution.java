/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetingroomsii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class MeetingRoomsIISolution {
    
    // Time Complexity: O(n^2) Space Complexity: O(n)
    public int minMeetingRooms(int[][] intervals) {
        sortIntervals(intervals);
        
        Map<Integer, Integer> meetingRooms = new HashMap<Integer, Integer>();
        meetingRooms.put(1, intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int meetingStartTime = intervals[i][0];
            int meetingEndTime = intervals[i][1];
            int freeRoom = getFreeRoom(meetingRooms, meetingStartTime);
            if (freeRoom != -1) {
                // It has been ended so we will assign it to the new meeting
                meetingRooms.put(freeRoom, meetingEndTime);
            } else {
                // All existing rooms are occupied. Need to assign a new room
                meetingRooms.put(meetingRooms.size() + 1, meetingEndTime); 
            }
        }
        
        return meetingRooms.size();
    }
    
    private int getFreeRoom(Map<Integer, Integer> meetingRooms, int starTime) {
        for (Map.Entry<Integer, Integer> entry : meetingRooms.entrySet()) {
            int willFreeAt = entry.getValue();
            if (starTime >= willFreeAt) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
    
    // Complexity increased because of checking all the room is free or not.
    // But if we can find the free room in a faster way we can improve the
    // complexity. Actually we need recent minimum meeting ending time.
    // We can get that by using minheap. Again adding meanheap requires logn time
    // so it will cost nlogn time and sorting is also nlogn. 
    // nlogn + nlogn = 2nlog. So basically it is nlogn and space complexity O(n)
    public int minMeetingRoomsAlternate(int[][] intervals) {
        sortIntervals(intervals);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int meetingStartTime = intervals[i][0];
            int meetingEndTime = intervals[i][1];
            int nextEndingMeetingEndTime = minHeap.peek();
            if (meetingStartTime >= nextEndingMeetingEndTime) {
                minHeap.poll();
            }
            minHeap.add(meetingEndTime);
        }
        
        return minHeap.size();
    }

    private void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int[] first, int[] second) {
                return Integer.compare(first[0], second[0]);
            }
        });
    }
}
