package arrays_strings;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int arr[] = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println("Three Sum Closest is (Brute Force) : " + ThreeSumClosest.threeSumClosestBrute(arr, target));
        System.out.println("Three Sum Closest is (Optimal) : " + ThreeSumClosest.threeSumClosestOptimal(arr, target));
    }

    public static int threeSumClosestBrute(int[] arr, int target) {
        int sum = arr[0] + arr[1] + arr[2];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int add = arr[i] + arr[j] + arr[k];
                    int distanceFromTarget = Math.abs(add - target);
                    if (distanceFromTarget < minDiff) {
                        sum = add;
                        minDiff = distanceFromTarget;
                    }
                }
            }
        }
        return sum;
    }

    public static int threeSumClosestOptimal(int[] arr, int target) {
        int ans = arr[0] + arr[1] + arr[2];
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int l = i+1, r = arr.length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target)
                    return sum;
                if (sum < target)
                    l++;
                else
                    r--;
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    ans = sum;
                    minDiff = diff;
                }
            }
        }
        return ans;
    }
}
