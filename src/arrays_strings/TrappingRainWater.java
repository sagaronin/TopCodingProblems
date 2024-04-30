package arrays_strings;

public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Max trapped rainwater is(Brute Force) : " + TrappingRainWater.trappingRWBruteForce(arr));
        System.out.println("Max trapped rainwater is(Better) : " + TrappingRainWater.trappingRWBetter(arr));
        System.out.println("Max trapped rainwater is(Optimal) : " + TrappingRainWater.trappingRWBruteForce(arr));
    }

    public static int trappingRWBruteForce(int[] arr) {
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        int min[] = new int[arr.length];
        int lmax = arr[0], rmax = arr[arr.length - 1], count = 0;
        ;
        for (int i = 0; i < arr.length; i++) {
            if (lmax < arr[i]) {
                lmax = arr[i];
            }
            leftMax[i] = lmax;
            if (rmax < arr[arr.length - i - 1]) {
                rmax = arr[arr.length - i - 1];
            }
            rightMax[arr.length - i - 1] = rmax;
        }
        for (int i = 0; i < min.length; i++) {
            min[i] = Math.min(leftMax[i], rightMax[i]);
            count += min[i] - arr[i];
        }
        return count;
    }

    public static int trappingRWBetter(int[] arr) {
        int l = 0, r = arr.length - 1;
        int leftMax = arr[l];
        int rightMax = arr[r];
        int count = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                count+=leftMax -arr[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                count+=rightMax -arr[r];
            }
        }
        return count;
    }
}
