package binary_search;

public class SingleElementInSortedDuplicatesArray {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,5,5,6,6 };
        System.out.println("Single element is : " + (findSingleElement(arr)));
    }

    public static int findSingleElement(int[] arr) {
        // edge case for single element in array;
        if (arr.length == 1) {
            return arr[0];
        }
        // edge case for single element at boundaries(0 or n-1);
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int low = 1, high = arr.length - 2;
        int ans = -1;
        if (arr.length % 2 == 0)
            return ans;
        while (low <= high) {
            int mid = (low + high) / 2;
            /*
             * Basic idea of this whole algorithm is teh fact that there will always be odd
             * number of elements
             * (Since all numbers are twice except one).
             * We will be using this fact to devise the algorithm
             * we know array index start from zero hence we can assume all numbers are
             * even-odd pairs
             * The Single element can be anywhere in the array.
             * So next deduction we can make is that if single element is in between the
             * array, then
             * all elements on left of it will be in pairs of even-odd(since all other
             * numbers are in pairs).
             * So if we keep on checking if numbers on left and right of the mid are not
             * equal to mid then we can
             * come to answer.
             */
            // check if element at mid is your element or not by comparing it with neighbors
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];
            // check if the index mid is even or odd
            // also check which half you are on
            // arr[mid-1]==arr[mid] : this means you are on left left half when mid is odd
            // arr[mid]==arr[mid+1] : this means you are on left half when mid is even
            else if ((mid % 2 == 1 && arr[mid - 1] == arr[mid]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1]))
                low = mid + 1;
            else
                high = mid - 1;

        }
        return ans;
    }
}
