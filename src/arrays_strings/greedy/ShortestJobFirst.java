package arrays_strings.greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        int processesTime[] = { 4,3,7,1,2 };
        System.out.println(ShortestJobFirst.findAverageWaitingTime(processesTime));
    }

    public static int findAverageWaitingTime(int[] processesTime) {
        int time=0,waitingTime=0;
        Arrays.sort(processesTime);
        for (int i = 0; i < processesTime.length; i++) {
            waitingTime+=time;
            time+=processesTime[i];
            
        }
        /*
         * time=0,waitime=0
         * Arrays.sort(processesTime) = { 1,2,3,4,7 };
         * processesTime[0]=1,waitime=0, time=1
         * processesTime[1]=2,waitime=1, time=3
         * processesTime[2]=3,waitime=4, time=6
         * processesTime[3]=4,waitime=10, time=10
         * processesTime[4]=7,waitime=20, time=17
         */
       
        return (waitingTime/processesTime.length);
    }
}
