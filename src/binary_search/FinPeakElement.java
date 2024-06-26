package binary_search;

public class FinPeakElement {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };
        int arr1[] = { 1, 10, 13, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.println("Peak element is(Linera Search) : " + (findPeakElementLS(arr)));
        System.out.println("Peak element is(Binary Search) : " + (findPeakElementBS(arr1)));
    }

    public static int findPeakElementLS(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if ((i == 0 || arr[i - 1] < arr[i]) && (i == (arr.length - 1) || arr[i] > arr[i + 1]))
                return arr[i];
        }
        return -1;
    }

    public static int findPeakElementBS(int[] arr) {
        int low = 1, high = arr.length - 2;
        int ans = -1;
        if (arr.length == 1)
            return arr[0];
        if (arr[0] > arr[1])
            return arr[0];
        else if (arr[arr.length - 1] > arr[arr.length - 2])
            return arr[arr.length - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            /*
             * Basic idea of this whole algorithm is teh fact that there will always be a
             * peak element.
             * all elements on left and right of peak are smaller than peak element.
             */
            // check if the element at mid is your element or not by comparing it with
            // neighbors
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return arr[mid];
            else if (arr[mid] > arr[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;

        }
        return ans;
    }
}
