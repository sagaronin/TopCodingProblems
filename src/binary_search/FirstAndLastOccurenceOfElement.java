package binary_search;

import java.util.Arrays;

public class FirstAndLastOccurenceOfElement {
    public static void main(String[] args) {
        // find the first and last occurence of element in given array of sorted numbers
        // if only one then return - {first,first}
        // if multiple then return - {first, last}
        int arr[] = { 1, 2, 3, 3, 5, 8, 8, 8, 10, 10, 11 };
        System.out.println("Occurence: " + Arrays.toString(findBrute(arr,8)));
        System.out.println("Occurence(Optimal): " + Arrays.toString(bsearchOptimal(arr,10)));
    }

    //linear search - time complexity: O(n)
    public static int[] findBrute(int[] arr, int target) {
        int first=-1, last=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                if(first==-1)
                    first=i;
                last=i;
            }
        }
        int ans[]={first, last};
        return ans;
    }
    public static int[] bsearchBetter(int[] arr, int target) {
        int lowerBound =LowerBound.lowerBound(arr, target);
        if(lowerBound==arr.length || arr[lowerBound]!=target) return new int[]{-1,-1};
        int upperBound = UpperBound.upperBound(arr, target);
        int ans[]={lowerBound,upperBound};
        return ans;
    }

    public static int[] bsearchOptimal(int[] arr, int target) {
        int firstOcccurence =firstOccurence(arr, target);
        if(firstOcccurence==-1) return new int[]{-1,-1};
        int lastOcccurence = lastOccurence(arr, target);
        int ans[]={firstOcccurence,lastOcccurence};
        return ans;
    }

    public static int firstOccurence(int[] arr, int target){
        int low=0, high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                ans=mid;
                high=mid-1;
            } else if(target > arr[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return ans;
    }
    public static int lastOccurence(int[] arr, int target){
        int low=0, high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                ans=mid;
                low=mid+1;
            } else if(target > arr[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return ans;
    }
}
