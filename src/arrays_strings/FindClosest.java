package arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosest {
    public static void main(String[] args) {
        int arr[]={1,1,2,3,4,5};
        int k=4,x=-1;
        System.out.println(Arrays.toString(FindClosest.findClosestElements(arr,k,x).toArray()));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int start = 0;
        int end = arr.length - 1;
        // Between the 'start' and 'end' pointers, inclusive, contains all the k integers that is closest to x.
        while (end - start >= k) {
            // Move 'start' to the right if 'end' is closer to x, or move 'end' to the left if 'start' is closer to x.
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        // Input all the k closest integers into the result.
        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
        
    }
}
