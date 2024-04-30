package arrays_strings;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {
        String sample = "pwwkew";
        // System.out.println("Longest Substring Without Repeating Characters(Brute
        // Force) : "
        // +
        // LongestSubstringWithoutRepeatingChar.logenstSubstringWithoutRepeatingCharBruteForce(sample));
        System.out.println("Longest Substring Without Repeating Characters(Better) : "
                + LongestSubstringWithoutRepeatingChar.logenstSubstringWithoutRepeatingCharBetter(sample));

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
            while(set.contains(ch)){
                set.remove(str.charAt(l));
                l++;
            }
            set.add(ch);
            max=Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
