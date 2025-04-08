package arrays_strings.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumProcessingTime {
    public static void main(String[] args) {
        List<Integer> processorTime = new ArrayList<>(Arrays.asList(8,10));
        List<Integer> tasks = new ArrayList<>(Arrays.asList(2,2,3,1,8,7,4,5));
        System.out.println("Minimus processing time: "+minProcessingTime(processorTime,tasks));
        
    }
public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        //basic idea is, in order to get the minimum time to complete all task is -
        // either execute task with min time with max processor time or other way round.
        // we will approach this with min processor time with max task execution time.
        //create a PQ for tasks and set sorting order to reverse.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        //sort the processor time in ascending order
        Collections.sort(processorTime);

        //now add all tasks to PQ, since PQ has sorting order in reverse it will store all element in descending order.
        for(int task:tasks){
            pq.add(task);
        }
        int ans=0;

        //now apply the logic to find min processing time needed to complete all tasks
        while(pq.size()>0){
            //There will always be four tasks which we will have to process since each processor has 4 cores.
            //max task time will always be the first from first four, i.e. 1,5,9... etc
            int tsk1=pq.poll();
            //remove the next three as we dont need them
            pq.poll();
            pq.poll();
            pq.poll();
            //get the first processing time.
            int processingTime = processorTime.get(0);
            ans=Math.max(ans, tsk1+processingTime);
            //Remove processing time from list, as we have processed it to get answer
            processorTime.remove(0);
        }
        return ans;
    }

}
