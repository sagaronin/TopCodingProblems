package binary_search;

public class FindElementInRotatedSortedArrayWithDuplicates {
    public static void main(String[] args) {
        int arr[] = { 3,1,2,3,3,3,3 };
        System.out.println("Element exists?: " + findInRotatedSortedArrayWithDuplicates(arr, 1));
    }

    public static boolean findInRotatedSortedArrayWithDuplicates(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            }
            //this is main thing in rotated sorted array with duplicates
            //your earlier logic wont work if there are duplicates.
            //The issue with earlier logic is if the low, mid and high are pointing to same element(duplicate)
            //then algorithm fails
            // so the solution is you need to skip the elements at those locations and continue with next iteration.
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                System.out.println("inside all same");
                continue;
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
        return false;
    }
}
