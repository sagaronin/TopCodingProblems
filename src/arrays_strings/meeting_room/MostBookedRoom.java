package arrays_strings.meeting_room;

import java.util.Arrays;

/*
You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

1.Each meeting will take place in the unused room with the lowest number.
2.If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
3.When a room becomes unused, meetings that have an earlier original start time should be given the room.
4.Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.

 

Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
 */
public class MostBookedRoom {
    public static void main(String[] args) {
        int interval[][]={{3,4},{0,10},{2,7},{1,5},{2,7}};
        System.out.println("Output[Meeting room number]: "+mostBookedRoom2(interval,2));

    }
    public static int mostBookedRoom(int[][] intervals, int n) {
        Arrays.sort(intervals,(a,b)->a[0]>b[0]?1:-1);
        System.out.println("Sorted: "+Arrays.deepToString(intervals));
        long[] roomAvailabilityTime = new long[n];
        int[] meetingCount = new int[n];
        for (int[] meeting : intervals) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            boolean foundUnUsedRoom = false;
            int minAvailableTimeRoom = 0;
            int minRoomAvailabilityTime = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                //check next available room availability time
                if(roomAvailabilityTime[i] <= startTime){
                    foundUnUsedRoom = true;
                    meetingCount[i]++;
                    roomAvailabilityTime[i] = endTime;
                    break;
                }
                //check which room has minimum end time and store it in variable
                if(minRoomAvailabilityTime > roomAvailabilityTime[i]){
                    minRoomAvailabilityTime = (int)roomAvailabilityTime[i];
                    minAvailableTimeRoom = i;
                }
            }
            // If no room is vacant then update the roomAvailabilityTime
            // array with room which has lowest end time by adding 
            // this meetings end time and subtract start time. 
            // And also update meetingCount of that (minAvailableTimeRoom)room.
            if(!foundUnUsedRoom){
                roomAvailabilityTime[minAvailableTimeRoom]+=endTime - startTime;
                meetingCount[minAvailableTimeRoom]++;
            }
        }
        int maxMeetingCount = 0, maxMeetingCountRoom=0;
        for (int i = 0; i < n; i++) {
            System.out.println("Max meeting count for room "+(i+1)+" is/are : "+meetingCount[i]);
            if(meetingCount[i]>maxMeetingCount){
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }
        return maxMeetingCountRoom;
    }

    public static int mostBookedRoom2(int[][] intervals, int n) {
        Arrays.sort(intervals,(a,b)->a[0]>b[0]?1:-1);
        System.out.println("Sorted: "+Arrays.deepToString(intervals));
        long[] roomAvailabilityTime = new long[n];
        int[] meetingCount = new int[n];
        for (int[] meeting : intervals) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            boolean foundUnUsedRoom = false;
            int minAvailableTimeRoom = 0;
            int minRoomAvailabilityTime = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                //check if any room available
                if(roomAvailabilityTime[i] <= startTime){
                    foundUnUsedRoom = true;
                    roomAvailabilityTime[i]= endTime;
                    meetingCount[i]++;
                    break;
                }
                //store the lowest end time meeting room and its availability time
                if(minRoomAvailabilityTime > roomAvailabilityTime[i]){
                    minRoomAvailabilityTime = (int) roomAvailabilityTime[i];
                    minAvailableTimeRoom = i;
                }
            }
            if(!foundUnUsedRoom){
                roomAvailabilityTime[minAvailableTimeRoom]+=endTime-startTime;
                meetingCount[minAvailableTimeRoom]++;
            }
        }
        int maxMeetingCount = 0, maxMeetingCountRoom=0;
        for (int i = 0; i < n; i++) {
            System.out.println("Max meeting count for room "+(i+1)+" is/are : "+meetingCount[i]);
            if(meetingCount[i] > maxMeetingCount){
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i+1;
            }
        }
        return maxMeetingCountRoom;
    }
    
}
