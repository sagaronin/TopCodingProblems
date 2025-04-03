package arrays_strings.greedy;

import java.util.Arrays;

public class GreedyCookies {
    public static void main(String[] args) {
        int greed[] = { 1, 5, 3, 3, 4 };
        int size[] = { 4, 2, 1, 2, 1, 3 };
        GreedyCookies.assignCookies(greed, size);
    }

    public static void assignCookies(int[] greed, int[] size) {
        int n = greed.length, m = size.length, l = 0, r = 0;
        // sort greed and size array in ascending order
        Arrays.sort(greed);
        Arrays.sort(size);
        var cookiesAssigned = new int[n];
        while (l < m) {
            if (size[l] >= greed[r]) {
                cookiesAssigned[r] = size[l];
                r++;
            }
            l++;
        }
        System.out.println("Total satisfied children: "+r);
        for (int i=0;i<cookiesAssigned.length;i++) {
            System.out.println("Children: "+(i+1)+" Gets Cookies: "+cookiesAssigned[i]);
        }
    }
}
