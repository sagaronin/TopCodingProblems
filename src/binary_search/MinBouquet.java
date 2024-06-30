package binary_search;

public class MinBouquet {
    public static void main(String[] args) {
        // Return the minimum integer K such that
        // Koko can eat all bananas in H hours
        int bloomingDays[] = { 7,7,7,7,13,11,12,7 };
        System.out.println("Min Bouquet : " + findMinBouquetBrute(bloomingDays, 2,3));
    }
    public static int findMinBouquetBrute(int arr[], int noOfBouquets, int adjacent){
        for (int i = getMinValue(arr); i <= getMaxValue(arr); i++) {
            if(possibleCombination(arr, i, noOfBouquets, adjacent)==true)
                return i;
        }
        return -1;
    }
    public static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    
    // getting the miniumum value
    public static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
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
}
