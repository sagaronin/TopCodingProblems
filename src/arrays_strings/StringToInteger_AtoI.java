package arrays_strings;

public class StringToInteger_AtoI {
    public static void main(String[] args) {
        String num = "1234asd1234";
        System.out.println("A to I (Brute Force) : " + StringToInteger_AtoI.atoiBrute(num));
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

    public static int stringToInteger(String str) {
        long result = 0;
        int sign = 1, i = 0;
        if (str.isEmpty() || str == null)
            return (int) result;
        str = str.stripLeading();
        if (str.charAt(i) == -1) {
            sign = -1;
            i++;
        } else if (str.charAt(i) == 1) {
            i++;
        }
        while (i < str.length()) {
            if (str.charAt(i) == ' ')
                break;
            else {
                int num = str.charAt(i) - '0';
                if (num >= 0 || num <= 9) {
                    result = result * 10 + num;
                    if (sign ==-1 && result * -1 < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    if (sign ==1 && result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
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
