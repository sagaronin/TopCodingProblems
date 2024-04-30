package arrays_strings;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        // Output: [24,12,8,6]
        System.out.println(
                "Product array(brute Force) : " + Arrays.toString(ProductOfArrayExceptItself.productBruteForce(arr)));
        System.out.println(
                "Product array(Better) : " + Arrays.toString(ProductOfArrayExceptItself.productBetter(arr)));
        System.out.println(
                "Product array(Optimal) : " + Arrays.toString(ProductOfArrayExceptItself.productOptimal(arr)));
    }

    public static int[] productBruteForce(int arr[]) {
        int prod[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int multi = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;
                else {
                    multi *= arr[j];
                }
            }
            prod[i] = multi;
        }
        return prod;
    }

    public static int[] productBetter(int arr[]) {
        int prod[] = new int[arr.length];
        int multi = 1;
        for (int i = 0; i < arr.length; i++) {
            multi *= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            prod[i] = multi / arr[i];
        }
        return prod;
    }

    public static int[] productOptimal(int arr[]) {
        int prod[] = new int[arr.length];
        int pre = 1, post = 1;
        for (int i = 0; i < arr.length; i++) {
            prod[i] = pre;
            pre = arr[i] * pre;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            prod[i] = post * prod[i];
            post = arr[i] * post;
        }
        return prod;
    }
}
