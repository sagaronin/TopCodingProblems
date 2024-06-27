package binary_search;

public class FindNthRoot {
    public static void main(String[] args) {
        int elmnt1 = 27;
        int elmnt2 = 69;
        System.out.println("Nth root of given element is(Linear Search) : " + (findNthRootLS(elmnt1, 3)));
        System.out.println("Peak element is(Binary Search) : " + (findNthRootBS(elmnt2, 4)));
    }

    public static int findNthRootLS(int elmnt1, int root) {
        int ans = 1;
        for (int i = 1; i < elmnt1; i++) {
            if (Math.pow(i, root) <= elmnt1)
                ans = i;
            else
                break;
        }
        return ans;
    }

    public static int findNthRootBS(int elmnt2, int root) {
        int low = 1, high = elmnt2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int isNthRoot = findPower(mid, root, elmnt2);
            if (isNthRoot == 1)
                return mid;
            else if (isNthRoot == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int findPower(int mid, int pow, int element) {
        double ans = 1;
        for (int i = 0; i < pow; i++) {
            ans = ans * mid;
            if (ans > element)
                return 2;
        }
        if (ans == element)
            return 1;
        return 0;
    }

}
