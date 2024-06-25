package binary_search;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 7,8,1,2,3,4,5,6 };
        System.out.println("Minimum Element: " + findMinimumInRotatedSortedArray(arr));
    }

    public static int findMinimumInRotatedSortedArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans= Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            /*
             Basic ide over here is to two step
             1. Find the half which is sorted
             2. Now you have the sorted half. it will be easier to check within the bounds of sorted
             half where exactly is the target element.
             3. whichever half is sorted just take the minimum element from that half and discard that half.
             */

            // when left half is sorted
            if (arr[low] <= arr[mid]) {
                //store the minimum value from lefft half in answer and discard left half
                if (arr[low] < ans) {
                    ans= arr[low];
                }
                low=mid+1;
            }
            // when right half is sorted
            else {
                //store the minimum value from right half in answer and discard right half
                if (arr[mid] < ans) {
                    ans= arr[mid];
                }
                high=mid-1;
            }
        }
        return ans;
    }
}
