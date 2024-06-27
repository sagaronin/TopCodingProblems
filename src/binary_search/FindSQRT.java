package binary_search;

public class FindSQRT {
    public static void main(String[] args) {
        int elmnt1 = 25;
        int elmnt2 = 36;
        System.out.println("Sqrt of given element is(Linera Search) : " + (findSQRTLS(elmnt1)));
        System.out.println("Peak element is(Binary Search) : " + (findSQRTBS(elmnt2)));
    }

    public static int findSQRTLS(int elmnt1) {
        int ans = 1;
        for (int i = 1; i < elmnt1; i++) {
            if ((i * i) <= elmnt1)
                ans = i;
            else
                break;
        }
        return ans;
    }

    public static int findSQRTBS(int elmnt2) {
        int low = 1, high = elmnt2;
        int ans = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid * mid) <= elmnt2) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
}
