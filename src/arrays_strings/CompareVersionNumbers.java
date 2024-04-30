package arrays_strings;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        // If version1 < version2, return -1.
        // If version1 > version2, return 1.
        // Otherwise, return 0.
        String version1 = "2.5.33", version2 = "2.05.033.0.0.0";
        System.out.println(
                "Comparison output: " + CompareVersionNumbers.compareVersionNumbersOptimal(version1, version2));
    }

    private static int compareVersionNumbersOptimal(String version1, String version2) {
        int v1Len = version1.length(), v2Len = version2.length();
        int i = 0, j = 0;
        while (i < v1Len || j < v2Len) {
            int n1 = 0, n2 = 0;
            // get first number from version 1 string
            while (i< v1Len && version1.charAt(i) != '.') {
                n1 = n1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            // get second number from version 2 string
            while (j< v2Len && version2.charAt(j) != '.') {
                n2 = n2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            if (n1 < n2) {
                return -1;
            } else if (n1 > n2) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;

    }

}
