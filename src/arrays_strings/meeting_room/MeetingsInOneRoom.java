package arrays_strings.meeting_room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Meeting{
    int start;
    int end;
    int position;
    public Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
    @Override
    public String toString() {
        return "Meeting [start=" + start + ", end=" + end + ", position=" + position + "]";
    }
    

}
public class MeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int n = start.length;
        System.out.println("Max meetings which can be held in one meeting room are: "+maxMeetingsInOneRoom(start, end, n));
    }

    public static int maxMeetingsInOneRoom(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i+1));
        }
        Collections.sort(meetings, ( m1, m2)->{
            if(m1.end > m2.end)
                return 1;
            else if(m1.end < m2.end)
                return -1;
            else if(m1.position < m2.position)
                return -1;
            return 1;
            
        });
        meetings.forEach(meeting -> System.out.println(meeting));

        List<Integer> meetingOrder = new ArrayList<>();
        meetingOrder.add(meetings.get(0).position);
        int limit = meetings.get(0).end;
        for (int i = 1; i < n; i++) {
            if(meetings.get(i).start > limit){
                limit = meetings.get(i).end;
                meetingOrder.add(meetings.get(i).position);
            }
        }
        Collections.sort(meetingOrder);
        System.out.println("Meetings held in order: "+meetingOrder);
        return meetingOrder.size();
    }
}
