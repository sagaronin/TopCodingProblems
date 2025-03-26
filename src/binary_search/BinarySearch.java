package binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        // things to note about binary search is that wherever you are doing b-search your data structure needs to be in
        //"SORTED ORDER"
        //and after that you try to find the target number by confining your search space
        //using low and high bounds. you take mid and compare it with target, if target is greater than mid, then you update your search space
        //by updating your lower bound to be mid+1, else you update your high bound to be mid-1.
        int arr[] = { 3 };
        System.out.println("Element: " + bsearch(arr, 6));
        System.out.println("Element: " + bsearchRecursive(arr, 0, arr.length-1, 13));
    }

    public static int bsearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int bsearchRecursive(int[] arr, int low, int high, int target) {
        if(low>high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return arr[mid];
        else if (arr[mid] < target)
            return bsearchRecursive(arr, mid + 1, high, target);
        else
            return bsearchRecursive(arr, low, mid - 1, target);
    }
}
