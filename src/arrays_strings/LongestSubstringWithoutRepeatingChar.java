package arrays_strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String sample = "pwwwwkewp";
        System.out.println("Longest Substring Without Repeating Characters(BruteForce) : "
                +
                LongestSubstringWithoutRepeatingChar.logenstSubstringWithoutRepeatingCharBruteForce(sample));
        System.out.println("Longest Substring Without Repeating Characters(Better) : "
                + LongestSubstringWithoutRepeatingChar.logenstSubstringWithoutRepeatingCharBetter(sample));

        System.out.println("Longest Substring Without Repeating Characters(BruteForce new) : "
                +
                LongestSubstringWithoutRepeatingChar.bruteForce(sample));
        System.out.println("Longest Substring Without Repeating Characters(optimized) : "
                + LongestSubstringWithoutRepeatingChar.optimized(sample));

    }

    public static int logenstSubstringWithoutRepeatingCharBruteForce(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] hash = new int[256];
            int len = 0;
            for (int j = i; j < str.length(); j++) {
                if (hash[str.charAt(j)] == 1)
                    break;
                len = j - i + 1;
                hash[str.charAt(j)] = 1;
            }
            max = Integer.max(max, len);
        }
        return max;
    }

    public static int logenstSubstringWithoutRepeatingCharBetter(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int l = 0, r = 0, max = 0;
        Set<Character> set = new HashSet<Character>();
        while (r < str.length()) {
            char ch = str.charAt(r);
            while (set.contains(ch)) {
                set.remove(str.charAt(l));
                l++;
            }
            set.add(ch);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static int bruteForce(String str) {
        if (str.isEmpty() || str == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            int charsCount[] = new int[256];
            int len = 0;
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                // check if this character already exist in int array
                // if yes then break out of this loop
                if (charsCount[ch] == 1) {
                    break;
                }
                // if not then count the length of current sub string and store it
                // and add this char to int array
                len = j - i + 1;
                charsCount[ch] = 1;
            }
            // after you come out of for loop, store whichever is
            // the max value between len and max in the max variable
            max = Math.max(len, max);
        }

        return max;
    }

    public static int optimized(String str) {
        // pwwwkewp
        int max = 0, l = 0, r = 0;
        if (str.isEmpty() || str == null)
            return max;

        Set<Character> charCount = new HashSet<>();
        while (r < str.length()) {
            char ch = str.charAt(r);
            while (charCount.contains(ch)) {
                charCount.remove(str.charAt(l));
                l++;
            }
            charCount.add(ch);
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
