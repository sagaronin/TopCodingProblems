package binary_search;

public class InsertPostion {
    public static void main(String[] args) {
        // things to note about binary search is that wherever you are doing b-search
        // your data structure needs to be in
        // "SORTED ORDER"
        // and after that you try to find the target number by confining your search
        // space
        // using low and high bounds. you take mid and compare it with target, if target
        // is greater than mid, then you update your search space
        // by updating your lower bound to be mid+1, else you update your high bound to
        // be mid-1.
        int arr[] = { 1, 2, 3, 5, 8, 10, 11 };
        System.out.println("Insert/Actual position of Target is : " + lowerBound(arr, 9));
    }

    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid = (low + high) / 2;
        int ans = arr.length;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        return ans;
    }
}
