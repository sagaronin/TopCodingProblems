package arrays_strings.twoD_array;


public class CultivateGoodLand {
    //return the maximum good land(marked by 1)which can be cultivated by farmer.
    // the land has to be in form of square
    public static void main(String[] args) {
        int land[][] = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 0, 1, 1 } };
        System.out.println("Max good land length which can be cultivated is: " + cultivateGoodLand(land));

    }

    public static int cultivateGoodLand(int[][] land) {
        int maxLength = -1;
        int dp[][] = new int[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            System.out.print("DP[" + i + "]" + "[j]: ");
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    System.out.print(dp[i][j]);
                    continue;
                }
                int left = 0, right = 0, diagonal = 0;
                if (i > 0)
                    left = dp[i - 1][j];
                if (j > 0)
                    right = dp[i][j - 1];
                if (i > 0 && j > 0)
                    diagonal = dp[i - 1][j - 1];
                dp[i][j] = Math.min(left, Math.min(right, diagonal)) + 1;
                System.out.print(dp[i][j]);
                maxLength = Math.max(maxLength, dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return maxLength;

    }
}
