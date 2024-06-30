package binary_search;

public class KokoEatingBananas {
    public static void main(String[] args) {
        // Return the minimum integer K such that
        // Koko can eat all bananas in H hours
        int pile[] = { 3, 6, 7, 11 };
        System.out.println("Min no of bananas Koko can eat in H hours is : " + findMinNoOfBananas(pile, 8));
    }

    public static int findMinNoOfBananas(int[] arr, int hours) {
        int maxElement = findMaxElement(arr);
        int low = 1, high = maxElement, ans = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHoursTaken = findTotalHoursTakenToEatAllBananas(arr, mid);
            System.out.println("total hours taken to eat all bananas in h hours [ totalhours,h ] : [ "+totalHoursTaken+","+mid+" ]");
            if (totalHoursTaken <= hours) {
                ans = mid;
                high = mid - 1;
            } else
            low = mid + 1;
                
        }
        return ans;
    }

    private static int findTotalHoursTakenToEatAllBananas(int[] arr, int mid) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans + (int) Math.ceil(arr[i] / mid);
        }
        return ans;
    }

    private static int findMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max)
                max = arr[i];
        }
        return max;
    }

}
