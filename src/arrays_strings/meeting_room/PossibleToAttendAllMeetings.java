package arrays_strings.meeting_room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PossibleToAttendAllMeetings {
    /*
     * Given an array of meeting time intervals where intervals[i] = [starti, endi],
     * determine if a person could attend all meetings.
     * 
     * Example 1:
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: false
     * 
     * Example 2:
     * Input: intervals = [[7,10],[2,4]]
     * Output: true
     */
    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>();
        // Input: intervals = [[0,30],[5,10],[15,20]]
        intervals.add(Arrays.asList(15, 20));
        intervals.add(Arrays.asList(5, 10));
        intervals.add(Arrays.asList(0, 30));
        //output: false
        System.out.println(canAttendAllMeetings(intervals));

        // Input: intervals = [[7,10],[2,4]]
        List<List<Integer>> intervals2 = new ArrayList<>();
        intervals2.add(Arrays.asList(7,10));
        intervals2.add(Arrays.asList(2,4));
        //output: true
        System.out.println(canAttendAllMeetings(intervals2));

    }

    public static boolean canAttendAllMeetings(List<List<Integer>> intervals) {
        Collections.sort(intervals, (List<Integer> list1, List<Integer> list2) -> {
            if (list1.get(0) > list2.get(0))
                return 1;
            else if(list1.get(0) < list2.get(0))
                return -1;
            else
                return 0;
        });
        System.out.println("Sorted");
        System.out.println(intervals);
        for (int i = 0; i < intervals.size()-1; i++) {
            if(intervals.get(i).get(1) > intervals.get(i+1).get(0))
                return false;
        }

        return true;
    }
}
