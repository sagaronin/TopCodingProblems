package Medium;

import java.util.Arrays;

public class LargestNumberFromArray {
    // Question
    /*
     * Given a list of non-negative integers nums, arrange them such that they form
     * the largest number and return it.
     * 
     * Since the result may be very large, so you need to return a string instead of
     * an integer.
     * 
     * Example 1:
     * 
     * Input: nums = [10,2]
     * Output: "210"
     * Example 2:
     * 
     * Input: nums = [3,30,34,5,9]
     * Output: "9534330"
     */

     public static void main(String[] args) {
        int nums[]={3,20,34,5,9,0};
        System.out.println("Largest number that could be formed from numbers in array is: "+largestNumber(nums));
     }
     public static String largestNumber(int[] nums){
        String []ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Integer.toString(nums[i]);
        }
        //Sort the numbers in string array by comparing their concatenated value
        //compare(a,b) ->Compares two strings lexicographically. The comparison is based on the Unicode value 
        //of each character in the strings. Hence it will return value in int. 'ans' array will be sorted 
        //with comparison of concatenation of two numbers.
        //Note: If (b+a) is lexicographically larger than (a+b), it returns a positive value, which tells 
        //the sort algorithm that b should be placed before a.
        Arrays.sort(ans,(a,b)->{ return (b+a).compareTo(a+b);});
        if(ans[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String string : ans) {
            sb.append(string);
        }
        return sb.toString();
     }
}
