package arrays_strings;

public class AtoI {
    public static void main(String[] args) {
        String num = "-2147483648";
        System.out.println("A to I (Brute Force) : " + AtoI.atoiBrute(num));
    }

    public static int atoiBrute(String str) {
        long result = 0;
        int sign = 1;
        int i = 0;
        str = str.stripLeading();
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;
        if (str == null || str.length() == 0) {
            return (int) result;
        }
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                break;
            } else {
                int num = str.charAt(i) - '0';
                if (num >= 0 && num <= 9) {
                    result = (result * 10) + num;
                    if (sign == -1 && -1 * result < MIN)
                        return MIN;
                    if (sign == 1 && result > MAX)
                        return MAX;
                    i++;
                } else {
                    break;
                }
            }
        }
        result = result * sign;
        return (int) result;
    }
}
