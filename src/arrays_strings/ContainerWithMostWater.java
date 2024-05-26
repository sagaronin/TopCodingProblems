package arrays_strings;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 1 };
        // System.out.println("Container with most water has area(Brute Force) : "
        // + ContainerWithMostWater.maxAreaBruteForce(height));

        System.out.println("Container with most water has area(Better) : "
                + ContainerWithMostWater.maxAreaBetter(height));

    }

    public static int maxAreaBruteForce(int height[]) {
        int maxArea = 0, area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static int maxAreaBetter(int height[]) {
        int area = 0, maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.min(height[r], height[l]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public static int optimized(int height[]) {
        int maxArea = 0, area = 0, l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.min(height[l],height[r]) * (r-l);
            maxArea = Math.max(area, maxArea);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
