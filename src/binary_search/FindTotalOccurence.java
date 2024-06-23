package binary_search;

import java.util.Arrays;

//find total occurence of an element in sorted array
public class FindTotalOccurence {
    public static void main(String[] args) {
        // find the first and last occurence of element in given array of sorted numbers
        // if only one then return - {first,first}
        // if multiple then return - {first, last}
        int arr[] = { 1, 2, 3, 3, 5, 8, 8, 8, 8,10, 10, 11 };
        System.out.println("Total Occurence: " +findTotalOccurence(arr,8));
    }
    public static int findTotalOccurence(int[] arr, int target) {
        int firstOcccurence =firstOccurence(arr, target);
        if(firstOcccurence==-1) return -1;
        int lastOcccurence = lastOccurence(arr, target, firstOcccurence);
        return lastOcccurence-firstOcccurence+1;
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
    public static int lastOccurence(int[] arr, int target, int firstOccurence){
        int low=firstOccurence, high=arr.length-1;
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
