package binary_search;

public class MinBouquet {
    public static void main(String[] args) {
        // Return the minimum integer K such that
        // Koko can eat all bananas in H hours
        int bloomingDays[] = { 7, 7, 7, 7, 13, 11, 12, 7 };
        System.out.println("Min Bouquet(Brute Force) : " + findMinBouquetBrute(bloomingDays, 2, 3));
        System.out.println("Min Bouquet(Binary Search) : " + findMinBouquetBS(bloomingDays, 2, 3));
    }

    public static int findMinBouquetBrute(int arr[], int noOfBouquets, int adjacent) {
        int maxMin[] = getMaxMinValue(arr);
        for (int i = maxMin[1]; i <= maxMin[0]; i++) {
            if (possibleCombination(arr, i, noOfBouquets, adjacent) == true)
                return i;
        }
        return -1;
    }

    public static int[] getMaxMinValue(int[] array) {
        int maxValue = array[0];
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            } else if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return new int[] { maxValue, minValue };
    }

    public static boolean possibleCombination(int[] arr, int day, int noOfBouquet, int adjacentBoquets) {
        int count = 0, totalBouquet = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day)
                count++;
            else {
                count = 0;
                totalBouquet += count / adjacentBoquets;
            }

        }
        totalBouquet += count / adjacentBoquets;
        if (totalBouquet >= noOfBouquet)
            return true;
        else
            return false;
    }

    public static int findMinBouquetBS(int arr[], int noOfBouquets, int adjacent) {
        if (noOfBouquets * adjacent > arr.length)
            return -1;
        int maxMin[] = getMaxMinValue(arr);
        int  high = maxMin[0],low = maxMin[1];
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possibleCombination(arr, mid, noOfBouquets, adjacent) == true) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        return ans;
    }
}
