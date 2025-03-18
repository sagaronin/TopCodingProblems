package arrays_strings.twoD_array;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // RotateImage.rotateImageBruteForce(arr);
        RotateImage.rotateImageOptimal(arr);
    }

    public static void rotateImageBruteForce(int arr[][]) {
        int temp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp[j][arr.length - i - 1] = arr[i][j];
            }
        }
        System.out.println("Rotate image by 90 degrees(Brute Force) : " + Arrays.deepToString(temp));
    }

    public static void rotateImageOptimal(int arr[][]) {
        // 2 step approach, which does not use extra space
        // step 1 - transpose matrix. makes row as column and column as row
        // step 2 - reverse the rows of genrated tranposed matrix

        // Step 1 - Transpose
        // rows will traverse from i=0 to i=n-2
        // column will traverse from j=i+1 to j=n-1
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                arr[i][j] = arr[i][j] + arr[j][i];
                arr[j][i] = arr[i][j] - arr[j][i];
                arr[i][j] = arr[i][j] - arr[j][i];
            }
        }

        // Step 2 - Reverse
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - j - 1];
                arr[i][arr.length - j - 1] = temp;
            }
        }
        System.out.println("Rotate image by 90 degrees(Optimal) : " + Arrays.deepToString(arr));
    }

}
