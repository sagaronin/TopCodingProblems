package arrays_strings.greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Jobs {
    int id;
    int profit;
    int deadline;

    public Jobs(int id, int deadline, int profit) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Id: " + id + " Dealine: " + deadline + " Profit: " + profit;
    }

}

public class JobSequencing {
    public static void main(String[] args) {
        ArrayList<Jobs> list = new ArrayList<>();
        list.add(new Jobs(1, 4, 20));
        list.add(new Jobs(2, 5, 60));
        list.add(new Jobs(3, 6, 70));
        list.add(new Jobs(4, 6, 65));
        list.add(new Jobs(5, 4, 25));
        list.add(new Jobs(6, 2, 80));
        list.add(new Jobs(7, 2, 10));
        list.add(new Jobs(8, 2, 22));
        System.out.println("max profit: "+JobSequencing.findMaxProfit(list));
    }

    public static int findMaxProfit(List<Jobs> list) {
        // sort the list accordsing to max profit
        Comparator<Jobs> profitComparator = (job1, job2) -> {
            if (job1.profit < job2.profit)
                return 1;
            else if (job1.profit > job2.profit)
                return -1;
            else
                return 0;
        };

        // sort the list
        // Collections.sort(list,profitComparator);
        Collections.sort(list, (job1, job2) -> {
            if (job1.profit < job2.profit)
                return 1;
            else if (job1.profit > job2.profit)
                return -1;
            else
                return 0;
        });
        System.out.println("Sorted List:");
        list.forEach(item -> System.out.println(item));
        int totalprofit=0,maxDeadline=-1,count=0;
        // Get the max deadline value
        for(int i=0;i<list.size();i++){
            maxDeadline=Math.max(list.get(i).deadline, maxDeadline);
        }
        //create a hash array to store the Job IDs of elements whose job is scheduled
        // initalize all the array with -1 at first
        System.out.println("max dedaline: "+maxDeadline);
        int hash[] = new int[maxDeadline+1];
        for(int i=0;i<hash.length;i++){
            hash[i]=-1;
        }

        for(int i=0;i<list.size();i++){
            for (int j = list.get(i).deadline; j >=0; j--) {
                if(hash[j]==-1){
                    count=count+1;
                    hash[j] = list.get(i).id;
                    totalprofit+=list.get(i).profit;
                    break;
                }
            }
        }
        System.out.println("Count of jobs: "+count);
        return totalprofit;
    }

}
