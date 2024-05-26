package arrays_strings.meeting_room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "Interval [start=" + start + ", end=" + end + "]";
    }

}

public class MinMeetingRoomRequired {
    /*
     * Given an array of meeting time intervals intervals where intervals[i] =
     * [starti, endi], return the minimum number of conference rooms required.
     * 
     * Example 1:
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: 2
     * 
     * Example 2:
     * Input: intervals = [[7,10],[2,4]]
     * Output: 1
     */
    public static void main(String[] args) {
        int[] start = { 0, 5, 15 };
        int end[] = { 30, 10, 20 };
        List<Interval> intervals = new ArrayList<>();
        // Input: intervals = [[0,30],[5,10],[15,20]]
        for (int i = 0; i < start.length; i++) {
            intervals.add(new Interval(start[i], end[i]));
        }
        // output: 2
        System.out.println(minMeetingRoomRequired(intervals));

        // Input: intervals = [[7,10],[2,4]]
        int[] start2 = { 7, 2 };
        int end2[] = { 10, 4 };
        List<Interval> intervals2 = new ArrayList<>();
        for (int i = 0; i < start2.length; i++) {
            intervals2.add(new Interval(start2[i], end2[i]));
        }
        // output: 1
        System.out.println(minMeetingRoomRequired(intervals2));

        // Input: intervals = [[7,10],[2,4]]
        int[] start3 = { 0, 5, 15, 40, 50, 61 };
        int end3[] = { 5, 10, 25, 60, 65, 64 };
        List<Interval> intervals3 = new ArrayList<>();
        for (int i = 0; i < start3.length; i++) {
            intervals3.add(new Interval(start3[i], end3[i]));
        }
        // output: 2
        System.out.println(minMeetingRoomRequired(intervals3));

    }

    public static int minMeetingRoomRequired(List<Interval> intervals) {
        Collections.sort(intervals,
                (Interval interval1, Interval interval2) -> interval1.start > interval2.start ? 1 : -1);
        System.out.println("Sorted");
        System.out.println(intervals);
        //priority queue is a DS which always holds value in ascending order
        // we will be using it to hold the end times of meetings
        //hence at top of this queue we will always have a meetign which is going  to end next.
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (p.peek() <= intervals.get(i).start)
                p.remove();
            p.add(intervals.get(i).end);
        }

        return p.size();
    }
}
