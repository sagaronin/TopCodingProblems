package binary_search;

public class FindElementInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        System.out.println("Element index: " + findInRotatedSortedArray(arr, 1));
    }

    public static int findInRotatedSortedArray(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            /*
             Basic ide over here is to two step
             1. Find the half which is sorted
             2. Now you have the sorted half. it will be easier to check within the bounds of sorted
             half where exactly is the target element.
                2.i. if element does not exist in the bound of the sorted half then element exists in unsorted half,
                2.ii. else it exists in sorted half
             */
            // when left half is sorted
            if (arr[low] <= arr[mid]) {
                // check if element lies within the boundry of left half - low to mid
                if (arr[low] <= target && target <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // when right half is sorted
            else {
                // check if element lies within the boundry of right half - mid to high
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
